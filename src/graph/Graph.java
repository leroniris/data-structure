package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Leron
 * @version 1.0.0
 * @create 2020/4/21 13:53
 */
public interface Graph {

    List<List<Integer>> getG();

    int V();

    int E();

    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    void show();
}
