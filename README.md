# Matrix Multiplication Benchmarking

This project benchmarks the performance of matrix multiplication algorithms implemented in Python, C++, and Java. The benchmarking focuses on execution time, memory usage, and CPU utilization across different matrix sizes.

## Table of Contents

- [Introduction](#introduction)
- [Experiments](#experiments)
- [Results](#results)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## Introduction

This repository contains implementations of matrix multiplication algorithms using a basic O(n^3) complexity. The goal is to compare the performance of these implementations across different programming languages and analyze the results in terms of execution time, memory consumption, and CPU usage.

## Experiments

Experiments were conducted for each language, documenting the results in terms of execution time, memory usage, and CPU utilization. The collected data are presented below:

### Execution Times (in seconds)

| Matrix Size | Python | C++    | Java   |
|-------------|--------|--------|--------|
| 64x64       | 0.11   | 0.012  | 0.000321 |
| 128x128     | 0.82   | 0.062  | 0.0034 |
| 256x256     | 2.75   | 0.316  | 0.039841 |
| 512x512     | 206.41 | 2.426  | N/A    |
| 1024x1024   | N/A    | 61.003 | 4.21523 |

### Memory Usage (in bytes)

| Matrix Size | Python | C++       | Java        |
|-------------|--------|-----------|-------------|
| 64x64       | 140768 | 98304     | 10485734    |
| 128x128     | 554560 | 393216    | 10587198    |
| 256x256     | 8480272| 1572864   | 10484574    |
| 512x512     | N/A    | 6291456   | N/A         |
| 1024x1024   | N/A    | 25165824  | 10484574    |

### CPU Usage (percentage)

| Matrix Size | Python | C++ | Java |
|-------------|--------|-----|------|
| 64x64       | 10.26  | N/A | N/A  |
| 128x128     | 8.68   | N/A | N/A  |
| 256x256     | N/A    | N/A | N/A  |
| 512x512     | 8.8    | N/A | N/A  |
| 1024x1024   | N/A    | N/A | N/A  |

## Installation

To run the benchmarks, clone this repository and ensure you have the following installed:

- Python 3.x
- C++ compiler (e.g., g++)
- Java Development Kit (JDK)

```bash
git clone https://github.com/yourusername/matrix-multiplication-benchmarking.git
cd matrix-multiplication-benchmarking
