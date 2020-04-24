package graph;

import java.util.*;

/**
 * 广度优先遍历最短路径
 *
 * @author Leron
 * @version 1.0.0
 * @create 2020/4/21 14:54
 */
public class ShortestPath2<T extends Graph> {
    private T g;
    private int s;
    private int from[];
    private boolean visited[];
    private int ord[]; // 计算路径的长度

    public ShortestPath2(T g, int s) {
        assert s >= 0 && s < g.V();
        this.g = g;
        this.visited = new boolean[g.V()];
        this.from = new int[g.V()];
        this.ord = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;

        Queue<Integer> q = new ArrayDeque<>();

        // 无向图最短路径算法
        q.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!q.isEmpty()) {
            int v = ((ArrayDeque<Integer>) q).pop();
            int size = g.V();

            for (int i = 0; i < size; i++) {
                int value = g.getG().get(v).get(i);
                if (!visited[i] && value == 1) {
                    q.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
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
