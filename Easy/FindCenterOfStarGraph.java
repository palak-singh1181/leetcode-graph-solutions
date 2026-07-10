
/*
LeetCode 1791
Find Center of Star Graph

Time Complexity: O(1)
Space Complexity: O(1)
*/

public class FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {

        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }

        return edges[0][1];
    }

    public static void main(String[] args) {

        FindCenterOfStarGraph obj = new FindCenterOfStarGraph();

        int[][] edges1 = {
                {1, 2},
                {2, 3},
                {4, 2}
        };

        System.out.println(obj.findCenter(edges1));

        int[][] edges2 = {
                {1, 2},
                {5, 1},
                {1, 3},
                {1, 4}
        };

        System.out.println(obj.findCenter(edges2));
    }
}