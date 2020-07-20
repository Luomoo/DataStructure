package fun.luomo.sort;

import java.util.Arrays;

/**
 * @author Luomo
 * @date 2020/7/20 9:56
 */
public class QuickSort {

    public static void main(String[] args) {
        int size = 80000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long time1 = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1);
        long time2 = System.currentTimeMillis();
        System.out.println("时间为：" + (time2 - time1));


//        int[] arr = {-9, 78, 0, 23, -567, 70};
//        System.out.println(Arrays.toString(arr));
//        sort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[(left + right) / 2];
//        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                swap(array, i, j);
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
