package com.nitron.graphs.FindAllPathsBFS;

import java.util.*;

public class BFSPathFinder2 {
    public List<List<Integer>> findAllPaths(int[][] graph) {


        List<List<Integer>> paths = new ArrayList<>();

        int n = graph.length;
        int dest = graph.length-1;
        Deque<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> sourceList = new ArrayList<>();
        sourceList.add(0);
        queue.addFirst(sourceList);

        while (!queue.isEmpty()) {
            List<Integer> path = queue.removeFirst();

            if (path.contains(dest)) {
                paths.add(new ArrayList<>(path));
            } else {

                int currDest = path.get(path.size() - 1);

                    for (int vertex : graph[currDest]) {
                        List<Integer> temp = new ArrayList<>(path);
                        temp.add(vertex);
                        queue.addFirst(temp);
                    }
            }
        }
        return paths;

    }
}
