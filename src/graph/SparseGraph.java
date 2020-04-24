package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 稀疏图——邻接表
 *
 * @author Leron
 * @version 1.0.0
 * @create 2020/4/21 13:31
 */
public class SparseGraph implements Graph {
    private int n; // 图中点数
    private int m; // 途中边数
    boolean directed; // 是否为有向图
    private List<List<Integer>> g; // 从一个点到其他点的列表

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new LinkedList<>());
        }
    }

    public List<List<Integer>> getG() {
        return g;
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        g.get(v).add(w);
        if (v != w && !directed) {
            g.get(w).add(v);
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        for (int i = 0; i < g.get(v).size(); i++) {
            if (g.get(v).get(i) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for(int i = 0; i < n; i++) {
            System.out.print(i + ":");
            g.get(i).forEach(System.out::print);
            System.out.println();
        }
    }

}
