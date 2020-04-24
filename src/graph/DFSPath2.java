package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Leron
 * @version 1.0.0
 * @create 2020/4/21 13:53
 */
public class DFSPath2<T extends Graph> {
    private T g; // 图
    private int s; // 起点
    private boolean visited[]; // 记录是否已经走过的节点
    private int from[]; // 记录节点的开始点

    public DFSPath2(T g, int s) {
        this.g = g;
        assert s >= 0 && s < g.V();
        visited = new boolean[g.V()];
        from = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;

        // 寻路算法
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        int size = g.V();
        for (int i = 0; i < size; i++) {
            int value = g.getG().get(v).get(i);
            if (!visited[i] && value == 1) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    public boolean hasPath(int w) {
        assert (w >= 0 && w < g.V());
        return visited[w];
    }

    public void path(int w, List<Integer> vec) {

        Stack<Integer> stack = new Stack<>();

        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }

        vec.clear();
        while (!stack.empty()) {
            vec.add(stack.peek());
            stack.pop();
        }
    }

    void showPath(int w) {

        List<Integer> vec = new LinkedList<>();
        path(w, vec);
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.get(i));
            if (i == vec.size() - 1) {
                System.out.println();
            } else {
                System.out.print(" -> ");
            }
        }
    }
}
