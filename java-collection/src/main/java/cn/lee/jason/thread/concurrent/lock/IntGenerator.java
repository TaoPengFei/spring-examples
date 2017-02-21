package cn.lee.jason.thread.concurrent.lock;

/**
 * Created by jason on 17/2/22.
 */
public abstract class IntGenerator {

    private volatile boolean cancled = false;

    public abstract int next();

    public boolean isCancled() {
        return cancled;
    }

    public void cancle() {
        cancled = true;
    }
}
