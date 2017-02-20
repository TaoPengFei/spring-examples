package cn.lee.jason.thread.runnable.daemon;

import java.util.concurrent.*;

/**
 * Created by jason on 17/2/19.
 */
public class DaemonThreadPoolFactory extends ThreadPoolExecutor {
    public DaemonThreadPoolFactory() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
    }
}
