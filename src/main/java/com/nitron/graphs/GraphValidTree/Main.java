package com.nitron.graphs.GraphValidTree;

public class Main {

    public static void main(String[] args) {
      int  n = 5;
      int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};

        System.out.println(new ValidTreeChecker().isValidTree(edges, n));

    }



}
