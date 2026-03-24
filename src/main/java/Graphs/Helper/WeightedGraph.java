package Graphs.Helper;

import Graphs.Helper.PairHelper.KruskalPair;
import Graphs.Helper.PairHelper.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class WeightedGraph {

    protected ArrayList<ArrayList<Node>> adj_list;
    public int vertices;
    public int edges;

    public WeightedGraph(int n) {
        this.vertices = n+1;
        this.edges = 0;
        this.adj_list = new ArrayList<>();
        for (int i=0; i<this.vertices; i++) {
            this.adj_list.add(new ArrayList<>());
        }
    }

    private int[] getDistanceArray(int n) {
        int[] request = new int[n];
        Arrays.fill(request, 100000000);
        return request;
    }

    public void addEdge(int a, int b, int w) {
        this.adj_list.get(a).add(new Node(b,w));
        this.adj_list.get(b).add(new Node(a,w));
    }


    public void showGraph() {
        for (int i=0; i<this.vertices; i++) {
            System.out.print(i+" ==> ");
            for (Node neighbour : this.adj_list.get(i)) {
                System.out.print("("+neighbour.vertex+" , "+neighbour.weight+") ");
            }
            System.out.println();
        }
    }

    /**
     * This algorithm is to find, the shortest path in weighted graph from single source to all vertices. In this case we
     * can consider using Dijkstra's Shortest Path Algorithm. That algorithm uses minimum heap and find the shortest path
     * from given single source.
     *
     * @param start the starting vertex from where the travelling will begins...
     *
     * @return int[] the array consisting the shorted path to ith vertex, the starting vertex will have distance = 0
     * */
    public int[] getShortestPathFrom(int start, boolean debug) {
        int[] distanceArray = getDistanceArray(this.vertices);
        distanceArray[start] = 0;

        // pair of source and distance in min. Heap...
        PriorityQueue<Node> minHeap = new PriorityQueue<>(this.vertices, new Node());
        minHeap.add(new Node(start, 0));

        while (minHeap.size() > 0) {
            Node node = minHeap.poll();

            for (Node neighbour : this.adj_list.get(node.vertex)) {
                if (distanceArray[node.vertex]+ neighbour.weight < distanceArray[neighbour.vertex]) {
                    distanceArray[neighbour.vertex] = distanceArray[node.vertex]+ neighbour.weight;
                    minHeap.add(new Node(neighbour.vertex, distanceArray[neighbour.vertex]));
                }
            }

            if (debug) {
                System.out.println("Exploring node : "+node.vertex+" distance to reach this vertex : "+distanceArray[node.vertex]);
                System.out.println(Arrays.toString(distanceArray));
            }
        }

        return distanceArray;
    }

    /**
     *
     * @TimeComplexity O(nLogn)
     * @SpaceComplexity O(n)
     * */
    public void printMinimumSpanningTree() {
        // for storing the distance from the parent to ith vertex...
        int[] Key = new int[this.vertices];
        // for keeping track of parent of ith vertex...
        int[] Parent = new int[this.vertices];
        // to keeping track of minimum spanning tree vertex is visited or not...
        boolean[] MST = new boolean[this.vertices];

        for (int i=0; i<this.vertices; i++) {
            Key[i] = Integer.MAX_VALUE;
            MST[i] = false;
            Parent[i] = -1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(this.vertices-1, new Node());
        Key[1] = 0;
        pq.add(new Node(1, Key[1]));

        for (int i=1; i<this.vertices; i++) {

            int u = pq.poll().vertex;
            MST[u] = true;

            for (Node neighbour : this.adj_list.get(u)) {
                if (!MST[neighbour.vertex] && neighbour.weight < Key[neighbour.vertex]) {
                    Parent[neighbour.vertex] = u;
                    Key[neighbour.vertex] = neighbour.weight;
                    pq.add(new Node(neighbour.vertex, Key[neighbour.vertex]));
                }
            }
        }

        WeightedGraph mst = new WeightedGraph(this.vertices-1);
        for (int u=1; u< Parent.length; u++) {
            if (Parent[u] != -1) {
                mst.addEdge(Parent[u], u, getWeightOf(Parent[u], u));
            }
        }
        mst.showGraph();
    }

    public int[] getShortestPathFrom(int start) {
        return getShortestPathFrom(start, true);
    }

    private int getWeightOf(int i, int j) {
        int w = 0;
        for (Node neighbours : this.adj_list.get(i)) {
            if (neighbours.vertex == j) {
                w = neighbours.weight;
                break;
            }
        }
        return w;
    }

    private ArrayList<KruskalPair> getKruskalPairList(ArrayList<ArrayList<Node>> adj_list) {
        ArrayList<KruskalPair> pairs = new ArrayList<>();
        for (int i=1; i<adj_list.size(); i++) {
            for (Node neighbour : this.adj_list.get(i)) {
                pairs.add(new KruskalPair(i, neighbour.vertex, neighbour.weight));
            }
        }
        return pairs;
    }

    public void printKruskalMST() {
        ArrayList<KruskalPair> adjList = this.getKruskalPairList(this.adj_list);
        Collections.sort(adjList, new KruskalPair());
        int[] Parent = new int[this.vertices];
        int[] Rank = new int[this.vertices];

        for (int i=0; i<Parent.length; i++) {
            Parent[i] = i;
            Rank[i] = 0;
        }

        int costMst = 0;
        ArrayList<KruskalPair> SpanningTree = new ArrayList<>();
        for (KruskalPair node: adjList) {
            if (findParent(node.u, Parent) != findParent(node.v, Parent)) {
                costMst += node.weight;
                SpanningTree.add(node);
                union(node.u,node.v,Parent,Rank);
            }
        }
        System.out.println(costMst);
        for (KruskalPair p : SpanningTree) {
            System.out.println(p.u+" -- "+p.v);
        }
    }

    private void union(int u, int v, int[] parent, int[] rank) {
        u = findParent(u, parent);
        v = findParent(v, parent);
        if(rank[u] < rank[v]) {
            parent[u] = v;
        }
        else if(rank[v] < rank[u]) {
            parent[v] = u;
        }
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    private int findParent(int u, int[] parent) {
        if (u == parent[u]) return u;
        return findParent(parent[u], parent);
    }


}
