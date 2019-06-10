package sort.bubblesort;

import java.util.Arrays;
import java.util.Random;

/**
 * 未排序之前有部分元素已经有序了
 * 原来有序元素数量，每次步长为1
 */
public class BubbleSort3 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
        array = new int[]{6, 9, 3, 25, 29, 14, 30, 37, 38, 48};
        ;
        System.out.println("未排序：" + Arrays.toString(array));
        new BubbleSort3().sort(array);
        System.out.println("bubblo排序：" + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Arrays排序：" + Arrays.toString(array));

    }

    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int sortBorder = array.length - 1;
        for (int i = array.length - 1; i >= 0; --i) {
            boolean isSorted = true;
            int end = sortBorder;
            for (int j = 0; j < end; j++) {
                if (array[j] > array[j + 1]) {
                    //因为有元素交换，所以不是有序的
                    isSorted = false;
                    //无序元素的边界
                    sortBorder = j;
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
