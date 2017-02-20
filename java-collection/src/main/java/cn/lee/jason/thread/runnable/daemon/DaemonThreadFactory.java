package cn.lee.jason.thread.runnable.daemon;

import java.util.concurrent.ThreadFactory;

/**
 * Created by jason on 17/2/18.
 */
public class DaemonThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
