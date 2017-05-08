package cn.lee.jason.lang.proxy.dy.demo1.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Created by jason on 17-5-8.
 */
public class BookFacadeProxyCgLib implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(" Cglib 代理事务开始.....");
        methodProxy.invokeSuper(o, objects);
        System.out.println(" CgLib 代理事务结束......");
        return null;
    }
}
