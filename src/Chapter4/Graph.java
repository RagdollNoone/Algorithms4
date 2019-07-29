package Chapter4;

import Utility.In;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Graph {
    private final int vertexs;
    private int edges;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("number of vertices in a Graph must be non-negative");
        }

        this.vertexs = V;
        adj = new Bag[vertexs];
        for (int v = 0; v < this.vertexs; v++) {
            adj[v] = new Bag();
        }
    }

    public Graph(In in) {
        try {
            this.vertexs = in.readInt();
            if (this.vertexs < 0) {
                throw new IllegalArgumentException("number of vertices in a Graph must be non-negative");
            }

            adj = new Bag[vertexs];
            for (int v = 0; v < this.vertexs; v++) {
                adj[v] = new Bag();
            }

            this.edges = in.readInt();
            if (this.edges < 0) {
                throw new IllegalArgumentException("number of edges in a Graph must be non-negative");
            }

            adj = new Bag[this.vertexs];
            for (int i = 0; i < this.edges; i++) {
                int v = in.readInt();
                int w = in.readInt();

                validateVertex(v);
                validateVertex(w);

                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    public Graph(Graph G) {
        this.vertexs = G.getVertexs();
        this.edges = G.getEdges();

        for (int v = 0; v < G.getVertexs(); v++) {
            Stack<Integer> reverse = new Stack<>();

            for (Integer w : G.adj(v)) {
                reverse.push(w);
            }

            for (Integer w : reverse) {
                addEdge(v, w);
            }
        }
    }

    public int getVertexs() {
        return this.vertexs;
    }

    public int getEdges() {
        return this.edges;
    }

    private void validateVertex(int v) {
        if (v < 0 || v > vertexs - 1) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (v - 1));
        }
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);

        this.edges++;

        this.adj[v].add(w);
        this.adj[w].add(v);
    }

    public Iterable<Integer> adj(int v)  {
        return adj[v];
    }

    public static int getDegree(Graph G, int v) {
        int degree = 0;

        for (int w : G.adj(v)) {
            degree++;
        }

        return degree;
    }

    public static int getMaxDegree(Graph G) {
        int max = 0;

        for (int v = 0; v < G.getVertexs(); v++) {
            max = Math.max(getDegree(G, v), max);
        }

        return max;
    }

    public static int getAvgDegree(Graph G) {
        return 2 * G.getEdges() / G.getVertexs();
    }

    public static int getSelfCircleNumber(Graph G) {
        int count = 0;

        for (int v = 0; v < G.getVertexs(); v++) {
            for (int w : G.adj(v)) {
                if (w == v) {
                    count++;
                }
            }
        }

        return count / 2;
    }

    public String toString() {
        return "";
    }
}
