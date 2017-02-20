package cn.lee.jason.thread.runnable.basic.exam01;

/**
 * Created by jason on 17/2/17.
 */
public class Exam implements Runnable {

    private static int taskCount = 0;
    private final int id = taskCount++;

    public void run() {
        System.out.print("#" + id + " yeild 1 ");
        Thread.yield();
        System.out.print("#" + id + " yeild 2 ");
        Thread.yield();
        System.out.print("#" + id + " yeild 3 ");
        Thread.yield();
        System.out.println("#" + id + " end ");
    }

    public Exam() {
        System.out.print("#" + id + " start ");
    }
}
