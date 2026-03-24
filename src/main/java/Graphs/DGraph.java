package Graphs;

import Graphs.Helper.DirectedGraph;
import Graphs.Helper.UndirectedGraph;
import Graphs.Painter.PaintBoard;
import Graphs.Painter.Painter;
import Helper.InterfaceMaker;

import java.io.BufferedReader;
import java.io.IOException;

public class DGraph {

    public static void main(String[] args) throws IOException {
        InterfaceMaker Interface = new InterfaceMaker("Graphs//Inputs");
        BufferedReader scanner = new BufferedReader(Interface.getFile("DGraph.txt"));
        Painter painter;

        String[] data = scanner.readLine().split(" ");
        int noOfVertices = Integer.parseInt(data[0]);
        int noOfEdges = Integer.parseInt(data[1]);

        DirectedGraph g = new DirectedGraph(noOfVertices,UndirectedGraph.ADJ_LIST);
        for (int i=0; i<noOfEdges; i++) {
            String[] inputEdge = scanner.readLine().split(" ");
            g.addEdge(Integer.parseInt(inputEdge[0]),Integer.parseInt(inputEdge[1]));
        }
        scanner.close();

        g.showGraph();
        painter = new Painter(g, 700,700);
        PaintBoard board = new PaintBoard(painter, "Directed Graph Design");
        board.showBoard();
    }

}
