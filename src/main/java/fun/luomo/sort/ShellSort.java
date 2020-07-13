package fun.luomo.sort;

import java.util.Arrays;

/**
 * @author Luomo
 * @date 2020/7/13 10:14
 */
@SuppressWarnings("all")
public class ShellSort {
    public static void main(String[] args) {
        int size = 80000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long time1 = System.currentTimeMillis();
        shellSort2(arr);
        long time2 = System.currentTimeMillis();
        System.out.println("时间为：" + (time2 - time1));

//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        System.out.println(Arrays.toString(arr));
//        shellSort2(arr);
//        System.out.println("------------------------");
//        System.out.println(Arrays.toString(arr));

    }

    public static void shellSort1(int[] arr) {
        int width = arr.length;
        while ((width /= 2) > 0) {
            for (int i = width; i < arr.length; i++) {
                for (int j = i - width; j >= 0; j -= width) {
                    if (arr[j] > arr[j + width]) {
                        swap(arr, j, j + width);
                    }
                }
            }
        }
    }
    public static void shellSort2(int[] arr) {
        int width = arr.length;
        while ((width /= 2) > 0) {
            for (int i = width; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - width]) {
                    while (j - width >= 0 && temp < arr[j - width]) {
                        arr[j] = arr[j - width];
                        j -= width;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
    public static void shellSort3(int[] arr) {
        int width = arr.length;
        while ((width /= 2) > 0) {
            for (int i = width; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - width]) {
                    while (j - width >= 0 && temp < arr[j - width]) {
                        arr[j] = arr[j - width];
                        j -= width;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
