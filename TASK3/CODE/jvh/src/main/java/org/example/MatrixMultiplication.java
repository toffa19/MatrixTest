package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MatrixMultiplication {
    private Map<Integer, Map<Integer, Double>> values;
    private int rows;
    private int cols;

    public MatrixMultiplication(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.values = new ConcurrentHashMap<>();
    }

    public void setValue(int row, int col, double value) {
        if (value != 0) {
            values.computeIfAbsent(row, k -> new ConcurrentHashMap<>()).put(col, value);
        }
    }

    public double getValue(int row, int col) {
        return values.getOrDefault(row, new HashMap<>()).getOrDefault(col, 0.0);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public MatrixMultiplication multiply(MatrixMultiplication other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Incompatible matrix dimensions for multiplication.");
        }

        MatrixMultiplication result = new MatrixMultiplication(this.rows, other.cols);

        // Parallelizza la moltiplicazione
        this.values.keySet().parallelStream().forEach(i -> {
            Map<Integer, Double> rowA = this.values.get(i);
            rowA.forEach((k, valueA) -> {
                other.values.getOrDefault(k, new HashMap<>()).forEach((j, valueB) -> {
                    result.values.computeIfAbsent(i, x -> new ConcurrentHashMap<>())
                            .merge(j, valueA * valueB, Double::sum);
                });
            });
        });

        return result;
    }
}
