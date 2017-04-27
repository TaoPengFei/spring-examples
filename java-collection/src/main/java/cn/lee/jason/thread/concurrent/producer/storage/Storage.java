package cn.lee.jason.thread.concurrent.producer.storage;

/**
 * Created by jason on 17-4-27.
 */
public interface Storage {

    /**
     * 生产产品
     *
     * @param num
     */
    public void produce(int num);

    /**
     * 消费产品
     *
     * @param num
     */
    public void consume(int num);
}