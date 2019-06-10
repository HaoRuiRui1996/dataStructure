package sort.bubblesort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序，时间复杂度O(n2)
 * 稳定的排序算法，值相等的元素不会打乱原有的顺序
 * 每一轮都要遍历所有元素，遍历n - 1轮
 */
public class BubbleSort1 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
        System.out.println("未排序：" + Arrays.toString(array));
        new BubbleSort1().sort(array);
        System.out.println("bubblo排序：" + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Arrays排序：" + Arrays.toString(array));

    }

    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = array.length - 1; i >= 0; --i) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    //swap
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
        }
    }
}
