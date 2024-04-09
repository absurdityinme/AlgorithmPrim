package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomMatrix {
    public static void main(String[] args) {
        int n = 50; // count of datasets
        int up = 10000; // upper bound
        int down = 100; // lower bound
        int wb = 100; // Weight Bound
        Random random = new Random();
        try(FileWriter writer = new FileWriter("test.txt", false))
        {
            for (int k = 0; k < n; ++k) {
                int v = random.nextInt(up - down) + down;
                int[][] matrix = new int[v][v];
                for (int i = 0; i < v; ++i) {
                    for (int j = 0; j < v; ++j) {
                        if (i == j) matrix[i][j] = 0;
                        else {
                            int x = random.nextInt(4);
                            if (x == 0) {
                                matrix[i][j] = 0;
                                matrix[j][i] = 0;
                            } else {
                                int r = random.nextInt(wb) + 1;
                                matrix[i][j] = r;
                                matrix[j][i] = r;
                            }
                        }
                    }
                }
                writer.write(v + "\n");
                for (int i = 0; i < v; ++i) {
                    String s = "";
                    for (int j = 0; j < v; ++j) {
                        s += matrix[i][j] + " ";
                    }
                    writer.write(s + "\n");
                }
            }

            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
