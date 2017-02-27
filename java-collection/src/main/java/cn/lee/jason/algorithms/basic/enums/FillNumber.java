package cn.lee.jason.algorithms.basic.enums;

/**
 * Created by jason on 17/2/27.
 */
public class FillNumber {

    public static void main(String[] args) {
        int a, b, c, d, e;
        int result, tmp;
        for (a = 0; a <= 9; a++) {
            for (b = 0; b <= 9; b++) {
                for (c = 0; c <= 9; c++) {
                    for (d = 0; d <= 9; d++) {
                        for (e = 1; e <= 9; e++) {
                            tmp = e * 10 * 10 * 10 * 10 * 10 + e * 10 * 10 * 10 * 10 + e * 10 * 10 * 10 + e * 10 * 10 + e * 10 + e;
                            result = (a * 10 * 10 * 10 * 10 + b * 10 * 10 * 10 + c * 10 * 10 + d * 10 + e) * a;
                            if (tmp == result) {
                                System.out.println(a + " " + b + " " + c + " " + d + " " + e);
                            }
                        }
                    }
                }
            }
        }

    }
}
