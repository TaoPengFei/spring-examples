package cn.lee.jason.thread.concurrent.counter;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jason on 17-4-17.
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.wait();
        System.out.println(3);
    }

}
