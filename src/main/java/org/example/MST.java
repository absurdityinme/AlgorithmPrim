package org.example;

public class MST {
    int[][] graph;
    int[] mst;
    int value;
    MST(int[][] graph, int[] mst) {
        this.graph = graph;
        this.mst = mst;
        for (int i = 1; i < mst.length; ++i) {
            value += graph[i][mst[i]];
        }
    }
    public int getValue() {
        return value;
    }
    public void print() {
        for (int i = 0; i < mst.length; ++i) {
            System.out.println("(" + mst[i] + ", " + i + ")");
        }
    }
}
