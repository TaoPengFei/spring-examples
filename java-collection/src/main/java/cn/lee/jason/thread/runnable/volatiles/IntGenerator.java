package cn.lee.jason.thread.runnable.volatiles;

/**
 * 共享资源样例
 * Created by jason on 17-2-20.
 */
public abstract class IntGenerator {
    private volatile boolean cancled = false;

    public abstract int next();

    public void cancel() {
        this.cancled = false;
    }

    public boolean isCancled() {
        return cancled;
    }
}
