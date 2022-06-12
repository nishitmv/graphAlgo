package com.nitron.graphs.EarliestMomentWhenEveryoneBecomesFriends;

import java.util.*;
import java.util.stream.Collectors;

public class FindEarliestTimeStamp {

    int[] roots;
    int[] heights;

    int count ;
    public long findEarliestTimeStamp(int[][] logs, int n) {
        count =n;
        roots = new int[n];
        heights = new int[n];

        for (int i = 0; i < n; i++) {
            roots[i] = i;
            heights[i] = 1;
        }
        Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));

        for(int[] log: logs) {
            union(log[1], log[2]);
            if(count==1)
            {
                return log[0];
            }
        }
        return -1;
    }


    private int find(int val) {

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
            //Same as Graph Valid tree , Initial root count is n, which each root removed decrement count by 1, 1 root remains means single tree.
            count--;
            if(heights[rootX]>heights[rootY]) {
                roots[rootY] = rootX;
            } else if( heights[rootY]>heights[rootX]) {
                roots[rootX] = rootY;
            }
            else{
                roots[rootY] = rootX;
                heights[rootX]++;
            }
        }
    }

}
