package fun.luomo.queue;

/**
 * @author Luomo
 * create 2020/6/22 11:20
 */
public class CircleQueueDemo {


    public static void main(String[] args) {
        CircleQueue cq = new CircleQueue(4);
        cq.addQueue(1);
        cq.addQueue(2);
        cq.addQueue(3);
        cq.printQueue();
        System.out.println("-------------------");
        System.out.println("cq.getQueue() = " + cq.getQueue());
        System.out.println("cq.getQueue() = " + cq.getQueue());
        System.out.println("-------------------");
        cq.printQueue();
        System.out.println("-------------------");
        cq.addQueue(4);
        cq.addQueue(5);
        cq.printQueue();
        System.out.println("-------------------");
    }
}

class CircleQueue {
    private int maxSize;
    private int front; //头
    private int rear; //尾
    private int[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addQueue(int data) {
        if (isFull()) {
            throw new RuntimeException("已满");
        }
        arr[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        int value = arr[front];
        arr[front] = 0;
        front = (front + 1) % maxSize;
        return value;
    }

    public void printQueue() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        for (int i = front ; i <= front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }


}
