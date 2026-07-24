
import java.util.Arrays;

public class PathExistenceQueries {

    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] component = new int[n];

        int id = 0;
        component[0] = id;

        for (int i = 1; i < n; i++) {

            if (nums[i] - nums[i - 1] > maxDiff) {
                id++;
            }

            component[i] = id;
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            ans[i] = component[u] == component[v];
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 4;
        int[] nums = {2, 5, 6, 8};
        int maxDiff = 2;

        int[][] queries = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3}
        };

        System.out.println(Arrays.toString(pathExistenceQueries(n, nums, maxDiff, queries)));
    }
}