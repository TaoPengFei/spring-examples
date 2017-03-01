package cn.lee.jason.thread.runnable.sleep.join;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17-2-20.
 */
public class Joiner extends Thread{

    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try{
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            println(getName()+ " Interrupted ");
        }
        println(getName() + " joined complete ");
    }

}
