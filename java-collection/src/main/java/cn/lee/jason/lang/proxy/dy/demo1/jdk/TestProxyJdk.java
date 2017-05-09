package cn.lee.jason.lang.proxy.dy.demo1.jdk;

import cn.lee.jason.lang.proxy.dy.demo1.BookFacade;

/**
 * Created by jason on 17-5-8.
 */
public class TestProxyJdk {

    public static void main(String[] args) {
        BookFacadeProxyJdk proxy = new BookFacadeProxyJdk();
        BookFacade facade = (BookFacade) proxy.bind(new BookFacadeJdkImpl());
        facade.addBook();
    }
}
