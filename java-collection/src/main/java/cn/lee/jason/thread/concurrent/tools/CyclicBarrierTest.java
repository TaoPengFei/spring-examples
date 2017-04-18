package cn.lee.jason.thread.concurrent.tools;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by jason on 17-4-18.
 */
public class CyclicBarrierTest {

    static CyclicBarrier cb = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cb.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        try {
            cb.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
