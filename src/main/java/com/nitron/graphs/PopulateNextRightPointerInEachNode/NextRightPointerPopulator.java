package com.nitron.graphs.PopulateNextRightPointerInEachNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextRightPointerPopulator {

    public void populateNextRightPointer(Node root) {

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            Node previous = null;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.remove();

                if (previous != null) {
                    previous.next = current;
                }
                previous = current;

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);

            }

        }
    }

}
