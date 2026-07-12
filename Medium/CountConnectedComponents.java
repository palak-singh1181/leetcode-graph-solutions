/*
Graph Problem
Count Connected Components

Time Complexity: O(n² × m)

Space Complexity: O(n²)
*/

import java.util.*;

public class CountConnectedComponents {

    public int countComponents(int[][] properties, int k) {

        int n = properties.length;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            Set<Integer> set = new HashSet<>();

            for (int x : properties[i]) {
                set.add(x);
            }

            for (int j = i + 1; j < n; j++) {

                Set<Integer> common = new HashSet<>();

                for (int x : properties[j]) {

                    if (set.contains(x)) {
                        common.add(x);
                    }
                }

                if (common.size() >= k) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }

        return components;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {

        visited[node] = true;

        for (int next : graph.get(node)) {

            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }

    public static void main(String[] args) {

        CountConnectedComponents obj = new CountConnectedComponents();

        int[][] properties = {
                {1,2},
                {1,1},
                {3,4},
                {4,5},
                {5,6},
                {7,7}
        };

        System.out.println(obj.countComponents(properties,1));
    }
}