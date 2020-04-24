package graph;

/**
 * @author Leron
 * @version 1.0.0
 * @create 2020/4/21 14:44
 */
public class Main {
    public static void main(String[] args) {
        SparseGraph g = new SparseGraph(7, false);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(0, 6);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.show();


        DFSPath<SparseGraph> dfsPath = new DFSPath<>(g, 0);
        dfsPath.showPath(6);

        ShortestPath<Graph> shortestPath = new ShortestPath<>(g, 0);
        shortestPath.showPath(6);

        System.out.println("-------------------");
        DenseGraph g2 = new DenseGraph(7, false);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 5);
        g2.addEdge(0, 6);
        g2.addEdge(3, 4);
        g2.addEdge(3, 5);
        g2.addEdge(4, 5);
        g2.addEdge(4, 6);
        g2.show();

        DFSPath2<DenseGraph> dfsPath2 = new DFSPath2<>(g2, 0);
        dfsPath2.showPath(6);

        ShortestPath2<Graph> shortestPath2 = new ShortestPath2<>(g2, 0);
        shortestPath2.showPath(6);

    }
}

/*
7 8
0 1
0 2
0 5
0 6
3 4
3 5
4 5
4 6
 */
