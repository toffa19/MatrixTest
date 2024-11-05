package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(1)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class MatrixMultiplicationBenchmarking {

    private final int n = 2048; // Dimensione della matrice
    public MatrixMultiplication a = new MatrixMultiplication(n, n); // Matrice A
    public MatrixMultiplication b = new MatrixMultiplication(n, n); // Matrice B

    @Setup(Level.Trial)
    public void setup() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (random.nextDouble() > 0.7) { // Configura sparsity
                    a.setValue(i, j, random.nextDouble());
                }
                if (random.nextDouble() > 0.7) {
                    b.setValue(i, j, random.nextDouble());
                }
            }
        }
    }

    @Benchmark
    public void multiplication(Blackhole blackhole) {
        MatrixMultiplication result = a.multiply(b); // Moltiplica le matrici
        blackhole.consume(result); // Usa Blackhole per evitare ottimizzazioni
    }
}
