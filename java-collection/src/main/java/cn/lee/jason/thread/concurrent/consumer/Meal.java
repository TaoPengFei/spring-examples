package cn.lee.jason.thread.concurrent.consumer;

/**
 * Created by jason on 17-3-12.
 */
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}
