package com.nitron.graphs.disjointSets;

public class UnionFindQuickUnionByRank {


    int[] roots;
    int[] height;
    public UnionFindQuickUnionByRank(int n) {
        roots = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++)
        {
            roots[i] = i;
            height[i] =1;
        }
    }

    private int find(int val) {
        while (val != roots[val])
        {
            val = roots[val];
        }
        return val;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if( rootX!=rootY)
        {
            if(height[rootX]> height[rootY]) {
                roots[rootY] = rootX;
            }
            else if( height[rootX]< height[rootY]) {
                roots[rootX] = rootY;

            }else {
                roots[rootY] = rootX;
                height[rootX]++;
            }
        }

    }

    public boolean isConnected(int x, int y)
    {
        return find(x) == find(y);
    }



}
