package cn.lee.jason.thread.concurrent.producer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.lee.jason.thread.concurrent.producer.storage.Storage;
import cn.lee.jason.thread.concurrent.producer.storage.impl.AwaitStorage;
import cn.lee.jason.thread.concurrent.producer.storage.impl.BlockingStorage;
import cn.lee.jason.thread.concurrent.producer.storage.impl.NotifyStorage;
import com.google.common.collect.Lists;

/**
 * <a href="http://lib.csdn.net/base/softwaretest" class='replace_word' title="软件测试知识库" target='_blank' style='color:#df3434; font-weight:bold;'>测试</a>类Test
 * <p>
 * Email:530025983@qq.com
 *
 * @author MONKEY.D.MENG 2011-03-15
 */
public class Test {
    public static void main(String[] args) {
        // 仓库对象  
        List<Storage> storages = Lists.newArrayList();
        storages.add(new NotifyStorage());
        storages.add(new AwaitStorage());
        storages.add(new BlockingStorage());
        for (Storage storage : storages) {
            System.out.println(storage.getClass().getName());
            execute(storage);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=============");
        }
    }

    private static void execute(Storage storage) {
        // 生产者对象
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Producer p3 = new Producer(storage);
        Producer p4 = new Producer(storage);
        Producer p5 = new Producer(storage);
        Producer p6 = new Producer(storage);
        Producer p7 = new Producer(storage);

        // 消费者对象
        Consumer c1 = new Consumer(storage);
        Consumer c2 = new Consumer(storage);
        Consumer c3 = new Consumer(storage);

        // 设置生产者产品生产数量
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(10);
        p7.setNum(80);

        // 设置消费者产品消费数量
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(30);

        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}  