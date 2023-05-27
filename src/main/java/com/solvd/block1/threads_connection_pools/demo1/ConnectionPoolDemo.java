package com.solvd.block1.threads_connection_pools.demo1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPoolDemo {
    private static final int CONNECTION_POOL_SIZE = 5;

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolDemo.class);

    public static void main(String[] args) throws InterruptedException {
        // Create Connection Pool
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        // Initialize Connection Pool object of size 5
        for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
            Connection connection = new Connection(i + 1);
            connectionPool.addConnection(connection);
        }

        // Create threads
        Thread[] threads = new Thread[7];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new ConnectionTask("Thread " + (i + 1)));
            threads[i].start();
        }
        for (int i = 5; i < 7; i++) {
            threads[i] = new Thread(new ConnectionTask("Thread " + (i + 1)));
        }

        // Start the remaining two threads
        threads[5].start();
        threads[6].start();

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        LOGGER.info("All threads finished executing.");
    }
}
