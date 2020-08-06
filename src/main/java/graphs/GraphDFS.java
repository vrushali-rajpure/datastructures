package graphs;

import java.util.Stack;

class Vertex {
    char label;
    boolean visited;

    public Vertex(char label) {
        this.label = label;
        this.visited = false;
    }
}

public class GraphDFS {
    final int maxVertex = 20;
    Vertex[] vertexList;
    int[][] adjMatrix;
    int vertexCount;
    private Stack<Integer> stack;

    public GraphDFS() {
        vertexCount = 0;
        vertexList = new Vertex[maxVertex];
        adjMatrix = new int[maxVertex][maxVertex];
        for (int y = 0; y < maxVertex; y++) {
            for (int x = 0; x < maxVertex; x++) {
                adjMatrix[x][y] = 0;
            }
        }
        stack = new Stack<>();
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

    void dfs() {
        vertexList[0].visited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisited(stack.peek());
            if( v == -1) {
                stack.pop();
            } else {
                vertexList[v].visited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int j = 0; j < vertexCount; j++) { // reset flags
            vertexList[j].visited = false;
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
