package cn.lee.jason.thread.concurrent.demo.pool.simple.http;

import java.io.IOException;

import org.junit.Test;

/**
 * Created by jason on 17-3-29.
 */
public class TestSimpleHttpServer {
    @Test
    public void testStart() throws IOException {
        SimpleHttpServer.setBasePath("/home/jason/workbench/www/html/demo/extracting");
        SimpleHttpServer.start();
    }
}
