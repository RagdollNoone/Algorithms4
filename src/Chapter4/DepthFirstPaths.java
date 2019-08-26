package Chapter4;

import Utility.In;
import Utility.StdOut;

import java.util.Stack;

public class DepthFirstPaths {
    private Graph G;
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        this.G = G;
        this.s = s;

        edgeTo = new int[G.getVertexs()];
        marked = new boolean[G.getVertexs()];

        Graph.validateVertex(this.G, s);

        dfs(s);
    }

    private void dfs(int v) {
        marked[v] = true;

        for (int w : this.G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(w);
            }
        }
    }

    private boolean hasPathTo(int v) {
        Graph.validateVertex(this.G, v);
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        Graph.validateVertex(this.G, v);

        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(s);
        }
        path.push(s);

        return path;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        for (int v = 0; v < G.getVertexs(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d: ", s, v);
                for (int x : dfs.pathTo(v)) {
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
