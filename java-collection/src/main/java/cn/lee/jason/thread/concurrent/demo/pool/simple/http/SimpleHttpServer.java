package cn.lee.jason.thread.concurrent.demo.pool.simple.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import cn.lee.jason.thread.concurrent.demo.pool.DefaultThreadPool;
import cn.lee.jason.thread.concurrent.demo.pool.ThreadPool;

/**
 * Created by jason on 17-3-29.
 */
public class SimpleHttpServer {
    static ThreadPool<HttpRequestHandler> pool = new DefaultThreadPool<HttpRequestHandler>(1);
    static String basePath;
    static ServerSocket serverSocket;
    static int port = 8080;

    public static void setPort(int port) {
        if (port > 0) {
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimpleHttpServer.basePath = basePath;
        }
    }

    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            pool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }


    static class HttpRequestHandler implements Runnable {
        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream is = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                String filePath = basePath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    is = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = is.read()) != -1) {
                        baos.write(i);
                    }
                    byte[] byts = baos.toByteArray();
                    out.println("Http/1.1 200 OK");
                    out.println("Server:Molly");
                    out.println("Content-Type:image/jpeg");
                    out.println("Content-length:" + byts.length);
                    out.println("");
                    socket.getOutputStream().write(byts, 0, byts.length);
                } else {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("Http/1.1 200 OK");
                    out.println("Server:Molly");
                    out.println("Content-Type:text/html;charset=UTF-8");
                    out.println("");
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();
            } catch (IOException e) {
                out.println("Http/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(br, reader, out, socket);
            }
        }
    }

    private static void close(Closeable... closeables) {
        if (closeables != null) {
            int i = 0;
            for (Closeable closeable : closeables) {
                try {
                    closeable.close();
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
            }
        }
    }
}
