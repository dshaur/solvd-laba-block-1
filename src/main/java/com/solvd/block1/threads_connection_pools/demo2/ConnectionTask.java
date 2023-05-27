package com.solvd.block1.threads_connection_pools.demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;

public class ConnectionTask implements Callable<Connection> {
    private ConnectionPool connectionPool;
    private String threadName;

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolDemo.class);

    public ConnectionTask(String threadName) {
        connectionPool = ConnectionPool.getInstance();
        this.threadName = threadName;
    }

    @Override
    public Connection call() throws InterruptedException {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            LOGGER.info(threadName + ": Acquired connection with ID " + connection.getId());

            // Simulating some work with the connection
            doWork(connection);

            LOGGER.info(threadName + ": Released connection with ID " + connection.getId());
        } catch (InterruptedException e) {
            LOGGER.info(threadName + ": Waiting for a connection...");
            throw e;
        } finally {
            if (connection != null) {
                connectionPool.addConnection(connection);
            }
        }
        return connection;
    }

    private void doWork(Connection connection) throws InterruptedException {
        LOGGER.info(threadName + ": Starting work with connection ID " + connection.getId());

        // Simulating work progress
        for (int i = 1; i <= 5; i++) {
            Thread.sleep(1000);
            LOGGER.info(threadName + ": Work in progress... " + i + " seconds");
        }

        LOGGER.info(threadName + ": Work completed with connection ID " + connection.getId());
    }
}

