package fun.luomo.linkedlist;

/**
 * @author Luomo
 * create 2020/7/1 10:51
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList csl = new CircleSingleLinkedList();
        csl.add(5);
        csl.showBoy();
        int size = csl.size();
        System.out.println(size);
        csl.countBoy(1, 2, size);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public void add(int nums) {
        if (nums < 1) {
            System.out.println("nums不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("空");
            return;
        }

        Boy curBoy = first;

        while (true) {
            System.out.println("编号:" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("有误");
            return;
        }

        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) {
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出圈编号：" + first.getNo());

            first = first.getNext();
            helper.setNext(first);

        }
        System.out.println("最后的编号：" + first.getNo());

    }

    public int size() {
        int size = 1;
        Boy curBoy = first;
        while (true) {
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
            size++;
        }
        return size;
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
