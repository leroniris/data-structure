package sort.insertionsort;

import utils.SortUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Leron
 * @version 1.0.0
 * @create 2020/3/28 15:40
 */
public class InsertionSort<T extends Comparable<T>> {


    public void insertSort(T[] arr, Integer n) {
        for (int i = 1; i < n; i++) {
            T e = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (e.compareTo(arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = e;
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InsertionSort<Integer> integerInsertionSort = new InsertionSort<>();
//        Integer[] arrs = new SortUtils().generateRandomArray(100000, 0, 100000);
        Integer[] arrs = new SortUtils().generateOrderRandomArray(100000, 100);
        Method method = integerInsertionSort.getClass().getMethod("insertSort", new Class<?>[]{Comparable[].class, Integer.class});
        new SortUtils().testSort("选择排序", integerInsertionSort, method, arrs, 100000);
        System.out.println(Arrays.toString(arrs));
        System.out.println(new SortUtils<Integer>().isSorted(arrs, 100000));
    }
}
