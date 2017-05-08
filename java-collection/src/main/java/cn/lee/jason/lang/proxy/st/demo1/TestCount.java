package cn.lee.jason.lang.proxy.st.demo1;

/**
 * Created by jason on 17-5-8.
 */
public class TestCount {

    public static void main(String[] args) {
        CountImpl count = new CountImpl();
        CountProxy proxy = new CountProxy(count);
        proxy.queryCount();
        proxy.updateCount();
    }
}
