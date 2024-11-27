# Parallel and Vectorized Matrix Multiplication

This project explores parallel computing techniques and vectorization for matrix multiplication. It compares the performance of the basic matrix multiplication algorithm with its parallel and vectorized counterparts, using Java for multi-threading and SIMD instructions in C++.

## Features

- **Parallel Matrix Multiplication**: Implemented using Java's ForkJoin framework for multi-threading.
- **Vectorized Matrix Multiplication**: Optional implementation using SIMD instructions (e.g., AVX in C++) for performance improvement.
- **Benchmarking**: Performance is tested on large matrices (e.g., 256x256, 512x512, 1024x1024, 2048x2048) with detailed metrics on execution time, memory usage, and garbage collection.
- **Comparison**: Results from the basic, parallel, and vectorized algorithms are compared to analyze the speedup, efficiency, and resource usage.

## Requirements

- **Java**: JDK 21 (for the parallel implementation).
- **C++**: Optional vectorized implementation using SIMD instructions.
- **JMH**: Java Microbenchmarking Harness for benchmarking.

## Setup

### Java Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/parallel-matrix-multiplication.git
    cd parallel-matrix-multiplication
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. To run the parallel matrix multiplication benchmark:
    ```bash
    mvn exec:java -Dexec.mainClass="MatrixMultiplication"
    ```
    
### Matrix Size 2048x2048

- **Average Execution Time**: 31,691.818 ms
- **Memory Allocation**: ~37.208 GB per operation
- **Garbage Collection**:
  - Average GC Churn: 1.106 MB/sec
  - G1 Eden Space Churn: 1.106 MB/sec
  - GC Count: 66

### Matrix Size 1024x1024

- **Average Execution Time**: 3461.436 ms
- **Memory Allocation**: 1228.518 MB/sec
- **GC Count**: 66
- **Thread States**:
  - RUNNABLE: 78.3\%
  - TIMED_WAITING: 10.1\%
  - BLOCKED: 2.9\%

### Matrix Size 512x512

- **Average Execution Time**: 401.315 ms
- **Memory Allocation**: 1325.449 MB/sec
- **GC Count**: 102

### Matrix Size 256x256

- **Average Execution Time**: 47.909 ms
- **Memory Allocation**: 1413.002 MB/sec

## Performance Analysis

The parallel implementation shows significant speedup over the basic algorithm, especially for larger matrix sizes. The vectorized approach (optional) further optimizes execution by leveraging SIMD instructions for efficient processing. Memory allocation and garbage collection activity are notably higher for larger matrices, with significant churn observed in the G1 Eden space.

## Future Work

- **Optimize Garbage Collection**: Implement strategies to reduce GC impact, such as tuning JVM parameters or adjusting the memory model.
- **Additional Vectorization**: Experiment with different SIMD instruction sets (e.g., AVX2, AVX-512).
- **Scalability**: Test the parallel implementation with larger matrices and across multiple machines to assess scalability.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
