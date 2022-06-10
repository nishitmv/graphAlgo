package com.nitron.graphs.disjointSets;

public class UnionFindQuickUnionByRankCompressedPath {

    int[] roots;
    int[] heights;

    public UnionFindQuickUnionByRankCompressedPath(int n)
    {
        roots = new int[n];
        heights = new int[n];
        for(int i=0;i<n;i++)
        {
            roots[i] = i;
            heights[i] = 1;
        }
    }

    private int find(int val )
    {
        if(roots[val]==val){
            return val;
        }
       else
        {
          return  roots[val] =find(roots[val]);
        }
    }

    public void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY)
        {
            if(heights[rootX]>heights[rootY])
            {
                roots[rootY]  = rootX;
            }
            else if ( heights[rootY]> heights[rootX])
            {
                roots[rootX] = rootY;
            }
            else {
                roots[rootY]  = rootX;
                heights[rootX]++;
            }
        }

    }

    public boolean isConnected(int x, int y)
    {
        return find(x)==find(y);
    }


}
