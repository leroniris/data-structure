package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * 排序测试工具类
 *
 * @author Leron
 * @version 1.0.0
 * @create 2020/3/28 14:17
 */
public class SortUtils<T extends Comparable<T>> {
    // 生成随机无序数组
    public Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL < rangeR;
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    // 生成随机近乎有序数组
    public Integer[] generateOrderRandomArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            int posX = random.nextInt(n) % n;
            int posY = random.nextInt(n) % n;
            swap(arr, posX, posY);
        }
        return arr;
    }

    private void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试算法性能
    public void testSort(String sortName, Object object, Method method, T[] arr, Integer n) throws InvocationTargetException, IllegalAccessException {
        Long start = System.currentTimeMillis();

        method.invoke(object, new Object[]{arr, n});

        Long end = System.currentTimeMillis();
        System.out.println(sortName + "花费时间：" + (end - start) + "毫秒");
    }

    // 判断一个数组是否排序成功
    public boolean isSorted(T[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

}
