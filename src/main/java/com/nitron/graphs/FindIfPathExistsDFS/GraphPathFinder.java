package com.nitron.graphs.FindIfPathExistsDFS;

import java.util.*;

public class GraphPathFinder {
    public boolean findIfPathExists(int[][] edges, int source, int dest, int n) {

        List<List<Integer>> adjacencyList = new ArrayList<>();


        for(int i=0;i<n;i++)
        {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();

        boolean[] seen = new boolean[n];

        Arrays.fill(seen, false);
        stack.push(source);
        while(!stack.isEmpty())
        {
           int vertex = stack.pop();

           if(vertex==dest)
               return true;

           if(!seen[vertex]) {
               seen[vertex] = true;
               adjacencyList.get(vertex).forEach(stack::push);
           }

        }
        return false;
    }
}
