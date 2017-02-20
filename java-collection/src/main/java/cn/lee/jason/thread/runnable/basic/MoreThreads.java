package cn.lee.jason.thread.runnable.basic;

/**
 * Created by jason on 17/2/16.
 */
public class MoreThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
