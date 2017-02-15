package cn.lee.jason.thread.runnable.basic;

/**
 * Created by jason on 17/2/16.
 */
public class MainThread {

    public static void main(String[] args) {
        LiftOff lift = new LiftOff();
        lift.run();

        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff");
    }
}
