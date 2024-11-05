import time
import tracemalloc
import psutil  # Assicurati di installare psutil usando pip

# Funzione per la moltiplicazione delle matrici con O(n^3)
def matrix_multiplication(a, b):
    n = len(a)
    result = [[0 for _ in range(n)] for _ in range(n)]
    
    for i in range(n):
        for j in range(n):
            for k in range(n):
                result[i][j] += a[i][k] * b[k][j]
    
    return result

# Setup delle matrici
def setup(n):
    a = [[1.0 for _ in range(n)] for _ in range(n)]
    b = [[1.0 for _ in range(n)] for _ in range(n)]
    return a, b

# Funzione per il benchmarking
def benchmark(n):
    a, b = setup(n)
    
    # Inizia a tracciare la memoria
    tracemalloc.start()
    
    start_time = time.time()  # Inizio conteggio tempo
    result = matrix_multiplication(a, b)  # Esegui moltiplicazione
    end_time = time.time()  # Fine conteggio tempo
    
    # Ottieni l'uso della memoria
    current, peak = tracemalloc.get_traced_memory()
    tracemalloc.stop()  # Ferma il tracciamento della memoria
    
    elapsed_time = end_time - start_time
    return elapsed_time, current, peak, result

# Funzione per ottenere l'uso della CPU
def get_cpu_usage():
    return psutil.cpu_percent()

# Parametro per la dimensione della matrice
n = 512  # Puoi cambiare la dimensione

# Esecuzione benchmark
elapsed_time, current_memory, peak_memory, result = benchmark(n)

print(f"Tempo di esecuzione per la moltiplicazione di due matrici {n}x{n}: {elapsed_time:.6f} secondi")
print(f"Uso della memoria corrente: {current_memory} bytes")
print(f"Uso massimo della memoria: {peak_memory} bytes")
print(f"Uso medio della CPU: {get_cpu_usage()}%")
