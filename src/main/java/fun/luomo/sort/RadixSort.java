package fun.luomo.sort;

import java.util.Arrays;

/**
 * @author Luomo
 * @date 2020/7/20 21:47
 */
public class RadixSort {
    public static void main(String[] args) {
        int size = 80000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long time1 = System.currentTimeMillis();
        radixSort(arr);
        long time2 = System.currentTimeMillis();
        System.out.println("时间为：" + (time2 - time1));

//        int[] arr = {83, 3, 542, 748, 14, 214};
//        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCount = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int value : arr) {
                int digitOfElement = value / n % 10;
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = value;
                bucketElementCount[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCount[k] = 0;
            }
        }
    }
}
