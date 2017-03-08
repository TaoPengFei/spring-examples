package cn.lee.jason.thread.runnable.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/3/5.
 */
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable runnable) throws InterruptedException {
        Future<?> future = exec.submit(runnable);
        TimeUnit.MILLISECONDS.sleep(100);
        println(" Interruting " + runnable.getClass().getName());
        future.cancel(true);
        println(" Interrupt sent to " + runnable.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        println(" Aborting with System.exit(0) ");
        System.exit(0);
    }
}
