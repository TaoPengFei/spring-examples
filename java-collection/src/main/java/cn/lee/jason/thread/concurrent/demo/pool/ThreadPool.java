package cn.lee.jason.thread.concurrent.demo.pool;

/**
 * Created by jason on 17-3-29.
 */
public interface ThreadPool<T extends Runnable> {

    //执行任务
    void execute(T job);

    //关闭线程池
    void shutdown();

    //添加工作线程
    void addWorkers(int num);

    //移除线程
    void removeWorkers(int num);

    //等待的线程数量
    int getJobSize();


}
