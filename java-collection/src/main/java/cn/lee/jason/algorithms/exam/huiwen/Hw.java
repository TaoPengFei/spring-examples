package cn.lee.jason.algorithms.exam.huiwen;

import java.util.Scanner;

/**
 * 回文数
 * Created by jason on 17/6/6.
 */
public class Hw {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long in = 0;
        while (true) {
            System.out.println("请输入一个数字：");
            in = sc.nextLong();
            cal(in);
        }

    }

    public static void cal(long in) {
        String[] arrs = String.valueOf(in).split("");
        boolean isPass = true;
        for (int start = 0, end = arrs.length - 1 - start; start < end; start++, end = arrs.length - 1 - start) {
            if (!arrs[start].equalsIgnoreCase(arrs[end])) {
                System.out.println(start + " || " + end);
                isPass = false;
                break;
            }
        }
        if (isPass) {
            System.out.println(in + " 是回文数！");
        } else {
            System.out.println(in + " 不是回文数！");
        }
    }
}
