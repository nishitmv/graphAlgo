package com.nitron.graphs.CheckAllPathsLeadToDest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathFinder {

    public boolean findPaths(int[][] edges, int n, int source, int dest) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            if(edge[0]>=source) {
                if (edge[0] == edge[1])
                    return false;
                adjacencyList.get(edge[0]).add(edge[1]);

                if (adjacencyList.get(edge[0]).contains(edge[1]) && adjacencyList.get(edge[1]).contains(edge[0]))
                    return false;
            }
        }

        List<List<Integer>> paths = new ArrayList<>();
        Deque<List<Integer>> stack = new ArrayDeque<>();
        List<Integer> sourceList = new ArrayList<>();
        sourceList.add(source);
        stack.push(sourceList);

        while (!stack.isEmpty() ) {
            System.out.println(stack);
            List<Integer> path = stack.pop();

            int currDest = path.get(path.size() - 1);
            if (!adjacencyList.get(currDest).isEmpty()) {
                adjacencyList.get(currDest).forEach(vertex -> {
                    List<Integer> tempPath = new ArrayList<>(path);
                    tempPath.add(vertex);
                    stack.push(tempPath);
                });

            } else {
                paths.add(new ArrayList<>(path));
                path.clear();
            }
        }
        boolean result = true;
        for (List<Integer> path : paths) {
            System.out.println(path);
            if (!(path.contains(source) && path.get(path.size()-1)==dest)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
