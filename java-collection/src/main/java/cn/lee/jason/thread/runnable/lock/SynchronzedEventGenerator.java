package cn.lee.jason.thread.runnable.lock;

/**
 * Created by jason on 17/2/22.
 */
public class SynchronzedEventGenerator extends IntGenerator {

    private int currentEvenVlaue = 0;

    public synchronized int next() {
        ++currentEvenVlaue;
        Thread.yield();;
        ++currentEvenVlaue;
        Thread.yield();
        return 0;
    }

    public static void main(String[] args){
        EventChecker.test(new SynchronzedEventGenerator());
    }
}
