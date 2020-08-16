package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

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

    void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertexCount];
        queue.add(vertex);
        visited[vertex] = true;

        while(! queue.isEmpty()) {
            final Integer poll = queue.poll();
            System.out.print(poll+" ");
            final ListIterator<Integer> iterator = adj[poll].listIterator();

            while (iterator.hasNext()) {
                final Integer next = iterator.next();
                if( !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
            "(starting from vertex 2)");

        g.bfs(2);
    }
}