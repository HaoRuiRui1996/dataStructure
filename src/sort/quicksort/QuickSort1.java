package sort.quicksort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

/**
 * 快速排序
 * 每一轮挑一个基准元素，小于它的放左边大于它的放右边
 * 分治法
 * O(logn)轮，每一轮遍历元素O(n)
 * 最好O(nlogn)  最坏O(n^2) 平均 O(nlogn)  空间O(1) 不稳定
 */
public class QuickSort1 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
//        array = new int[]{6, 9, 3, 25, 29, 14, 30, 37, 38, 48};;
        System.out.println("未排序：" + Arrays.toString(array));
//        sort(array, 0, array.length - 1);
        sortNonRecursive(array);
        System.out.println("快速排序：" + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Arrays排序：" + Arrays.toString(array));
    }

    public static void sort(int[] array, int left, int right) {
        if (array == null || array.length == 0) {
            throw new IllegalStateException("array is empty or null");
        }
        if (left >= right) {
            return;
        }
        int pivot = partitionLeft(array, left, right);
        sort(array, left, pivot - 1);
        sort(array, pivot + 1, right);
    }


    //双边循环法
    public static int partition(int[] array, int left, int right) {
        if (array == null || array.length == 0) {
            throw new IllegalStateException("array is empty or null");
        }
        if (left == right) {
            return left;
        }
        int pivotValue = array[left], begin = left;
        while (left != right) {
            //11, 7, 0, 1, 2, 26, 22, 24, 31, 31
            //继续循环，从左向右停在26，从右向左就停在2
            //从基准数的对面开始,否则left停留的位置肯定大于pivot的值，比完在交换肯定出错
            while (left < right && array[right] > pivotValue) {
                right--;
            }
            //从左边找一个
            while (left < right && array[left] <= pivotValue) {
                left++;
            }
            if (left != right) {
                array[left] = array[left] ^ array[right];
                array[right] = array[left] ^ array[right];
                array[left] = array[left] ^ array[right];
            }

        }
        array[begin] = array[left];
        array[left] = pivotValue;
        return left;
    }

    //单边循环法
    public static int partitionLeft(int[] array, int left, int right) {
        if (array == null || array.length == 0) {
            throw new IllegalStateException("array is empty or null");
        }
        if (left == right) {
            return left;
        }
        int mark = left;    //小于基准的范围
        int pivotValue = array[left];
        while (left <= right) {
            if (array[left] >= pivotValue) {
                left++;
            } else {
                if (left != mark) {
                    array[left] = array[left] ^ array[mark];
                    array[mark] = array[left] ^ array[mark];
                    array[left] = array[left] ^ array[mark];
                }
                mark++;
            }
        }
        array[mark] = pivotValue;
        return mark;
    }

    public static void sortNonRecursive(int[] array) {

        Stack<HashMap<String, Integer>> stack = new Stack<>();
        int left = 0, right = array.length - 1;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("left", left);
        map.put("right", right);
        stack.push(map);
        while (!stack.empty()) {
            map = stack.pop();
            int begin = map.get("left");
            int end = map.get("right");

            if (begin >= end) {
                continue;
            }
            int pivotValue = array[begin];
            int pivot = begin;
            while (begin < end) {
                //从右往左走，最后停的位置一定小于基准元素
                while (begin < end && array[end] >= pivotValue) {
                    end--;
                }
                while (begin < end && array[begin] < pivotValue) {
                    begin++;
                }
                if (begin != end) {
                    array[begin] = array[begin] ^ array[end];
                    array[end] = array[begin] ^ array[end];
                    array[begin] = array[begin] ^ array[end];
                }
            }
            array[pivot] = array[begin];
            array[begin] = pivotValue;

            pivot = begin;
            begin = map.get("left");
            end = map.get("right");
            map = new HashMap<>();
            map.put("left", begin);
            map.put("right", pivot - 1);
            stack.push(map);

            map = new HashMap<>();
            map.put("left", pivot + 1);
            map.put("right", end);
            stack.push(map);
        }
    }

}
