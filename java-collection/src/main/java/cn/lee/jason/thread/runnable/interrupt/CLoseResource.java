package cn.lee.jason.thread.runnable.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/3/6.
 */
public class CLoseResource {
    public static void main(String[] args) throws IOException, InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket socket = new ServerSocket(8080);
        InputStream is = new Socket("localhost", 8080).getInputStream();
        exec.execute(new IOBlocked(is));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.SECONDS.sleep(100);
        println(" Shutting down all threads! ");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        println(" CLosing " + socket.getClass().getName());
        is.close();
        TimeUnit.SECONDS.sleep(1);
        println(" Closing " + System.in.getClass().getName());
        System.in.close();

    }


}
