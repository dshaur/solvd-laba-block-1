package com.solvd.block1.threads_connection_pools.demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

/*
 * This demo version 2 implements previous version (demo1) but with interfaces Future and CompletableStage
 */

public class ConnectionPoolDemo {
    private static final int CONNECTION_POOL_SIZE = 5;
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolDemo.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create Connection Pool
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        // Initialize Connection Pool object of size 5
        for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
            Connection connection = new Connection(i + 1);
            connectionPool.addConnection(connection);
        }

        // Load Connection Pool using single threads and Java Thread Pool (7 threads in total)
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        CompletionService<Connection> completionService = new ExecutorCompletionService<>(executorService);

        // Submit tasks to the thread pool
        for (int i = 0; i < 5; i++) {
            completionService.submit(new ConnectionTask("Thread " + (i + 1)));
        }
        for (int i = 5; i < 7; i++) {
            completionService.submit(new ConnectionTask("Thread " + (i + 1)));
        }


        // Shutdown the executor service
        executorService.shutdown();

        // Wait for all threads to finish
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        LOGGER.info("All threads finished executing.");
    }
}
