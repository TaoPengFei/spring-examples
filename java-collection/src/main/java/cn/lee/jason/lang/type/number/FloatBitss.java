package cn.lee.jason.lang.type.number;

/**
 * Created by jason on 17/4/18.
 */
public class FloatBitss {

    public static void main(String[] args) {
        float f = 99.5f;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)).length());
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(f)));
    }
}
