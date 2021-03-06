package graphs;
import graphs.GraphDFS;
import org.junit.Test;

public class GraphDFSTest {

    @Test
    public void dfs() {
        final GraphDFS graph = new GraphDFS();
        graph.addVertex('A'); // 0
        graph.addVertex('B');// 1
        graph.addVertex('C');// 2
        graph.addVertex('D');// 3
        graph.addVertex('E');// 4
        graph.addVertex('F');// 5
        graph.addVertex('G');// 6
        graph.addVertex('H');// 7

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 7);
        graph.addEdge(4, 6);

        graph.dfs();
    }
}