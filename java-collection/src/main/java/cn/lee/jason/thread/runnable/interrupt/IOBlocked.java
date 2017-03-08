package cn.lee.jason.thread.runnable.interrupt;

import java.io.InputStream;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/3/5.
 */
public class IOBlocked implements Runnable {

    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }



    public void run() {
        try {
            println(" Waiting for read(); ");
            in.read();
        } catch (Exception e) {
            if (Thread.currentThread().isInterrupted()) {
                println(" Interrupted from blocked I/O ");
            }else{
                throw new RuntimeException(e);
            }

        }
        println(" Exiting IOBlocked.run ");
    }
}
