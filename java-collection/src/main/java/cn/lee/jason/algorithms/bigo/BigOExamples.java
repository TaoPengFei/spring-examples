package cn.lee.jason.algorithms.bigo;

/**
 * Created by jason on 17/2/15.
 */
public class BigOExamples {

    public int constant(int n) {
        if (n > 1) {
            return n;
        } else {
            return 0;
        }
    }

    public int linear(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public int quadratic(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += i * j;
            }
        }
        return sum;
    }

    public int cubic(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sum += i * j * k;
                }
            }
        }
        return sum;
    }

    public int logarithmic(Integer[] data, int key) {
        int startIndex = 0;
        int endIndex = data.length - 1;
        while (startIndex < endIndex) {
            int midIndex = (endIndex - startIndex / 2) + startIndex;
            int midValue = data[midIndex];
            if (key > midValue) {
                startIndex = midIndex++;
            } else if (key < midValue) {
                endIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

    public Integer linearLogarithmic(Integer[] data) {
        QuickSort<Integer> sorter = new QuickSort<Integer>();
        sorter.sort(data);
        return data[0];
    }

}
