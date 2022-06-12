package com.nitron.graphs.FindIfPathExistsDFS;

public class Main {

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0}};
        int[][] edges2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int n = 3;
        int source = 0;
        int dest = 2;

        System.out.println(new GraphPathFinder().findIfPathExists(edges, source, dest, n));

    }

}
