package fun.luomo.recursion;

/**
 * @author Luomo
 * @date 2020/7/5 10:32
 */
public class Queue8 {
    int max = 8;
    int[] array = new int[max];

    static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("解法个数"+count);
    }

    private void check(int n) {
        if (n == max) {
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i;
            if(judge(n)){
                check(n + 1);
            }

        }
    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        count++;
        System.out.println();
    }

}
