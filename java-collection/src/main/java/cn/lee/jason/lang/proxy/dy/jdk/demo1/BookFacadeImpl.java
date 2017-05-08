package cn.lee.jason.lang.proxy.dy.jdk.demo1;

/**
 * Created by jason on 17-5-8.
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println(" 增加图书的方法.....");
    }
}
