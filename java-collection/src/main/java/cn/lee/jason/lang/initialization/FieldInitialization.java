package cn.lee.jason.lang.initialization;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/3/23.
 */
public class FieldInitialization {


    public FieldInitialization(int x, int y) {
        println(" 执行构造器！ ");
        this.x = x;
        this.y = y;
    }

    {
        println(" 执行实例代码块1！");
    }

    private int x;
    private int y = initY();

    {
        println(" 执行实例代码块2！");
        x = intX();
    }

    static {
        println(" 执行静态初始化块1 ！ ");
    }

    private static int staticX;
    private static int staticY = intiStaticY();

    static {
        println(" 执行静态初始化块2 ！ ");
        staticX = initStaticX();
    }

    private int intX() {
        println(" 执行实例变量X的初始化 ！");
        return 0;
    }

    private int initY() {
        println(" 执行实例变量Y的初始化 ！ ");
        return 0;
    }

    private static int initStaticX() {
        println(" 执行静态变量X的初始化 ！");
        return 1;
    }

    private static int intiStaticY() {
        println(" 执行静态变量Y的初始化 ！");
        return 1;
    }


    private void show(){
        println(this.toString());
    }

    public String toString() {
        return "FieldInitialization{" +
                "x=" + x +
                ", y=" + y +
                ", staticX=" + staticX +
                ", staticY=" + staticY +
                '}';
    }

    public static void main(String[] args) {
        println(" 执行main方法 ！");
        FieldInitialization f1 = new FieldInitialization(10, 15);
        FieldInitialization f2 = new FieldInitialization(20, 25);
        f1.show();
        f2.show();
    }
}
