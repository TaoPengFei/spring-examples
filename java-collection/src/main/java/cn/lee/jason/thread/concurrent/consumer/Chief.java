package cn.lee.jason.thread.concurrent.consumer;


import java.util.concurrent.TimeUnit;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17-3-12.
 */
public class Chief implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Chief(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                println(" Chief done " + restaurant.meal);
                if (++count == 10) {
                    println(" out of food .closing");
                    restaurant.executorService.shutdownNow();
                }
                println(" Order up! ");
                synchronized (restaurant.wp) {
                    restaurant.meal = new Meal(count);
                    restaurant.wp.notifyAll();
                }
                TimeUnit.MICROSECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            println(" Chief interrupted! ");
        }
    }
}
