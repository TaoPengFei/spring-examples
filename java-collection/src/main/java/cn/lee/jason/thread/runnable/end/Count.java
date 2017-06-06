package cn.lee.jason.thread.runnable.end;

import java.util.Random;

/**
 * Created by jason on 17/3/1.
 */

public class Count {

    private int count = 0;
    private Random random = new Random(47);

    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean()) {
            Thread.yield();
        }
        return count = ++temp;
    }

    public synchronized int value() {
        return count;
    }

}
