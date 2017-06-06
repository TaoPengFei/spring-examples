package cn.lee.jason.thread.runnable.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jason on 17/2/22.
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EventChecker.test(new MutexEvenGenerator());
    }
}
