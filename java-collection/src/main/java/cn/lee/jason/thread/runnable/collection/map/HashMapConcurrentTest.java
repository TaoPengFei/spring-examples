package cn.lee.jason.thread.runnable.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * map死锁案例
 * 多线程下HashMap会爆出死锁问题
 * Created by jason on 17-5-16.
 */
public class HashMapConcurrentTest {


    public static void main(String[] args) throws InterruptedException {
        final Map<String, String> map = new HashMap<String, String>(2);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "tff" + i).start();
                }
            }
        });
        thread.start();
        thread.join();
    }
}