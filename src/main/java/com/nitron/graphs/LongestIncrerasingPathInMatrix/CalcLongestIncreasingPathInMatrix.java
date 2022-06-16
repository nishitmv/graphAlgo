package com.nitron.graphs.LongestIncrerasingPathInMatrix;

public class CalcLongestIncreasingPathInMatrix {

    Integer[][] memMatrix;
    int ans =1;
    public int calc(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        memMatrix = new Integer[m + 1][n + 1];

        for (int i = 0; i <=m; i++)
            for (int j = 0; j <=n; j++)
            {
                memMatrix[i][j]   = calcLongestIncreasingPath(matrix, i, j, m-1, n-1);
            }

        for (int i = 0; i <=m; i++)
            for (int j = 0; j <=n; j++)
            {
                ans = Math.max(ans, memMatrix[i][j]);
            }

        return ans;
    }

    private int calcLongestIncreasingPath(int[][] matrix, int i, int j, int m, int n) {

        if(i>m || j>n)
            return 0;
        if(memMatrix[i][j]!=null)
            return memMatrix[i][j];
        int currVal = matrix[i][j];

        // 1 because you start from one element .
        int leftToRight=1;
        int rightToLeft =1;
        int topToBottom =1;
        int bottomToTop =1;
        if(j<n && matrix[i][j+1]>currVal)
            leftToRight = 1+calcLongestIncreasingPath(matrix, i, j+1, m, n);
        if(j>0 && matrix[i][j-1]>currVal)
            rightToLeft = 1+calcLongestIncreasingPath(matrix, i, j-1, m, n);
        if(i<m && matrix[i+1][j]> currVal)
             topToBottom = 1+calcLongestIncreasingPath(matrix, i+1, j, m, n);
        if(i>0 && matrix[i-1][j]> currVal)
            bottomToTop = 1+calcLongestIncreasingPath(matrix, i-1, j, m, n);

        return Math.max( Math.max(leftToRight, rightToLeft), Math.max(topToBottom, bottomToTop));
    }
}
