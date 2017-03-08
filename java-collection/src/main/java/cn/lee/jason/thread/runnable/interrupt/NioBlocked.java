package cn.lee.jason.thread.runnable.interrupt;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;

import static cn.lee.jason.util.Utils.println;


/**
 * Created by jason on 17/3/6.
 */
public class NioBlocked implements Runnable {
    private final SocketChannel sc;

    public NioBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    public void run() {
        try {
            println(" Watting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            println(" ClosedByInterruptException ");
        } catch (AsynchronousCloseException e) {
            println(" AsynchronousCloseException ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        println(" Exiting NioBlocked .run ()" + this);
    }
}
