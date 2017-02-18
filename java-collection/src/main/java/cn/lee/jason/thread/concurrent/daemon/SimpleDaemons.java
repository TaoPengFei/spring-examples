package cn.lee.jason.thread.concurrent.daemon;

import cn.lee.jason.thread.concurrent.priority.SimplePriorities;

import java.util.concurrent.TimeUnit;


/**
 * Created by jason on 17/2/18.
 */
public class SimpleDaemons implements Runnable {

    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + "   " + this);
            }
        } catch (InterruptedException e) {
            print("sleep interrupted");
            e.printStackTrace();
        }
    }

    private static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        print(" All daemon started");
        TimeUnit.MILLISECONDS.sleep(175);

    }

}
