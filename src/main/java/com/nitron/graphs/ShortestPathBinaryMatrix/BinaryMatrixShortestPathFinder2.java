package com.nitron.graphs.ShortestPathBinaryMatrix;

import java.util.*;

public class BinaryMatrixShortestPathFinder2 {


    public int findShortestPath(int[][] matrix) {
        int n = matrix.length - 1;

        if (matrix[0][0] != 0 || matrix[n][n] != 0)
            return -1;

        Deque<List<Pair>> queue = new ArrayDeque<>();
        List<Pair> startList = new ArrayList<>();
        startList.add(new Pair(0, 0));
        queue.push(startList);

        int ans = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            List<Pair> path = queue.removeFirst();
            int i = path.get(path.size() - 1).i;
            int j = path.get(path.size() - 1).j;
            if (i == n && j == n) {
               ans = Math.min(ans, path.size());
                path.clear();
            }
            else {

                if (i < n && j < n  && matrix[i + 1][j + 1] == 0) {

                    Pair pair = new Pair(i + 1, j + 1);
                    if (!path.contains(pair)) {
                        List<Pair> tempPath = new ArrayList<>(path);
                        tempPath.add(pair);
                        queue.addFirst(tempPath);
                    }
                }
                if (j < n  && matrix[i][j + 1] == 0) {
                    Pair pair = new Pair(i, j + 1);
                    if (!path.contains(pair)) {
                        List<Pair> tempPath = new ArrayList<>(path);
                        tempPath.add(pair);
                        queue.addFirst(tempPath);
                    }
                }
                if (i < n  && matrix[i + 1][j] == 0) {
                    Pair pair = new Pair(i + 1, j);
                    if (!path.contains(pair)) {
                        List<Pair> tempPath = new ArrayList<>(path);
                        tempPath.add(pair);
                        queue.addFirst(tempPath);
                    }
                }
                if (i < n && j > 0  && matrix[i + 1][j - 1] == 0) {
                    Pair pair = new Pair(i + 1, j - 1);
                    if (!path.contains(pair)) {
                        List<Pair> tempPath = new ArrayList<>(path);
                        tempPath.add(pair);
                        queue.addFirst(tempPath);
                    }
                }
                if (i > 0 && j < n  && matrix[i - 1][j + 1] == 0) {

                    Pair pair = new Pair(i - 1, j + 1);
                    if (!path.contains(pair)) {
                        List<Pair> tempPath = new ArrayList<>(path);
                        tempPath.add(pair);
                        queue.addFirst(tempPath);
                    }
                }
                if (j > 0  && matrix[i][j - 1] == 0) {
                    Pair pair = new Pair(i, j - 1);
                    if (!path.contains(pair)) {
                        List<Pair> tempPath = new ArrayList<>(path);
                        tempPath.add(pair);
                        queue.addFirst(tempPath);
                    }
                }
                if (i > 0  && matrix[i - 1][j] == 0) {
                    Pair pair = new Pair(i - 1, j);
                    if (!path.contains(pair)) {
                        List<Pair> tempPath = new ArrayList<>(path);
                        tempPath.add(pair);
                        queue.addFirst(tempPath);
                    }
                }
                if (i > 0 && j > 0  && matrix[i - 1][j - 1] == 0) {

                    Pair pair = new Pair(i - 1, j - 1);
                    if (!path.contains(pair)) {
                        List<Pair> tempPath = new ArrayList<>(path);
                        tempPath.add(pair);
                        queue.addFirst(tempPath);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}
