package cn.lee.jason.lang.proxy.st.demo1;

/**
 * Created by jason on 17-5-8.
 */
public class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println(" 查看数据..... ");
    }

    @Override
    public void updateCount() {
        System.out.println(" 更新数据..... ");
    }
}
