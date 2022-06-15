package com.nitron.graphs.FindAllPathsBFS;

import java.util.*;

public class BFSPathFinder {
    public List<List<Integer>> findAllPaths(int[][] edges, int source, int dest, int n) {

        List<List<Integer>> adjacencyList = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Deque<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> sourceList = new ArrayList<>();
        sourceList.add(source);
        queue.addFirst(sourceList);
        boolean[] visited = new boolean[n];

        Arrays.fill(visited, false);

        while (!queue.isEmpty()) {
            List<Integer> path = queue.removeFirst();

            if (path.contains(dest)) {
                paths.add(new ArrayList<>(path));
            } else {

                int currDest = path.get(path.size() - 1);
                if (!visited[currDest])
                    adjacencyList.get(currDest).forEach(vertex -> {
                        List<Integer> tempPath = new ArrayList<>(path);
                        tempPath.add(vertex);
                        queue.addFirst(tempPath);

                    });
                visited[currDest] = true;
            }

        }
        return paths;

    }
}
