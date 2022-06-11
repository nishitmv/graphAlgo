package com.nitron.graphs.NumberOfProvinces;

public class ProvinceCounter {

    int[] roots;
    int[] heights;

    int count;
    public ProvinceCounter(int length) {

        roots = new int[length];
        heights = new int[length];

        for(int i=0;i<length;i++)
        {
            roots[i]=i;
            heights[i] =1;
        }
    }

    public int countProvinces(int[][] matrix)
    {
        count = matrix.length;
        for(int i=0;i<matrix.length; i++)
            {
                for(int j=i+1;j<matrix.length;j++)
                {
                    if(matrix[i][j]==1)
                      union(i,j);
                }
            }
    return count;
    }

    public int find(int val)
    {
        if(val == roots[val])
            return val;
        else {
            roots[val] = find(roots[val]);
            return roots[val];
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
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
