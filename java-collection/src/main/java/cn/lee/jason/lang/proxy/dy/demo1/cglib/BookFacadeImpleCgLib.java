package cn.lee.jason.lang.proxy.dy.demo1.cglib;

import cn.lee.jason.lang.proxy.dy.demo1.BookFacade;

/**
 * 基于CGlib实现的方法，其实和代理方式无关
 * Created by jason on 17-5-8.
 */
public class BookFacadeImpleCgLib implements BookFacade {
    @Override
    public void addBook() {
        System.out.println(" Cglib 增加图书.....");
    }
}
