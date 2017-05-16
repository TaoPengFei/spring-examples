package cn.lee.jason.thread.runnable.atom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static cn.lee.jason.util.Utils.println;


/**
 * Created by jason on 17-3-2.
 */
public class Counter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<Thread>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        println(cas.i + " unsafe ");
        println(cas.atomicInteger.get() + " actomic  ");
        println(""+(System.currentTimeMillis() - start)+" ms ");


    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i, ++i);
            if (suc) {
                break;
            }

        }
    }

    private void count() {
        i++;
    }


}
