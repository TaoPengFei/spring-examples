package cn.lee.jason.thread.concurrent.end;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/3/1.
 */
public class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entranceList = new ArrayList<Entrance>();
    private int number = 0;
    private static volatile boolean canceled = false;

    public static boolean cancle() {
        canceled = true;
        return canceled;
    }

    public Entrance(int number) {
        this.number = number;
        entranceList.add(this);
    }

    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            println(this + " Total :" + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
                println(" Sleep interrupted ");
            }
        }
        println(" Stopping this ");
    }

    public static int getTotalCount() {
        return count.value();
    }
    public static int sumEntrances(){
        int sum = 0;
        for(Entrance en : entranceList){
            sum += en.getNumber();
        }
        return sum;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance{" +
                "number=" + getNumber() +
                '}';
    }


}
