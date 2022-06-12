package com.nitron.graphs.AllPathsSourceToTarget;

public class Main {


    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};

        System.out.println(new PathFinder().findPaths(graph));
    }

}
