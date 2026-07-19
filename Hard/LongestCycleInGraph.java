import java.util.Arrays;

public class LongestCycleInGraph {

    public static int longestCycle(int[] edges) {

        int n = edges.length;

        boolean[] visited = new boolean[n];

        int answer = -1;

        for (int i = 0; i < n; i++) {

            if (visited[i])
                continue;

            int current = i;
            int step = 0;

            int[] distance = new int[n];
            Arrays.fill(distance, -1);

            while (current != -1 && !visited[current]) {

                visited[current] = true;
                distance[current] = step++;

                current = edges[current];
            }

            if (current != -1 && distance[current] != -1) {
                answer = Math.max(answer, step - distance[current]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] edges1 = {3, 3, 4, 2, 3};

        int[] edges2 = {2, -1, 3, 1};

        System.out.println("Longest Cycle = " + longestCycle(edges1));

        System.out.println("Longest Cycle = " + longestCycle(edges2));
    }
}