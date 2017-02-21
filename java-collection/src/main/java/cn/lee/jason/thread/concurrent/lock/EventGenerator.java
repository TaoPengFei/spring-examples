package cn.lee.jason.thread.concurrent.lock;

/**
 * Created by jason on 17/2/22.
 */
public class EventGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EventChecker.test(new EventGenerator());
    }
}
