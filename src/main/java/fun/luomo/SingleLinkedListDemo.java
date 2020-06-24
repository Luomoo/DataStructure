package fun.luomo;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Luomo
 * 单链表
 * create 2020/6/22 17:21
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkList sl = new SingleLinkList();
        SingleLinkList sl2 = new SingleLinkList();
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "宋江", "及时雨");
        HeroNode node41 = new HeroNode(4, "宋江", "及时雨");
        HeroNode node5 = new HeroNode(5, "卢俊义", "玉麒麟");
        HeroNode node6 = new HeroNode(6, "吴用", "智多星");
       /* sl.add(node1);
        sl.add(node3);
        sl.add(node2);*/
        sl.addByOrder(node1);
        sl.addByOrder(node2);
        sl.addByOrder(node4);

        sl2.addByOrder(node3);
        sl2.addByOrder(node41);
        sl2.addByOrder(node5);
        sl2.addByOrder(node6);

//        sl.showLinkList();
//        System.out.println("----------------");
//        sl.update(new HeroNode(3, "123", "123"));
//        sl.showLinkList();
//        System.out.println("----------------");
//        sl.delete(3);
//        sl.showLinkList();
//        System.out.println("sl.size() = " + getLength(sl.getHead()));
//        HeroNode lastNode = findLastNode(sl.getHead(), 2);
//        System.out.println(lastNode != null ? lastNode.toString() : "错误");
//        sl.showLinkList();
//        System.out.println("----------------------");
//        reverse1(sl.getHead());
//        sl.showLinkList();
//        System.out.println("----------------------");
//        reversePrint(sl.getHead());

        HeroNode merge = merge(sl.getHead().next, sl2.getHead().next);

        while (merge != null) {
            System.out.println(merge);
            merge = merge.next;
        }
    }

    /**
     * 节点个数
     */
    public static int getLength(HeroNode node) {
        int len = 0;
        HeroNode temp = node;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    /**
     * 倒数第K个节点个数
     */
    public static HeroNode findLastNode(HeroNode node, int index) {
        int length = getLength(node);
        if (index <= 0 || index > length) {
            return null;
        }
        length = length - index + 1;
        for (int i = 0; i < length; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 头插翻转
     */
    public static void reverse1(HeroNode node) {
        HeroNode temp = node.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");

        while (temp != null) {
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        node.next = reverseHead.next;
    }

    /**
     * 原地翻转
     */
    public static void reverse2(HeroNode node) {
        HeroNode temp = node.next;
        HeroNode p = null;
        HeroNode q = null;

        p = temp.next;
        q = p.next;
    }

    /**
     * 逆序打印
     */
    public static void reversePrint(HeroNode node) {
        HeroNode temp = node.next;
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }

    /**
     * 合并两个链表
     */
    public static HeroNode merge(HeroNode a, HeroNode b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        HeroNode head = null;
        if (a.no < b.no) {
            head = a;
            head.next = merge(a.next, b);
        } else {
            head = b;
            head.next = merge(a, b.next);

        }
        return head;
    }
}

class SingleLinkList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 直接添加
     */
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 有序添加
     */
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (node.no < temp.next.no) {
                break;
            }
            if (node.no == temp.next.no) {
                System.out.println(node.no + " 已存在");
                return;
            }
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
    }

    /**
     * 根据编号修改
     */
    public void update(HeroNode node) {
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                return;
            }
            if (node.no == temp.next.no) {
                break;
            }
            temp = temp.next;
        }
        node.next = temp.next.next;
        temp.next = node;
    }

    /**
     * 删除
     */
    public void delete(int no) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                return;
            }
            if (no == temp.next.no) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }


    public void showLinkList() {
        if (head.next == null) {
            System.out.println("空链表");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
