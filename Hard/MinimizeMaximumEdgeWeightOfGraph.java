
import java.util.*;

public class MinimizeMaximumEdgeWeightOfGraph {

    public static int minMaxWeight(int n, int[][] edges, int threshold) {

        int maxWeight = 0;

        for (int[] edge : edges) {
            maxWeight = Math.max(maxWeight, edge[2]);
        }

        int left = 1;
        int right = maxWeight;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canReach(n, edges, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private static boolean canReach(int n, int[][] edges, int limit) {

        List<List<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            if (edge[2] <= limit) {
                reverseGraph.get(edge[1]).add(edge[0]);
            }
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbor : reverseGraph.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        for (boolean v : visited) {
            if (!v)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
                {1, 0, 1},
                {2, 0, 2},
                {3, 0, 1},
                {4, 3, 1},
                {2, 1, 1}
        };

        int threshold = 2;

        System.out.println("Minimum Maximum Edge Weight = "
                + minMaxWeight(n, edges, threshold));
    }
}