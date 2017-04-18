package cn.lee.jason.thread.concurrent.demo.pool.connection;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by jason on 17-3-28.
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void rerleaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.add(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills < 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remainMills = mills;
                while (pool.isEmpty() && remainMills > 0) {
                    pool.wait(remainMills);
                    remainMills = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
