package org.example;

public class MatrixMultiplication {
    public double[][] execute(double[][] a, double[][] b) {
        int n = a.length; // Assuming a and b are square matrices of the same dimension
        double[][] result = new double[n][n]; // Result matrix

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0; // Initialize result matrix element
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j]; // Perform multiplication and addition
                }
            }
        }
        return result; // Return the result matrix
    }
}
