package com.nitron.graphs.NaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderTraversal {

    List<List<Integer>> traverse(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;


        Deque<Node> queue = new ArrayDeque<>();

        queue.add(root);


        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            List<Integer> currLevelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.remove();

                currLevelNodes.add(node.val);

                if (node.children!= null && !node.children.isEmpty()) {
                    queue.addAll(node.children);
                }
            }
            result.add(currLevelNodes);
        }
        return result;
    }
}

