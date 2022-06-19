package com.nitron.graphs.ShortestPathBinaryMatrix;

import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        int[][] matrix = {{0,1,1,0,0,0},
                          {0,1,0,1,1,0},
                          {0,1,1,0,1,0},
                          {0,0,0,1,1,0},
                          {1,1,1,1,1,0},
                          {1,1,1,1,1,0}};
        int[][] matrix1 = {{0,1,0,0,0,0},
                           {0,1,0,1,1,0},
                           {0,1,1,0,1,0},
                           {0,0,0,0,1,0},
                           {1,1,1,1,1,0},
                           {1,1,1,1,1,0}};

        int[][] matrix2 = { {0,0,0},
                            {1,0,0},
                            {1,1,0}};

        int[][] matrix3 = {{0,0,0,0},
                            {1,0,0,1},
                            {0,1,0,0},
                            {0,0,0,0}};
        Instant start = Instant.now();
        System.out.println(new BinaryMatrixShortestPathFinder().findShortestPath(matrix3));
        System.out.println(Duration.between(start, Instant.now()));

    }

}
