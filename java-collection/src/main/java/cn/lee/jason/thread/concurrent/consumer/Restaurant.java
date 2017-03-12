package cn.lee.jason.thread.concurrent.consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jason on 17-3-12.
 */
public class Restaurant {
    Meal meal;
    ExecutorService executorService = Executors.newCachedThreadPool();
    WaitPerson wp = new WaitPerson(this);
    Chief chief = new Chief(this);

    public Restaurant() {
        executorService.execute(chief);
        executorService.execute(wp);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
