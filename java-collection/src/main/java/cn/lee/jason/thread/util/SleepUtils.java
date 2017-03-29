package cn.lee.jason.thread.util;

import java.util.concurrent.TimeUnit;

/**
 * Created by jason on 17/3/25.
 */
public class SleepUtils {
    public static void second(long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
