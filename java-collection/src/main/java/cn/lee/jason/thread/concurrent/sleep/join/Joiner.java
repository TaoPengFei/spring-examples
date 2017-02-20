package cn.lee.jason.thread.concurrent.sleep.join;

import static cn.lee.jason.util.Utils.print;

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
            print(getName()+ " Interrupted ");
        }
        print(getName() + " joined complete ");
    }

}
