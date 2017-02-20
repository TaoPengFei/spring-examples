package cn.lee.jason.thread.runnable.basic.exam01;

/**
 * Created by jason on 17/2/17.
 */
public class Main {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            Exam ex = new Exam();
            ex.run();
        }


        for(int i=0;i<100;i++){
            Thread thread = new Thread(new Exam());
            thread.start();
        }
    }
}
