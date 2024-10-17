import matplotlib.pyplot as plt
import numpy as np

# Execution time data (in seconds)
labels = ['64x64', '128x128', '256x256', '512x512', '1024x1024']
python_times = [0.11, 0.82, 2.75, 206.41, 0]  # Replaced None with 0
cpp_times = [0.012, 0.062, 0.316, 2.426, 61.003]
java_times = [0.000321, 0.0034, 0.039841, 0, 4.21523]  # Replaced None with 0

# Memory usage data (in bytes)
python_memory = [140768, 554560, 8480272, 0, 0]  # Replaced None with 0
cpp_memory = [98304, 393216, 1572864, 6291456, 25165824]
java_memory = [10485734, 10587198, 10484574, 0, 10484574]  # Replaced None with 0

# CPU usage data (percentage)
python_cpu = [10.26, 8.68, 0, 8.8, 0]  # Replaced None with 0
cpp_cpu = [0, 0, 0, 0, 0]
java_cpu = [0, 0, 0, 0, 0]

# Create the plot
fig, ax1 = plt.subplots(figsize=(12, 6))

x = np.arange(len(labels))  # label positions
bar_width = 0.2

# Bar chart for execution times
bars1 = ax1.bar(x - bar_width, python_times, bar_width, label='Python', color='blue', alpha=0.7)
bars2 = ax1.bar(x, cpp_times, bar_width, label='C++', color='green', alpha=0.7)
bars3 = ax1.bar(x + bar_width, java_times, bar_width, label='Java', color='orange', alpha=0.7)

# Add labels and title
ax1.set_xlabel('Matrix Sizes', fontsize=14)
ax1.set_ylabel('Execution Time (seconds)', fontsize=14)
ax1.set_title('Comparison of Execution Times for Matrix Multiplication', fontsize=16)
ax1.set_xticks(x)
ax1.set_xticklabels(labels, fontsize=12)
ax1.legend(fontsize=12)
ax1.grid(axis='y', linestyle='--', alpha=0.7)

# Add labels above the bars, with "N/A" for unavailable data
def add_value_label(bars):
    for bar in bars:
        height = bar.get_height()
        label = f'{height:.3f}' if height != 0 else 'N/A'  # Show "N/A" if value is 0
        ax1.annotate(label,
                    xy=(bar.get_x() + bar.get_width() / 2, height),
                    xytext=(0, 3),  # 3 points above the bar
                    textcoords='offset points',
                    ha='center', va='bottom', fontsize=10)

add_value_label(bars1)
add_value_label(bars2)
add_value_label(bars3)

# Create a second axis for memory usage data
ax2 = ax1.twinx()  
ax2.set_ylabel('Memory Usage (bytes)', fontsize=14) 

# Bar chart for memory usage
bars_memory1 = ax2.bar(x - bar_width, python_memory, bar_width, label='Python Memory', color='lightblue', alpha=0.4)
bars_memory2 = ax2.bar(x, cpp_memory, bar_width, label='C++ Memory', color='lightgreen', alpha=0.4)
bars_memory3 = ax2.bar(x + bar_width, java_memory, bar_width, label='Java Memory', color='lightcoral', alpha=0.4)

# Add labels above the memory bars, with "N/A" for unavailable data
add_value_label(bars_memory1)
add_value_label(bars_memory2)
add_value_label(bars_memory3)

# Add legend for memory usage
ax2.legend(fontsize=12)

# Show the plot
plt.tight_layout()
plt.show()
