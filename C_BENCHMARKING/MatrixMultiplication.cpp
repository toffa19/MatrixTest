#include <iostream>
#include <vector>
#include <random>
#include <chrono>
#include <cstdlib>

// Function to perform matrix multiplication
void matrixMultiplication(const std::vector<std::vector<double>>& a,
                          const std::vector<std::vector<double>>& b,
                          std::vector<std::vector<double>>& result) {
    int n = a.size(); // Get the size of the matrix
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            result[i][j] = 0; // Initialize the result matrix element
            for (int k = 0; k < n; ++k) {
                result[i][j] += a[i][k] * b[k][j]; // Perform multiplication and addition
            }
        }
    }
}

int main() {
    const int n = 1024; // Size of the matrices
    std::vector<std::vector<double>> a(n, std::vector<double>(n)); // First matrix
    std::vector<std::vector<double>> b(n, std::vector<double>(n)); // Second matrix
    std::vector<std::vector<double>> result(n, std::vector<double>(n)); // Result matrix

    // Initialize matrices a and b with random numbers
    std::mt19937 rng(std::random_device{}()); // Mersenne Twister random number generator
    std::uniform_real_distribution<double> dist(0.0, 1.0); // Uniform distribution between 0.0 and 1.0

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            a[i][j] = dist(rng); // Fill matrix a with random values
            b[i][j] = dist(rng); // Fill matrix b with random values
        }
    }

    // Print the size of the matrices
    std::cout << "Matrix size: " << n << "x" << n << std::endl;

    // Measure execution time
    auto start = std::chrono::high_resolution_clock::now(); // Start timing
    
    matrixMultiplication(a, b, result); // Perform matrix multiplication
    
    auto end = std::chrono::high_resolution_clock::now(); // End timing
    std::chrono::duration<double, std::milli> executionTime = end - start; // Calculate execution time in milliseconds

    // Log the results
    std::cout << "Execution time: " << executionTime.count() << " ms\n";
    
    // Approximate memory usage
    size_t memoryUsed = (a.size() * a[0].size() + b.size() * b[0].size() + result.size() * result[0].size()) * sizeof(double);
    std::cout << "Memory used: " << memoryUsed << " bytes\n";

    return 0; // Exit the program
}
