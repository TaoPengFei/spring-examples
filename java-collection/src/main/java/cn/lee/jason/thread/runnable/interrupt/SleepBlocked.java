package cn.lee.jason.thread.runnable.interrupt;

import java.util.concurrent.TimeUnit;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/3/5.
 */
public class SleepBlocked implements  Runnable {

    public void run() {
        try{
            TimeUnit.SECONDS.sleep(100);
        }catch (Exception e){
            println(" Interrupted Exception ");
        }
        println( " Exiting SleepBLocked RUN ");
    }
}
