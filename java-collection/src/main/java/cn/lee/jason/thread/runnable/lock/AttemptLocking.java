package cn.lee.jason.thread.runnable.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/2/23.
 */
public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            println(" tryLock " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;

        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            println(" tryLock(2,TimeUnit.SECONDS) : " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking lal = new AttemptLocking();
        lal.untimed();
        lal.timed();
        new Thread() {
            @Override
            public void run() {
                lal.lock.lock();
            }

            {
                setDaemon(true);
            }
        }.start();
        Thread.yield();
        lal.untimed();
        lal.timed();
    }
}
