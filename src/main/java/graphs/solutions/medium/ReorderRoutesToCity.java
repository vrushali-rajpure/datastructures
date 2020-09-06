package graphs.solutions.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 *
 */
public class ReorderRoutesToCity {

    static int change = 0;

    public static int minReorder(int n, int[][] connections) {

        Set<String> pathsOrder = new HashSet<>();
        for (int[] p : connections) {
            int a = p[0];
            int b = p[1];
            pathsOrder.add(a + "#" + b);
        }

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        buildGraph(graph, connections);
        boolean[] visited = new boolean[n];

        dfs(graph, visited, pathsOrder);
        return connections.length - change;
    }

    private static void dfs(List<Integer>[] graph, boolean[] visited,Set<String> paths) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int v=queue.poll();
            if(!visited[v]){
                List<Integer> childs=graph[v];
                for(int child:childs){
                    if(!visited[child]){
                        String str= v +"#"+ child;
                        if(!paths.contains(str))
                            change++;
                        queue.add(child);
                    }

                }
                visited[v]=true;
            }
        }

    }

    private static void buildGraph(List<Integer>[] graph, int[][] connections) {
        for (int[] v : connections) {
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }
    }
}
