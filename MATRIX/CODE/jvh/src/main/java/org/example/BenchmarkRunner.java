package org.example;

//>java -jar target/jmh-src-test-1.0-SNAPSHOT.jar -v EXTRA
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
        .include(MatrixMultiplicationBenchmarking.class.getSimpleName()) // Include the benchmark class
        .forks(1) // Number of forks
        .warmupIterations(3) // Number of warmup iterations
        .measurementIterations(5) // Number of measurement iterations
        .addProfiler("gc") // To display garbage collection
        .addProfiler("stack") // To profile the stack
        .build();

    new Runner(opt).run(); // Run the benchmark
    }
}
