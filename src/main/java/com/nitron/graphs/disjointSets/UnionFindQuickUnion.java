package com.nitron.graphs.disjointSets;

public class UnionFindQuickUnion {

    private int[] roots;
    public UnionFindQuickUnion(int n) {
        roots = new int[n];
        for(int i = 0; i< n; i++)
            roots[i]=i;

    }

    public int find(int val)
    {
        while(val!=roots[val])
        {
            val = roots[val];
        }

    return val;
    }


    public void union( int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY)
        {
            roots[rootY] = rootX;
        }
    }


    public boolean isConnected(int x, int y)
    {
        return find(x)== find(y);
    }

}
