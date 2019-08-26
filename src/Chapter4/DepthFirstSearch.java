package Chapter4;

import Utility.In;
import Utility.StdOut;

public class DepthFirstSearch extends Search {
    private boolean[] marked;
    private int count;
    private Graph G;

    public DepthFirstSearch(Graph G, int s) {
        this.G = G;
        marked = new boolean[G.getVertexs()];
        Graph.validateVertex(this.G, s);
        dfs(s);
    }

    private void dfs(int v) {
        count++;
        marked[v] = true;
        for (int w : this.G.adj(v)) {
            if (!marked[w]) {
                dfs(w);
            }
        }
    }

    @Override
    boolean marked(int v) {
        Graph.validateVertex(this.G, v);
        return marked[v];
    }

    @Override
    int count() {
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);


        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.getVertexs(); v++) {
            if (search.marked(v)) {
                StdOut.print(v + " ");
            }
        }

        StdOut.println();
        if (search.count() != G.getVertexs()) {
            StdOut.println("Not Connected");
        } else {
            StdOut.println("Connected");
        }

    }
}
