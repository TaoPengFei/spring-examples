package cn.lee.jason.thread.concurrent.consumer;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17-3-12.
 */
public class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {

        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                println(" WaitPerson get " + restaurant.meal);
                synchronized (restaurant.chief) {
                    restaurant.meal = null;
                    restaurant.chief.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            println(" WaitPerson interrupt！ ");
        }
    }
}
