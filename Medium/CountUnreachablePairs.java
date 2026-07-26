import java.util.*;

public class CountUnreachablePairs {

    public static long countPairs(int n, int[][] edges) {

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }


        boolean[] visited = new boolean[n];

        long ans = 0;
        long previousNodes = 0;


        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                long size = dfs(i, graph, visited);

                ans += size * previousNodes;

                previousNodes += size;
            }
        }


        return ans;
    }



    private static long dfs(int node, ArrayList<Integer>[] graph, boolean[] visited) {

        visited[node] = true;

        long count = 1;


        for (int neighbour : graph[node]) {

            if (!visited[neighbour]) {

                count += dfs(neighbour, graph, visited);
            }
        }


        return count;
    }



    public static void main(String[] args) {


        int n = 7;

        int[][] edges = {
            {0,2},
            {0,5},
            {2,4},
            {1,6},
            {5,4}
        };


        System.out.println(countPairs(n, edges));
    }
}