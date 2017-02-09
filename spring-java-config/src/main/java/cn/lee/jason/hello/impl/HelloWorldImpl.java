package cn.lee.jason.hello.impl;

import cn.lee.jason.hello.HelloWorld;

/**
 * Created by jason on 17/2/9.
 */
public class HelloWorldImpl implements HelloWorld {


    public String printHelloWorld(String msg) {
        System.out.println(" Hello msg:" + msg);
        return null;
    }
}
