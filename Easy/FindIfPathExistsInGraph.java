
import java.util.*;

public class FindIfPathExistsInGraph {

    static boolean dfs(int node, int destination,
                       List<List<Integer>> graph,
                       boolean[] visited) {

        if (node == destination)
            return true;

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, destination, graph, visited))
                    return true;
            }
        }

        return false;
    }

    public static boolean validPath(int n, int[][] edges,
                                    int source, int destination) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        return dfs(source, destination, graph, visited);
    }

    public static void main(String[] args) {

        int n = 6;

        int[][] edges = {
                {0,1},
                {0,2},
                {3,5},
                {5,4},
                {4,3}
        };

        int source = 0;
        int destination = 5;

        System.out.println("Path Exists: "
                + validPath(n, edges, source, destination));
    }
}