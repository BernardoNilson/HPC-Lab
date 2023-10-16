package threads;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Esse é a aplicação que vamos usar como base para um curso sobre paralelismo com Threads em Java pela Alura
 */
public class ServerTask {

    public static void main(String[] args) throws Exception {
        
        // Criação do servidor e abertura da porta de entrada
        System.out.println("Starting server!");
        ServerSocket server = new ServerSocket(12345);

        // Cria uma piscina de Threads disponíveis, que deixaram ser usadas pelos clientes. Poupa recursos de abertura e fechamento de threads
        // ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // Loop para aceitar novos clientes !threadPool.isTerminated()
        while (!threadPool.isShutdown()) {
            // Aceita o cliente na porta 12345 e informa para qual porta a conexão foi direcionada.
            Socket socket = server.accept();
            System.out.println("Client accepted " + socket.getPort());

            // Distribui as tarefas ao cliente
            DistributeTasks distributeTasks = new DistributeTasks(socket);
            threadPool.execute(distributeTasks);

        }

        // Informa todas as threads conectadas ao servidor
        Set<Thread> allThreads = Thread.getAllStackTraces().keySet();
        for (Thread thread : allThreads){
            System.out.println(thread.getName());
        }

        // Informa a quantidade de processadores disponíveis
        Runtime runtime = Runtime.getRuntime();
        int processorCount = runtime.availableProcessors();
        System.out.println("Available processors: " + processorCount);

        server.close();
        threadPool.shutdown();
    }
}