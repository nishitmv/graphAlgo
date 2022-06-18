package com.nitron.graphs.ShortestPathBinaryMatrix;

import java.util.*;

public class BinaryMatrixShortestPathFinder {


    public int findShortestPath(int[][] matrix)
    {

        int n = matrix.length-1;

        Pair start ;

        if(matrix[0][0] ==0)
            start = new Pair(0,0);
        else
            return -1;
        Deque<Pair> queue = new ArrayDeque<>();
        queue.push(start);
        List<Pair> path = new ArrayList<>();
        boolean[][] visited = new boolean[n+1][n+1];

        for(boolean[] v : visited)
            Arrays.fill(v, false);
        int ans =Integer.MAX_VALUE;
        while(!queue.isEmpty())
        {
            Pair vertex = queue.removeFirst();
            path.add(vertex);
            if(vertex.i==n && vertex.j ==n) {
               ans = Math.min(ans, path.size());
                path.clear();
            }

            if(vertex.i<n && vertex.j<n && !visited[vertex.i+1][vertex.j+1]&& matrix[vertex.i+1][vertex.j+1]==0) {
                queue.addFirst(new Pair(vertex.i + 1, vertex.j + 1));
                visited[vertex.i+1][vertex.j+1] = true;
            }
             if(vertex.j<n && !visited[vertex.i][vertex.j+1] && matrix[vertex.i][vertex.j+1]==0) {
                queue.addFirst(new Pair(vertex.i, vertex.j + 1));
                visited[vertex.i][vertex.j+1] = true;
            }
             if(vertex.i<n && !visited[vertex.i+1][vertex.j] && matrix[vertex.i+1][vertex.j]==0) {
                queue.addFirst(new Pair(vertex.i + 1, vertex.j));
                visited[vertex.i+1][vertex.j] = true;
            }
             if(vertex.i<n && vertex.j>0&& !visited[vertex.i+1][vertex.j-1] && matrix[vertex.i+1][vertex.j-1]==0) {
                queue.addFirst(new Pair(vertex.i + 1, vertex.j-1));
                visited[vertex.i+1][vertex.j-1] = true;
            }
             if(vertex.i>0 && vertex.j<n && !visited[vertex.i-1][vertex.j+1] && matrix[vertex.i-1][vertex.j+1]==0) {
                queue.addFirst(new Pair(vertex.i - 1, vertex.j+1));
                visited[vertex.i-1][vertex.j+1] = true;
            }
              if(vertex.i>0 && vertex.j>0 && !visited[vertex.i-1][vertex.j-1]&& matrix[vertex.i-1][vertex.j-1]==0) {
                queue.addFirst(new Pair(vertex.i - 1, vertex.j - 1));
                visited[vertex.i-1][vertex.j-1] = true;
            }
             if(vertex.j>0 && !visited[vertex.i][vertex.j-1] && matrix[vertex.i][vertex.j-1]==0) {
                queue.addFirst(new Pair(vertex.i, vertex.j - 1));
                visited[vertex.i][vertex.j-1] = true;
            }
             if(vertex.i>0 && !visited[vertex.i-1][vertex.j] && matrix[vertex.i-1][vertex.j]==0) {
                queue.addFirst(new Pair(vertex.i-1, vertex.j));
                visited[vertex.i-1][vertex.j] = true;
            }
        }


        return ans == Integer.MAX_VALUE ? -1 : ans;


    }


}
