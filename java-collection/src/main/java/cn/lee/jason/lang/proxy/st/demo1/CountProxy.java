package cn.lee.jason.lang.proxy.st.demo1;

/**
 * Created by jason on 17-5-8.
 */
public class CountProxy implements Count {

    private CountImpl countImpl;

    public CountProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        countImpl.queryCount();
    }

    @Override
    public void updateCount() {
        countImpl.updateCount();
    }
}
