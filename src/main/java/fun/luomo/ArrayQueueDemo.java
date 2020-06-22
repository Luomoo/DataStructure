package fun.luomo;

/**
 * @author Luomo
 * create 2020/6/22 10:20
 */
public class ArrayQueueDemo {


    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(3);
        aq.addQueue(1);
        aq.addQueue(2);
        aq.addQueue(3);
        aq.addQueue(4);
        aq.printQueue();
        System.out.println("aq.getQueue() = " + aq.getQueue());
        aq.printQueue();
    }

}

class ArrayQueue {
    private int maxSize;
    private int front; //头
    private int rear; //尾
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return front == maxSize - 1;
    }

    public void addQueue(int data) {
        if (isFull()) {
            throw new RuntimeException("已满");
        }
        arr[++front] = data;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }

        return arr[++rear];

    }

    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }

        return arr[rear + 1];
    }

    public void printQueue() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        for (int i = rear + 1; i <= front; i++) {
            System.out.println(arr[i]);
        }
    }
}
