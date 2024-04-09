package org.example;

public class Algorithm {
    public int[] parentRepresentOfMST;
    private int[] minDirectionToV;
    private boolean[] mst;
    public int iterations;

    public MST doPrim(int[][] graph) {
        parentRepresentOfMST = new int[graph.length];
        minDirectionToV = new int[graph.length];
        mst = new boolean[graph.length];
        for (int i = 1; i < graph.length; ++i) {
            minDirectionToV[i] = Integer.MAX_VALUE;
            iterations++;
        }
        parentRepresentOfMST[0] = -1;

        for (int i = 0; i < graph.length; ++i) {
            int k = 0;
            if (!mst[i]) k = min(minDirectionToV, mst); // pick V with min length to it that wasn't marked
            mst[i] = true; // mark it
            for (int j = 0; j < graph.length; ++j) { // so now starting to look what Vs we can approach from picked V (if this direction will be cheaper)
                if (graph[k][j] != 0 && !mst[j] && graph[k][j] < minDirectionToV[j]) {
                    minDirectionToV[j] = graph[k][j];
                    parentRepresentOfMST[j] = k;
                }
                iterations++;
            }
        }
        return new MST(graph, parentRepresentOfMST);
    }
    private int min(int[] x, boolean[] mst) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < x.length; ++i) {
            if (x[i] < min && !mst[i]) {
                min = x[i];
                index = i;
            }
            iterations++;
        }
        return index;
    }

}
