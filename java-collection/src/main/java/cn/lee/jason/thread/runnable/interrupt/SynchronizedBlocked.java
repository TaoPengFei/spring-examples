package cn.lee.jason.thread.runnable.interrupt;


import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/3/5.
 */
public class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f();
            }
        };
    }

    public void run() {
        println(" Trying to call f() ");
        f();
        println(" Exiting SynchronizedBlocked.run() ");
    }
}
