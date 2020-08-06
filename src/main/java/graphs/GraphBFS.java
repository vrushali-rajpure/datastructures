package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    final int maxVertex = 20;
    Vertex[] vertexList;
    int[][] adjMatrix;
    int vertexCount;
    private Queue<Integer> queue;

    public GraphBFS() {
        vertexCount = 0;
        vertexList = new Vertex[maxVertex];
        adjMatrix = new int[maxVertex][maxVertex];
        for (int y = 0; y < maxVertex; y++) {
            for (int x = 0; x < maxVertex; x++) {
                adjMatrix[x][y] = 0;
            }
        }
        queue = new LinkedList<>();
    }

    void addVertex(char lab) {
        vertexList[vertexCount++] = new Vertex(lab);
    }

    void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    void bfs() {
        vertexList[0].visited = true;
        displayVertex(0);
        queue.offer(0);

        int v2;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            while ((v2 = getAdjUnvisited(v)) != -1){
                vertexList[v2].visited  = true;
                displayVertex(v2);
                queue.offer(v2);
            }
        }
    }

    private int getAdjUnvisited(Integer v) {
        for (int j = 0; j < vertexCount; j++) {
            if (adjMatrix[v][j] == 1 && !vertexList[j].visited) {
                return j;
            }
        }
        return -1;
    }
}
