package com.nitron.graphs.PopulateNextRightPointerInEachNode;

public class Main {

    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5,6,7};

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        new NextRightPointerPopulator().populateNextRightPointer(root);

    }

}
