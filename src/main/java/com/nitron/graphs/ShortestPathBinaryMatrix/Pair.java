package com.nitron.graphs.ShortestPathBinaryMatrix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@EqualsAndHashCode
public class Pair {

    int i;
    int j;

    int dist;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Pair(int i, int j, int dist) {
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}
