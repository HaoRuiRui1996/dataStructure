package heap;

import java.util.Arrays;
import java.util.Random;

public class BinaryHeap {
    private int[] array = new int[10];

    public void buildHeap() {
        Random random = new Random();
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(50);
//        }
        array = new int[]{6, 9, 38, 48, 29, 9, 30, 5, 38, 35};
        System.out.println(Arrays.toString(array));
        adjustHeap();
        System.out.println(Arrays.toString(array));
    }

    public void adjustHeap() {
        for (int parent = array.length / 2 - 1; parent >= 0; --parent) {
            //从完全二叉树的第一个非叶子节点开始
            int move, temp = array[parent];
            //先选取子节点中大的那一个
            if (parent * 2 + 2 <= array.length - 1) {
                if (array[parent * 2 + 1] >= array[parent * 2 + 2]) {
                    move = parent * 2 + 1;
                } else {
                    move = parent * 2 + 2;
                }
            } else {
                move = parent * 2 + 1;
            }

            //比较父节点和子节点大小
            if (array[parent] < array[move]) {
                //如果小于子节点较大的那个，进行交换
                array[parent] = array[move];
                array[move] = temp;
            }
        }
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.buildHeap();
    }
}
