package com.nitron.graphs.CountConnectedComponetsinGraph;

public class Main {

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};

        System.out.println(new TreeConnectedComponentsCounter().countConnectedCompoents(n, edges));

    }

}
