package cn.lee.jason.algorithms.bigo;

/**
 * Created by jason on 17/2/15.
 */
public class QuickSort<T extends Comparable<T>> {

    public void sort(T[] array) {
        array = quicksort(array, 0, array.length - 1);
    }

    private T[] quicksort(T[] array, int lo, int hi) {
        if (hi > lo) {
            int partitionPivotIndex = (int) (Math.random() * (hi - lo) + lo);
            int newPivotIndex = partition(array, lo, hi, partitionPivotIndex);
            quicksort(array, lo, newPivotIndex - 1);
            quicksort(array, newPivotIndex + 1, hi);
        }
        return (T[]) array;
    }

    private int partition(T[] array, int lo, int hi, int pivotIndex) {
        T pivotValue = array[pivotIndex];
        swap(array, pivotIndex, hi); // send to the back
        int index = lo;
        for (int i = lo; i < hi; i++) {
            if ((array[i]).compareTo(pivotValue) <= 0) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, hi, index);
        return index;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
