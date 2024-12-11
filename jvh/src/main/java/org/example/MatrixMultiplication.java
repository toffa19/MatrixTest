package org.example;

import java.util.HashMap;
import java.util.Map;

public class MatrixMultiplication {
    private Map<Integer, Map<Integer, Double>> values;
    private int rows;
    private int cols;

    public MatrixMultiplication(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.values = new HashMap<>();
    }

    public void setValue(int row, int col, double value) {
        if (value != 0) {
            values.computeIfAbsent(row, k -> new HashMap<>()).put(col, value);
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
    
        for (int i : this.values.keySet()) { // Itera solo le righe non nulle
            for (Map.Entry<Integer, Double> entry : this.values.get(i).entrySet()) {
                int k = entry.getKey(); // Colonna della matrice corrente
                double valueA = entry.getValue(); // Valore corrente
                for (int j : other.values.keySet()) { // Itera solo le colonne non nulle della matrice 'other'
                    double valueB = other.getValue(k, j); // Ottieni il valore della matrice 'other'
                    if (valueB != 0) { // Controlla se il valore è non nullo
                        result.setValue(i, j, result.getValue(i, j) + valueA * valueB); // Aggiorna il risultato
                    }
                }
            }
        }
        return result;
    }
    
}
