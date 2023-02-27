package Coursework;

import java.util.*;
    public class ISPNetwork {
        public static List<Integer> findImpactedDevices(int targetDevice, int[][] edges) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                graph.putIfAbsent(from, new ArrayList<>());
                graph.putIfAbsent(to, new ArrayList<>());
                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            Set<Integer> visited = new HashSet<>();
            visited.add(targetDevice);
            List<Integer> impactedDevices = new ArrayList<>();

            for (int neighbor : graph.get(targetDevice)) {
                Set<Integer> neighborVisited = new HashSet<>();
                dfs(graph, neighbor, targetDevice, visited, neighborVisited);
                if (!neighborVisited.contains(0)) {
                    impactedDevices.add(neighbor);
                }
            }

            return impactedDevices;
        }

        private static void dfs(Map<Integer, List<Integer>> graph, int current, int targetDevice,
                                Set<Integer> visited, Set<Integer> neighborVisited) {
            visited.add(current);
            neighborVisited.add(current);

            for (int neighbor : graph.get(current)) {
                if (visited.contains(neighbor)) {
                    continue;
                }

                if (current == targetDevice && !graph.get(neighbor).contains(0)) { // Impacted devices found
                    neighborVisited.add(neighbor);
                    continue;
                }

                dfs(graph, neighbor, targetDevice, visited, neighborVisited);
            }
        }

    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {0, 2}, {1, 3}, {1, 6}, {2, 4}, {4, 6}, {4, 5}, {5, 7}};
        int n = 4;
        List<Integer> impactedDevices = findImpactedDevices(n, connections);
        System.out.println("Impacted devices: " + impactedDevices);
    }
}

