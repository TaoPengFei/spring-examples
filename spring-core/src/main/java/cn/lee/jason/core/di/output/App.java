package cn.lee.jason.core.di.output;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jason on 17/2/14.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        OutputHelper output = (OutputHelper) context.getBean("OutputHelper");
        output.generateOutput();

        OutputHelper output2 = (OutputHelper) context.getBean("OutputHelper2");
        output2.generateOutput();
    }
}
