package fun.luomo.sort;

import java.util.Arrays;

/**
 * @author Luomo
 * @date 2020/7/9 20:24
 */
public class InsertSort {

    public static void main(String[] args) {
        int size = 80000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long time1 = System.currentTimeMillis();
        insertSort(arr);
        long time2 = System.currentTimeMillis();
        System.out.println("时间为：" + (time2 - time1));

       /* int[] arr = new int[]{5, 3, 7, 8, 1, 9, 2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));*/
    }

    public static void insertSort(int[] arr) {
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
