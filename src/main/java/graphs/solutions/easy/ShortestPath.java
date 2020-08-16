package graphs.solutions.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class ShortestPath {
    public static void main(String[] args) {
        ShortestPath path = new ShortestPath();
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(Arrays.deepToString(path.createMatrix(graph)));

        System.out.println(Arrays.toString(path.createAdj(graph)));
    }

    public int shortestPathLength(int[][] graph) {
        final List<Integer>[] adj = createAdj(graph);
        Queue<Integer> queue = new LinkedList<>();
        final int start = 0;
        queue.add(start);

//        int[] distance = new int[graph.length];
//        int[] path
//        for (int i = 0; i < graph.length; i++) {
//            distance[i] = -1;
//        }

        distance[start] = 0;
        while (!queue.isEmpty()) {
            final Integer vertex = queue.poll();
            final ListIterator<Integer> adjVertex = adj[vertex].listIterator();
            while ( adjVertex.hasNext()) {
                final Integer next = adjVertex.next();
                if( distance[next] == -1){
                    distance[next] = distance[vertex] + 1;
                }
            }
        }

        return 0;

    }

    private int[][] createMatrix(int[][] graph) {
        final int length = graph.length;
        int[][] matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            final int[] row = graph[i];
            for (int vertex : row) {
                matrix[i][vertex] = 1;
            }
        }
        return matrix;
    }

    private List<Integer>[] createAdj(int[][] graph) {
        final int length = graph.length;
        List<Integer> adj[] = new LinkedList[length];
        for (int i = 0; i < length; i++) {
            adj[i] = new LinkedList<>();
            final int[] cols = graph[i];
            for (int col : cols) {
                adj[i].add(col);
            }
        }
        return adj;
    }
}
