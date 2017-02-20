package cn.lee.jason.thread.concurrent.volatiles;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static cn.lee.jason.util.Utils.print;

/**
 * Created by jason on 17-2-20.
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
            if (val % 2 != 0) {
                print(val + " not even! ");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        print(" Press Ctrl+C to exit ");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new EventChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
