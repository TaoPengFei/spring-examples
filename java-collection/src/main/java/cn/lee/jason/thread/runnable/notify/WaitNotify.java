package cn.lee.jason.thread.runnable.notify;

import cn.lee.jason.thread.util.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/3/25.
 */
public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread wait = new Thread(new Wait(), " WaitThread ! ");
        wait.start();
        SleepUtils.second(1);
        Thread notify = new Thread(new Notify()," NotifyThread ! ");
        notify.start();
    }

    static class Wait implements Runnable {
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        println(Thread.currentThread() + " flag is true. wait @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                println(Thread.currentThread() + " flag is false. running @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        public void run() {
            synchronized (lock) {
                println(Thread.currentThread() + " hold lock .notify@" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            synchronized (lock) {
                println(Thread.currentThread() + " hold lock again.sleep@" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }

}
