
import java.util.*;

public class MaximumStarSumOfGraph {

    public static int maxStarSum(int[] vals, int[][] edges, int k) {

        int n = vals.length;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(vals[v]);
            graph.get(v).add(vals[u]);
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            List<Integer> neighbors = graph.get(i);

            neighbors.sort(Collections.reverseOrder());

            int sum = vals[i];

            for (int j = 0; j < Math.min(k, neighbors.size()); j++) {

                if (neighbors.get(j) <= 0)
                    break;

                sum += neighbors.get(j);
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] vals = {1,2,3,4,10,-10,-20};

        int[][] edges = {
                {0,1},
                {1,2},
                {1,3},
                {3,4},
                {3,5},
                {3,6}
        };

        int k = 2;

        System.out.println("Maximum Star Sum = " +
                maxStarSum(vals, edges, k));
    }
}