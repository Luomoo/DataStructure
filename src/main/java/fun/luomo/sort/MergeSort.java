package fun.luomo.sort;

import java.util.Arrays;

/**
 * @author Luomo
 * @date 2020/7/20 20:36
 */
public class MergeSort {
    public static void main(String[] args) {
        int size = 80000;
        int[] arr = new int[size];
        int[] temp = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long time1 = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1,temp);
        long time2 = System.currentTimeMillis();
        System.out.println("时间为：" + (time2 - time1));
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] temp = new int[arr.length];
//        System.out.println(Arrays.toString(arr));
//        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];

        }

    }
}
