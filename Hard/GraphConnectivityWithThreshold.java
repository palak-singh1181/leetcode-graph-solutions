import java.util.*;

public class GraphConnectivityWithThreshold {

    static class DSU {

        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa != pb) {
                parent[pa] = pb;
            }
        }
    }

    public static List<Boolean> areConnected(int n, int threshold, int[][] queries) {

        DSU dsu = new DSU(n);

        // Connect all multiples of divisors greater than threshold
        for (int d = threshold + 1; d <= n; d++) {

            for (int multiple = 2 * d; multiple <= n; multiple += d) {
                dsu.union(d, multiple);
            }
        }

        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {

            if (dsu.find(query[0]) == dsu.find(query[1])) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 6;
        int threshold = 2;

        int[][] queries = {
                {1, 4},
                {2, 5},
                {3, 6}
        };

        List<Boolean> ans = areConnected(n, threshold, queries);

        System.out.println(ans);
    }
}