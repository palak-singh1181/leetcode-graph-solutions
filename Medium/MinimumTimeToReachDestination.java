
import java.util.*;

public class MinimumTimeToReachDestination {

    static class Edge {
        int to;
        int start;
        int end;

        Edge(int to, int start, int end) {
            this.to = to;
            this.start = start;
            this.end = end;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        long time;

        Node(int vertex, long time) {
            this.vertex = vertex;
            this.time = time;
        }

        public int compareTo(Node other) {
            return Long.compare(this.time, other.time);
        }
    }

    public static int minTime(int n, int[][] edges) {

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges)
            graph.get(e[0]).add(new Edge(e[1], e[2], e[3]));

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[0] = 0;
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            if (cur.time != dist[cur.vertex])
                continue;

            if (cur.vertex == n - 1)
                return (int) cur.time;

            for (Edge edge : graph.get(cur.vertex)) {

                if (cur.time > edge.end)
                    continue;

                long depart = Math.max(cur.time, edge.start);

                if (depart > edge.end)
                    continue;

                long arrive = depart + 1;

                if (arrive < dist[edge.to]) {
                    dist[edge.to] = arrive;
                    pq.offer(new Node(edge.to, arrive));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] edges = {
                {0, 1, 0, 3},
                {1, 3, 7, 8},
                {0, 2, 1, 5},
                {2, 3, 4, 7}
        };

        System.out.println("Minimum Time = " + minTime(n, edges));
    }
}