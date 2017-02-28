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
        for (int i = 0; i < 100; i++) {
            System.out.println(" length = " + i);
            cal(i);

        }

    }

    public static int cal(int len) {
        int max = pow10(len);
        for (int i = 79360; i < 79370; i++) {
            int last = i % 10;
            int first = i / pow10(len - 1);
            if (last > 0) {
                int r1 = 0;
                int r2 = i * first;
                for (int j = 0; j <= len; j++) {
                    r1 += last * pow10(j);
                }
                if (r1 == r2) {
                    System.out.println(i + "----" + last + "----" + r1);

                }
            }
        }
        return max;
    }

    private static int pow10(int len) {
        int result = 1;
        for (int i = 0; i < len; i++) {
            result = result * 10;
        }
        return result;
    }
}
