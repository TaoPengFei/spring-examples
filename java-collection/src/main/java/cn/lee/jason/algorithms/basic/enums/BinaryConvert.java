package cn.lee.jason.algorithms.basic.enums;

import java.util.Scanner;

import static cn.lee.jason.util.Utils.println;

/**
 * Created by jason on 17/3/2.
 */
public class BinaryConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            println(" input a number using binnary 10 :");
            int number = sc.nextInt();
            println(" input dest binary  :");
            int sys = sc.nextInt();
            String result = convert(number, sys);
            System.out.println("number = " + number + " convert :" + sys + " = " + result);
        }
    }

    public static String convert(int number, int sys) {
        char[] arrs = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String result = "";
        while (number != 0) {
            int dived = number % sys;
            number = number / sys;
            if(number == 0){
                result += '0';
                continue;
            }
            result += arrs[dived -1];
        }
        return result;
    }
}
