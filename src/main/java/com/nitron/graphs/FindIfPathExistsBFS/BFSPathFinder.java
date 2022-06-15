package com.nitron.graphs.FindIfPathExistsBFS;

import java.util.*;

public class BFSPathFinder {

    public boolean doesValidPathExist(int n, int[][] edges, int source, int dest) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        queue.addFirst(source);
        boolean[] visited =new boolean[n];

        Arrays.fill(visited, false);
        while (!queue.isEmpty()) {
            int vertex  = queue.removeFirst();

            if (vertex == dest) {
                return true;

            } else {
                if (!visited[vertex])
                {
                    adjacencyList.get(vertex).forEach(queue::addFirst);

                    visited[vertex] = true;
                }

            }
        }
        return false;
    }
}
