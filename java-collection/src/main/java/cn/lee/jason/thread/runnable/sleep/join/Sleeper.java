package cn.lee.jason.thread.runnable.sleep.join;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17-2-20.
 */
public class Sleeper extends Thread{

    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try{
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
            println(getName()+" was interrupted.isInterrupted() :"+isInterrupted());
            return ;
        }
        println(getName()+" has awakened ");
    }
}
