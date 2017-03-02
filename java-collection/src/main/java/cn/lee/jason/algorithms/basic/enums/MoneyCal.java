package cn.lee.jason.algorithms.basic.enums;

import java.text.DecimalFormat;

/**
 * Created by jason on 17/3/2.
 */
public class MoneyCal {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("#.##");
        double count = 0;
        for (int i = 48; i > 0  ; i--) {
            count = (count + 1000) / (1 + 0.0171 / 12);
            System.out.println("第" + i + "月剩余:" + format.format(count));
        }
    }
}
