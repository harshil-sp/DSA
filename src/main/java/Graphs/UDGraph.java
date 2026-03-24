package Graphs;

import Graphs.Helper.UndirectedGraph;
import Graphs.Painter.PaintBoard;
import Graphs.Painter.Painter;
import Helper.InterfaceMaker;

import java.io.BufferedReader;
import java.io.IOException;

public class UDGraph {
    public static void main(String[] args) throws IOException {
        InterfaceMaker Interface = new InterfaceMaker("Graphs//Inputs");
        BufferedReader scanner = new BufferedReader(Interface.getFile("UDGraph2.txt"));

        String[] data = scanner.readLine().split(" ");
        int noOfVertices = Integer.parseInt(data[0]);
        int noOfEdges = Integer.parseInt(data[1]);

        UndirectedGraph g = new UndirectedGraph(noOfVertices,UndirectedGraph.ADJ_LIST);
        for (int i=0; i<noOfEdges; i++) {
            String[] inputEdge = scanner.readLine().split(" ");
            g.addEdge(Integer.parseInt(inputEdge[0]),Integer.parseInt(inputEdge[1]));
        }
        scanner.close();

        g.showGraph();
        Painter painter = new Painter(g,500,500);
        PaintBoard board = new PaintBoard(painter,"Graph Design");
        board.showBoard();
        System.out.println(g.getDFS(3));
    }
}
