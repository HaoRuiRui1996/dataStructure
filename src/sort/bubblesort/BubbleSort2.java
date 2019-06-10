package sort.bubblesort;

import java.util.Arrays;
import java.util.Random;

/**
 * 可能在 中间 某一轮次就已经有序，后续排序不需要进行了
 */
public class BubbleSort2 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
        System.out.println("未排序：" + Arrays.toString(array));
        new BubbleSort2().sort(array);
        System.out.println("bubblo排序：" + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Arrays排序：" + Arrays.toString(array));

    }

    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = array.length - 1; i >= 0; --i) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    //因为有元素交换，所以不是有序的
                    isSorted = false;
                    //swap
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
