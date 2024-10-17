package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime) // Sets the benchmark mode to measure average time
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Sets the output time unit to milliseconds
@State(Scope.Thread) // Indicates that this state is specific to a thread
@Fork(1) // Specifies the number of forks to use
@Warmup(iterations = 3) // Defines the number of warmup iterations
@Measurement(iterations = 5) // Defines the number of measurement iterations
public class MatrixMultiplicationBenchmarking {

    private final int n = 256; // Size of the matrices
    public final double[][] a = new double[n][n]; // First matrix
    public final double[][] b = new double[n][n]; // Second matrix

    @Setup(Level.Trial) // Setup method to initialize the matrices before each trial
    public void setup() {
        Random random = new Random(); // Create a random number generator
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = random.nextDouble(); // Fill matrix a with random values
                b[i][j] = random.nextDouble(); // Fill matrix b with random values
            }
        }
    }

    @Benchmark // Indicates this method is a benchmark
    public void multiplication(Blackhole blackhole) {
        // Measure execution time
        long startTime = System.nanoTime();

        // Measure memory before multiplication
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double[][] result = new MatrixMultiplication().execute(a, b); // Perform matrix multiplication
        // Measure memory after multiplication
        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memoryUsed = memoryAfter - memoryBefore; // Calculate memory used

        // Measure execution time
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime; // in nanoseconds

        blackhole.consume(result); // Consume the result to prevent optimization

        // Log or handle memory usage and execution time if necessary
        // System.out.printf("Execution time: %d ms\n", TimeUnit.NANOSECONDS.toMillis(executionTime));
        // System.out.printf("Memory used: %d bytes\n", memoryUsed);
    }

    // Optional: to monitor CPU usage
    public static double getCpuUsage() {
        // Simplified implementation: use the operating system or profiling tools to get CPU usage.
        // Here you could insert logic to collect CPU usage information if necessary.
        return -1; // Returns -1 if not implemented
    }
}
