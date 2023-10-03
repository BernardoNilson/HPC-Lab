import multiprocessing

def process_data(data):
    # Processa os elementos da lista
    processed_data = []
    for item in data:
        processed_data.append(item * 2)  # Exemplo de operação

    return processed_data

if __name__ == '__main__':
    # Dados de entrada
    input_data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    # Divide a lista em partes para cada processo
    num_processes = multiprocessing.cpu_count()  # Obtém o número de CPUs disponíveis
    chunk_size = len(input_data) // num_processes
    chunks = [input_data[i:i+chunk_size] for i in range(0, len(input_data), chunk_size)]

    # Inicia os processos em paralelo
    pool = multiprocessing.Pool(processes=num_processes)
    results = pool.map(process_data, chunks)

    # Combina os resultados
    combined_results = []
    for result in results:
        combined_results.extend(result)

    # Exibe o resultado final
    print(combined_results)
