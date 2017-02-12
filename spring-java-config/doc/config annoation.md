# Java Config 注解

spring  java config作为同xml配置形式的另一种表达形式，使用的场景越来越多，在新版本的spring boot中
大量使用，今天我们来看下用到的主要注解有哪些。

1. Configuration: 继承Component注解，默认解析为spring的顶级BeanFactory。作用于类上面，等价于applicationContext.xml文件
2. Bean ：作用在方法上面，方法的返回值为类实例。等同于<bean/>元素，但是没有scope等元素，猜测可能是此处由代码控制scope。
3. ComponentScan：类级注解，用于配置扫描的包路径。等同于<context:component-scan/>元素。主要使用basePackages元素。
4. Import：类注解，作用等同于xml的<import/>元素，将分别定义的@Configuration的配置类引入到同一容器中。

接下来看一个实例

```java
    //注释声明容器
    @Configuration
    public class HelloWorldConfig {
        //配置一个id=helloBean的bean，并返回对应的实例
        @Bean(name = "helloBean")
        public HelloWorld helloWorld() {
            return new HelloWorldImpl();
        }
    }


     //注释声明容器
     //import样例
    @Configuration
    @Import({HelloWorldConfig.class})
    public class ImportHelloWorldConfig {
        
    }
```
这个写法等同于
```xml
    <bean id ="helloBean" class="cn.lee.jason.hello.impl.HelloWorldImpl"></bean>
```

配置结束了，使用方面基本没有大的差异。
JavaConfig方式,使用AnnotationConfigApplicationContext类加载JavaConfig配置信息
```java
    class TestHelloConfig{
        public static void main(String[] args) {
          ApplicationContext ctx = 
          new AnnotationConfigApplicationContext(HelloWorldConfig.class);
          
          HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
       
          helloWorld.setMessage("Hello World!");
          helloWorld.getMessage();
          
       } 
    }
```
测试import的的样例
```java
     class TestImportHelloConfig{
        public static void main(String[] args) {
          ApplicationContext ctx = 
          new AnnotationConfigApplicationContext(ImportHelloWorldConfig.class);
          
          HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
       
          helloWorld.setMessage("Hello World!");
          helloWorld.getMessage();
          
       } 
    }
```
两种方法输出的结果完全一致。

如果需要注册加载多个BeanFactory的时候
```java
class TestHelloConfig{
        public static void main(String[] args) {
          AnnotationConfigApplicationContext ctx = 
             new AnnotationConfigApplicationContext();
          
             ctx.register(AppConfig.class, OtherConfig.class);
             ctx.register(AdditionalConfig.class);
             ctx.refresh();
          
             MyService myService = ctx.getBean(MyService.class);
             myService.doStuff();
       } 
    }
```

在某种程度上面，java config简化了xml配置，但也导致修改场景丢失了一定的灵活性。面对快速搭建测试环境时比较方面快捷。