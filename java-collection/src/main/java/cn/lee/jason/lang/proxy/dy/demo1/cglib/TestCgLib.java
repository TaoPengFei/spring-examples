package cn.lee.jason.lang.proxy.dy.demo1.cglib;

/**
 * Created by jason on 17-5-8.
 */
public class TestCgLib {
    public static void main(String[] args) {
        BookFacadeProxyCgLib cglib = new BookFacadeProxyCgLib();
        BookFacadeImpleCgLib bookCglib = (BookFacadeImpleCgLib) cglib.getInstance(new BookFacadeImpleCgLib());
        bookCglib.addBook();
    }
}
