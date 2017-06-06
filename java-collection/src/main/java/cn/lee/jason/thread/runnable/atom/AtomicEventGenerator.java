package cn.lee.jason.thread.runnable.atom;

import java.util.concurrent.atomic.AtomicInteger;

import cn.lee.jason.thread.runnable.volatiles.EventChecker;
import cn.lee.jason.thread.runnable.volatiles.IntGenerator;

/**
 * Created by jason on 17-2-24.
 */
public class AtomicEventGenerator extends IntGenerator{

    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    public int next() {
        return currentEvenValue.addAndGet(2);
    }
    public  static void main(String [] args){
        EventChecker.test(new AtomicEventGenerator());
    }
}
