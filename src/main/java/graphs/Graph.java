package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
 * Space Complexity: O(V).
 * Since, an extra visited array is needed of size V.
 *
 *  This will happen by handling a corner case.
 * The above code traverses only the vertices reachable from a given source vertex.
 */
class Graph {
    int vertexCount;
    List<Integer> adj[];

    public Graph(int vertexCount) {

        this.vertexCount = vertexCount;
        adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        adj[source].add(destination);
    }

    void dfs(int vertex) {
        boolean[] visited = new boolean[vertexCount];

        dfsUtil(vertex, visited);

    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;

        System.out.print(vertex + " ");
        final ListIterator<Integer> iterator = adj[vertex].listIterator();
        while (iterator.hasNext()) {
            final Integer next = iterator.next();
            if (!visited[next]) {
                dfsUtil(next, visited);
            }
        }
    }
}