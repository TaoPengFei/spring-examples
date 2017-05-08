package cn.lee.jason.lang.proxy.dy.demo1.cglib;

import cn.lee.jason.lang.proxy.dy.demo1.BookFacade;

/**
 * Created by jason on 17-5-8.
 */
public class BookFacadeImpleCgLib implements BookFacade {
    @Override
    public void addBook() {
        System.out.println(" Cglib 增加图书.....");
    }
}
