package com.nitron.graphs.NaryTreeLevelOrderTraversal;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5,6,7};

        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(1).children = new ArrayList<>();
        root.children.get(1).children.add(new Node(6));
        root.children.get(1).children.add(new Node(7));

        System.out.println(new LevelOrderTraversal().traverse(root));

    }

}
