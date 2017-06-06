package cn.lee.jason.thread.runnable.end;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/3/1.
 */
public class OrnamentalGarden {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancle();
        exec.shutdown();
        if(!exec.awaitTermination(250,TimeUnit.MILLISECONDS)){
            println(" SOme tasks were not terminated! ");
        }
        println(" Total = "+Entrance.getTotalCount());
        println(" SUM = "+Entrance.sumEntrances());


    }
}
