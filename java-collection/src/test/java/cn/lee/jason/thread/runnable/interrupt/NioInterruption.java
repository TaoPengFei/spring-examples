package cn.lee.jason.thread.runnable.interrupt;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by jason on 17/3/6.
 */
public class NioInterruption {
    @Test
    public void test() throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket sc = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost",8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Future<?> future = exec.submit(new NioBlocked(sc1));
        exec.submit(new NioBlocked(sc2));
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        future.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        sc2.close();
    }
}
