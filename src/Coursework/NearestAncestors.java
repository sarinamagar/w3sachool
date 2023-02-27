package Coursework;

import java.util.Arrays;

public class NearestAncestors {

    // Method to find greatest common divisor (GCD) of two numbers using Euclid's algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // Method to check if two numbers are relatively prime
    // Returns true if two integers are relatively prime, i.e., if their GCD is 1.
    public static boolean isRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Method to perform DFS and find the nearest ancestor with relatively prime value
    // Finds the closest ancestor with a value that is relatively prime to the GCD of the values of the parent nodes visited thus far
    private static void dfs(int node, int[][] adjList, int[] values, boolean[] visited, int prevGcd, int[] result) {
        visited[node] = true;

        // Traverse the adjacency list of the current node
        for (int i = 0; i < adjList[node].length; i++) {
            int child = adjList[node][i];
            if (!visited[child]) {
                // Calculate the GCD value for the child
                int gcdValue = gcd(values[node], prevGcd);
                if (isRelativelyPrime(values[child], gcdValue)) {
                    // If the child value is relatively prime to the GCD value, update the result array and continue DFS
                    result[child] = node;
                    dfs(child, adjList, values, visited, values[node], result);
                } else {
                    // If not, continue DFS with the GCD value
                    dfs(child, adjList, values, visited, gcdValue, result);
                }
            }
        }
    }

    // Main method to find nearest ancestors for all nodes
    // Finds the nearest ancestor for each node with a value that is relatively prime to the GCD of the values of the parent nodes
    public static int[] nearestAncestors(int[] values, int[][] edges) {
        int n = values.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Build the adjacency list
        int[][] adjList = new int[n][];
        for (int i = 0; i < n; i++) {
            adjList[i] = new int[0];
        }
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            adjList[parent] = Arrays.copyOf(adjList[parent], adjList[parent].length + 1);
            adjList[parent][adjList[parent].length - 1] = child;
        }

        // Perform DFS on each node
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, adjList, values, visited, 0, result);
        }

        return result;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] values = {3, 2, 6, 6, 4, 7, 12};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] result = nearestAncestors(values, edges);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
