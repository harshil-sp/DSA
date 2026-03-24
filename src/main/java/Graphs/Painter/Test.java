package Graphs.Painter;

import Graphs.Helper.UndirectedGraph;
import Helper.InterfaceMaker;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Test extends JFrame {



    public static void main(String[] args) throws IOException {


        InterfaceMaker ifm = new InterfaceMaker("Graphs\\Inputs");
        BufferedReader scanner = new BufferedReader(ifm.getFile("GeneralGraph.txt"));

        int T = Integer.parseInt(scanner.readLine());
        while (T-- > 0) {
            String[] input = scanner.readLine().split(" ");
            UndirectedGraph graph = new UndirectedGraph(Integer.parseInt(input[0]), UndirectedGraph.ADJ_LIST);
            for (int i=0; i<Integer.parseInt(input[1]); i++) {
                String[] edge = scanner.readLine().split(" ");
                graph.addEdge(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]));

            }
            Painter p = new Painter(graph, 700, 700);
            p.paintGraph();
            new Test(p);
        }



    }

    public Test(Canvas c) {
        setLayout(new BorderLayout());
        setSize(700, 700);
        setTitle("Graph Painter");
        add("Center", c);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
