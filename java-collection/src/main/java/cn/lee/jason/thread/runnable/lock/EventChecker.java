package cn.lee.jason.thread.runnable.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/2/22.
 */
public class EventChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EventChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    public void run() {
        while (!generator.isCancled()) {
            int val = generator.next();
            if (val % 2 == 0) {
                println(val + " not even! ");
                generator.cancle();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        println(" Ctrl +c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EventChecker(generator, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator generator) {
        test(generator, 10);
    }
}
