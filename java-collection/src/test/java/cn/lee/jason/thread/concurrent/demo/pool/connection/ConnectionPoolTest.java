package cn.lee.jason.thread.concurrent.demo.pool.connection;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * Created by jason on 17-3-28.
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    @Test
    public void test() throws InterruptedException {
        int threadCount = 100;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger noGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, noGot),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.print( " total invoke "+(threadCount * count));
        System.out.print( " got Conncetion "+(got));
        System.out.println( " noGot Conncetion "+(noGot));

    }


    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger noGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger noGot) {
            this.count = count;
            this.got = got;
            this.noGot = noGot;
        }

        public void run() {
            try {
                start.await();
            } catch (Exception ex) {

            }
            while (count > 0) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.rerleaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        noGot.incrementAndGet();
                    }
                } catch (Exception ex) {

                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
