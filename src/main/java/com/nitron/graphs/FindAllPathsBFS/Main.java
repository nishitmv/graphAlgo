package com.nitron.graphs.FindAllPathsBFS;

public class Main {

    public static void main(String[] args) {

        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        int n =3;
        int source = 0;
        int dest = 2;
        System.out.println(new BFSPathFinder2().findAllPaths(graph));

    }

}
