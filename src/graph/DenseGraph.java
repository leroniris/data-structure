package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 稠密图——邻接矩阵
 *
 * @author Leron
 * @version 1.0.0
 * @create 2020/4/21 13:32
 */
public class DenseGraph implements Graph {
    private int n;
    private int m;
    private boolean directed;
    private List<List<Integer>> g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                list.add(0);
            }
            g.add(list);
        }
    }

    @Override
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
        g.get(v).set(w, 1);
        if (v != w && !directed) {
            g.get(w).set(v, 1);
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);
        return g.get(v).get(w - 1) == 1 ? true : false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ":");
            g.get(i).forEach(System.out::print);
            System.out.println();
        }
    }

}
