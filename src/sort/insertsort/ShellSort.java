package sort.insertsort;

import java.util.Arrays;
import java.util.Random;

/**
 * 希尔排序
 * 将待排序元素分成若干个子序列，缩小增量，再对全体进行一次插入排序
 * 平均 O(n^（1.3—2）  空间O(1) 不稳定
 */
public class ShellSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
//        array = new int[]{6, 9, 3, 25, 29, 14, 30, 37, 38, 48};;
        System.out.println("未排序：" + Arrays.toString(array));
        sort1(array);
        System.out.println("shell排序：" + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Arrays排序：" + Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int group = array.length / 3; group > 0; group /= 3) {
            for (int i = 0; i < group; i++) {
                for (int j = i + group; j < array.length; j += group) {
                    int k = j;
                    while (k - group >= 0 && array[k] < array[k - group]) {
                        array[k] = array[k] ^ array[k - group];
                        array[k - group] = array[k] ^ array[k - group];
                        array[k] = array[k] ^ array[k - group];
                        k -= group;
                    }
                }
            }
        }
    }

    public static void sort1(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int group = array.length / 3; group > 0; group /= 3) {
            for (int i = group; i < array.length; i++) {
                int k = i;
                while (k - group >= 0 && array[k] < array[k - group]) {
                    array[k] = array[k] ^ array[k - group];
                    array[k - group] = array[k] ^ array[k - group];
                    array[k] = array[k] ^ array[k - group];
                    k -= group;
                }
            }
        }
    }
}
