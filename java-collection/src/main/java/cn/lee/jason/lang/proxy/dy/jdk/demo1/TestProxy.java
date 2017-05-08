package cn.lee.jason.lang.proxy.dy.jdk.demo1;

/**
 * Created by jason on 17-5-8.
 */
public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade facade = (BookFacade) proxy.bind(new BookFacadeImpl());
        facade.addBook();
    }
}
