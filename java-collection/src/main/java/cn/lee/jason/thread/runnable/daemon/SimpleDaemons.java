package cn.lee.jason.thread.runnable.daemon;

import java.util.concurrent.TimeUnit;

import static cn.lee.jason.util.Utils.*;

/**
 * Created by jason on 17/2/18.
 */
public class SimpleDaemons implements Runnable {

    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                println(Thread.currentThread() + "   " + this);
            }
        } catch (InterruptedException e) {
            println("sleep interrupted");
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        println(" All daemon started");
        TimeUnit.MILLISECONDS.sleep(175);

    }

}
