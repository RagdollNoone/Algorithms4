package Chapter4.dfs;

import Chapter4.basic.Graph;
import Utility.In;
import Utility.StdOut;

import java.util.Stack;

public class DepthFirstPaths {
    private Graph G;
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        Graph.printGraph(G);

        this.G = G;
        this.s = s;

        edgeTo = new int[G.getVertexs()];
        marked = new boolean[G.getVertexs()];

        for (int i = 0; i < G.getVertexs(); i++) {
            edgeTo[i] = -1;
        }

        Graph.validateVertex(this.G, s);

        dfs(s);
    }

    private void dfs(int v) {
        marked[v] = true;

        for (int w : this.G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;

                System.out.println();
                System.out.println("Current visit " + v);
                System.out.println("Next visit " + w);
                printMarked();
                printEdgeTo();

                dfs(w);
            }
        }
    }

    private boolean hasPathTo(int v) {
        Graph.validateVertex(this.G, v);
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        Graph.validateVertex(this.G, v);

        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);

        return path;
    }

    private void printEdgeTo() {
        if (null == edgeTo) return;

        System.out.println("printEdgeTo");

        for (int i = 0; i < edgeTo.length; i++) {
            System.out.print(edgeTo[i] + " ");
        }

        System.out.println();
    }

    private void printMarked() {
        if (null == marked) return;

        System.out.println("printMarked");

        for (int i = 0; i < marked.length; i++) {
            System.out.print(marked[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        for (int v = 0; v < G.getVertexs(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d: ", s, v);

                Stack<Integer> path = dfs.pathTo(v);
                while(path.size() != 0) {
                    int x = path.pop();
                    if (x == s) {
                        StdOut.print(x);
                    } else {
                        StdOut.print("-" + x);
                    }
                }

                StdOut.println();
            } else {
                StdOut.printf("%d to %d: not connected\n", s, v);
            }
        }
    }
}
