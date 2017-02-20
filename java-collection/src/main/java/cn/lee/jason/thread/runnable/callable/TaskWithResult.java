package cn.lee.jason.thread.runnable.callable;

import java.util.concurrent.Callable;

/**
 * Created by jason on 17/2/18.
 */
public class TaskWithResult implements Callable<String> {

    private int id;


    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result of TaskWithResult :" + id;
    }
}
