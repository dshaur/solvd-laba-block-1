package com.solvd.block1.threads_connection_pools.demo2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static final int CONNECTION_POOL_SIZE = 5;

    private static ConnectionPool instance;
    private BlockingQueue<Connection> connections;

    private ConnectionPool() {
        connections = new ArrayBlockingQueue<>(CONNECTION_POOL_SIZE);
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public void addConnection(Connection connection) {
        try {
            connections.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }
}
