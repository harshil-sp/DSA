package Graphs.Helper;

public interface Graph {
    public static final int UN_DIRECTED = 0;
    public static final int DIRECTED = 1;

    /**
     * This method will be used to make a new edge connecting vertices, a and b both together.
     * */
    public void addEdge(int a, int b);

    /**
     * This method will be used to show the final connections of a graph. Which are all the vertices connected together?
     * */
    public void showGraph();

}
