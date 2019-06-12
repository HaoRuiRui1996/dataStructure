package sort.insertsort;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序
 * 将一个记录插入到已排序好的有序表中，从而得到一个新的有序表
 * 最好O(n)  最坏O(n^2) 平均 O(n^2)  空间O(1) 稳定
 */
public class InsertSort1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
//        array = new int[]{6, 9, 3, 25, 29, 14, 30, 37, 38, 48};;
        System.out.println("未排序：" + Arrays.toString(array));
        sort2(array);
        System.out.println("插入排序：" + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Arrays排序：" + Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int k = i - 1;
            while (k > 0 && array[k] > insertValue) {
                array[k + 1] = array[k];
                k--;
            }
            array[k + 1] = insertValue;
        }
    }

    public static void sort2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                //交换位置
                array[j] = array[j] ^ array[j + 1];
                array[j + 1] = array[j] ^ array[j + 1];
                array[j] = array[j] ^ array[j + 1];
            }
        }
    }
}
