package com.nitron.graphs.CountConnectedComponetsinGraph;

import java.util.HashSet;
import java.util.Set;

public class TreeConnectedComponentsCounter {

    int[] roots;
    int[] heights;

  Set<Integer> rootSet = new HashSet<>();

    public int countConnectedCompoents(int n, int[][] edges) {

        roots = new int[n];
        heights = new int[n];

        for(int i=0;i<n;i++)
        {
            roots[i] =i;
            heights[i] = 1;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        for(int i=0;i<n;i++)
        {
            rootSet.add(find(i));
        }
        return rootSet.size();
    }

    private int find(int val)
    {
        if(val == roots[val])
            return val;
        else {
            roots[val] = find(roots[val]);
            return roots[val];
        }
    }

    private void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY)
        {
            if(heights[rootX]> heights[rootY])
            {
                roots[rootY] = rootX;
            }
            else if( heights[rootY]> heights[rootX])
            {
                roots[rootX] = rootY;
            }
            else{

                roots[rootY] = rootX;
                heights[rootX]++;
            }
        }
    }

    private boolean isConnected(int x, int y)
    {
        return find(x) == find(y);
    }

}
