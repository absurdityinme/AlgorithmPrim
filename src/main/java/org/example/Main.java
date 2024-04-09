package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\anyak\\OneDrive\\Документы\\test.txt"));
        while (scanner.hasNext()) {
            Algorithm alg = new Algorithm();
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            long startTime = System.currentTimeMillis();
            alg.doPrim(matrix);
            long endTime = System.currentTimeMillis();
            System.out.println(n + " " + (endTime - startTime) + " " + alg.iterations);

        }
    }
}
