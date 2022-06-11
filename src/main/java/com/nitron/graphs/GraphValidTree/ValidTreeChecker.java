package com.nitron.graphs.GraphValidTree;

public class ValidTreeChecker {

    int[] roots;
    int[] heights;
    boolean isValid = true;
    int count;

    public boolean isValidTree(int[][] edges, int n) {

        roots = new int[n];
        heights = new int[n];
        count = n;

        for(int i=0;i<n;i++)
        {
            roots[i] =i;
            heights[i] =1;
        }

        for(int i=0;i<edges.length;i++)
        {
            if(isValid)
                 union(edges[i][0], edges[i][1]);
            else
                break;
        }

        return count==1 && isValid;
    }

    private int find(int val) {
        if(roots[val] == val)
            return val;
        else{
            roots[val] = find(roots[val]);
            return roots[val];
        }
    }

    private void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if(rootX ==rootY)
        {
            isValid = false;
        }

       else  {
            count--;
            if (heights[rootX] > heights[rootY]) {
                roots[rootY] = rootX;
            } else if (heights[rootY] > heights[rootX]) {
                roots[rootX] = rootY;
            } else {
                roots[rootY] = rootX;
                heights[rootX]++;
            }
        }
    }




}
