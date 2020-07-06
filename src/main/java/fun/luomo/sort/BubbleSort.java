package fun.luomo.sort;

import java.util.Arrays;

/**
 * @author Luomo
 * @date 2020/7/6 20:46
 */
public class BubbleSort {

    public static void main(String[] args) {
        int size = 80000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        long time1 = System.currentTimeMillis();
        sort(arr);
        long time2 = System.currentTimeMillis();
        System.out.println("时间为：" + (time2 - time1));
      /*  int[] arr = new int[]{5, 3, 7, 8, 1, 9, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));*/

    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean OK = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    OK = false;
                    swap(arr, j, j + 1);
                }
            }
            if (OK) {
                return;
            }

        }

    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
