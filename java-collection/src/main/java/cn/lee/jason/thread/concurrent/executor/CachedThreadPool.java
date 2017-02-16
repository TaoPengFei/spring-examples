package cn.lee.jason.thread.concurrent.executor;

import cn.lee.jason.thread.runnable.basic.LiftOff;
import cn.lee.jason.thread.runnable.basic.exam01.Exam;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jason on 17/2/17.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new Exam());
        }
        service.shutdown();
    }
}
