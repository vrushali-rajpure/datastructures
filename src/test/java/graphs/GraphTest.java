package graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void dfs() {
        final Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.dfs(2);
    }
}