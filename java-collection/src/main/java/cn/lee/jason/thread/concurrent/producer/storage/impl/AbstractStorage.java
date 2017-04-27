package cn.lee.jason.thread.concurrent.producer.storage.impl;

import java.util.LinkedList;

import cn.lee.jason.thread.concurrent.producer.storage.Storage;

/**
 * Created by jason on 17-4-27.
 */
public abstract class AbstractStorage implements Storage {
    // 仓库最大存储量
    protected final int MAX_SIZE = 100;

    // 仓库存储的载体
    protected LinkedList<Object> list = new LinkedList<Object>();

    // get/set方法
    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
