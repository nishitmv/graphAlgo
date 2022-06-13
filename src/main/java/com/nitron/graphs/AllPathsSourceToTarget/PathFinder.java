package com.nitron.graphs.AllPathsSourceToTarget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathFinder {
    public List<List<Integer>> findPaths(int[][] graph) {

        List<List<Integer>> paths = new ArrayList<>();
        Deque<List<Integer>> stack = new ArrayDeque<>();
        int dest = graph.length-1;

        List<Integer> start = new ArrayList<>();
        start.add(0);
        stack.push(start);
        int source =0;
        while (!stack.isEmpty())
        {
            System.out.println(stack);
           List<Integer> path = stack.pop();

           if(path.contains(source) && path.contains(dest))
           {
               paths.add(new ArrayList<>(path));
               path.clear();
           }
           else    {
               for( int v: graph[path.get(path.size()-1)]) {
                   List<Integer> tempPath = new ArrayList<>(path);
                   tempPath.add(v);
                   stack.push(tempPath);
               }
           }

        }
    return paths;
    }
}
