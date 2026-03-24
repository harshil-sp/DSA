package Graphs.Painter;

import Graphs.Helper.DirectedGraph;
import Graphs.Helper.Graph;
import Graphs.Helper.UndirectedGraph;
import Graphs.Helper.WeightedGraph;
import Graphs.Painter.Drawable.CircleNode;
import Graphs.Painter.Drawable.LineEdge;
import Graphs.Painter.Drawable.PointerEdge;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Painter extends Canvas {

    // don't know when i created undirected option, that's why it is one...
    private static final int UNDIRECTED = 1;
    // date when the directed option graph option was initialized to created...
    private static final int DIRECTED = 111022;
    private static int GRAPH = 1;
    public int sheetWidth, sheetHeight;

    // all possible graph options...
    private UndirectedGraph graph;
    private DirectedGraph dGraph;
    private WeightedGraph wGraph;

    // all possible geometry that can be drawn...
    private CircleNode[] nodes;
    private ArrayList<LineEdge> edges;

    public Painter(UndirectedGraph g, int w, int h) {
        this.graph = g;
        nodes = new CircleNode[g.vertices];
        this.sheetHeight = h;
        this.sheetWidth = w;
        this.prepare();
    }

    public Painter(DirectedGraph g, int w, int h) {
        this.dGraph = g;
        GRAPH = DIRECTED;
        nodes = new CircleNode[g.vertices];
        this.sheetHeight = h;
        this.sheetWidth = w;
        this.prepare();
    }

    private void prepare() {
        this.prepareVertices();

        if (GRAPH == UNDIRECTED) {
            this.edges = new ArrayList<>();
            ArrayList<ArrayList<Integer>> list = this.graph.getAdj_list();
            for (int i=1; i<this.graph.vertices; i++) {
                for (int neighbour : list.get(i)) {
                    this.edges.add(new LineEdge(nodes[i],nodes[neighbour]));
                    list.get(neighbour).remove((Object)i);
                }
            }
        } else if (GRAPH == DIRECTED){
            this.prepareDirectedEdges();
        }
    }

    private void prepareVertices() {
        if (GRAPH == UNDIRECTED) {
            this.nodes = new CircleNode[this.graph.vertices];
        } else if (GRAPH == DIRECTED) {
            this.nodes = new CircleNode[this.dGraph.vertices];
        }
        for (int i=1; i<this.nodes.length; i++) {
            this.nodes[i] = new CircleNode((int)(Math.random()*this.sheetWidth), (int)(Math.random()*this.sheetHeight));
            this.nodes[i].setIdentifier(String.valueOf(i));
        }
    }

    private void prepareDirectedEdges() {
        this.edges = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = this.dGraph.getAdj_list();
        for (int i=1; i<this.dGraph.vertices; i++) {
            for (int neighbour : list.get(i)) {
                this.edges.add(new PointerEdge(nodes[i], nodes[neighbour]));
                list.get(neighbour).remove((Object)i);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));
        for (int i=1; i<this.nodes.length; i++) {
            nodes[i].paintNode(g);
        }
        for (LineEdge l : this.edges) {
            l.paintLine(g);
        }
    }

    public void paintGraph() {
        this.prepare();
        this.repaint();
    }
}
