package Chapter4;

import Utility.In;

public class Graph {
    public Graph(int v) {

    }

    public Graph(In in) {

    }

    public int getVertexs() {
        return 0;
    }

    public int getEdges() {
        return 0;
    }

    public void addEdge(int v, int w) {

    }

    public Iterable<Integer> adj(int v)  {

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
