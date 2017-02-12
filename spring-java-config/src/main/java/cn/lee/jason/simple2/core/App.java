package cn.lee.jason.simple2.core;

import cn.lee.jason.simple2.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jason on 17/2/13.
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);
        CustomerBo customer = (CustomerBo) context.getBean("customer");
        customer.printMsg("Hello 1");
        SchedulerBo scheduler = (SchedulerBo) context.getBean("scheduler");
        scheduler.printMsg("Hello 2");

    }
}
