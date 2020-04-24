package sort.selectionsort;

import utils.SortUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 选择排序
 *
 * @author Leron
 * @version 1.0.0
 * @create 2020/3/28 13:56
 */
public class SelectionSort<T extends Comparable<T>> {

    public void selectionSort(T[] arr, Integer n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort<Integer> integerSelectionSort = new SelectionSort<>();
        integerSelectionSort.selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        Student[] students = {
                new Student(5, "leron5"),
                new Student(3, "leron3"),
                new Student(2, "leron2"),
                new Student(4, "leron4"),
                new Student(1, "leron1")
        };

        SelectionSort<Student> studentSelectionSort = new SelectionSort<>();
        studentSelectionSort.selectionSort(students, students.length);
        System.out.println(Arrays.toString(students));

        Integer[] arrs = new SortUtils().generateRandomArray(10000, 0, 10000);
        integerSelectionSort.selectionSort(arrs, 10000);
        System.out.println(Arrays.toString(arrs));


        Integer[] arrs2 = new SortUtils().generateRandomArray(100000, 0, 100000);
        SelectionSort<Integer> integerSelectionSort2 = new SelectionSort<>();
        Method method = integerSelectionSort2.getClass().getMethod("selectionSort", new Class<?>[]{Comparable[].class, Integer.class});
        new SortUtils().testSort("选择排序", integerSelectionSort2, method, arrs2, 100000);
        System.out.println(Arrays.toString(arrs2));

        System.out.println(new SortUtils<Integer>().isSorted(arrs2, 100000));


    }

}
