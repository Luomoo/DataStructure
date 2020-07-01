package fun.luomo;

/**
 * @author Luomo
 * create 2020/7/1 9:13
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkList dl = new DoubleLinkList();
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "宋江", "及时雨");

        dl.addByOrder(node1);
        dl.addByOrder(node2);
        dl.addByOrder(node3);
        dl.addByOrder(node4);
        dl.showLinkList();
        dl.update(new Node(4, "111", "aaa"));
        System.out.println("-------------------------");
        dl.showLinkList();
        dl.delete(4);
        System.out.println("-------------------------");
        dl.showLinkList();
/*
        Node head = dl.getHead();
        System.out.println(head = head.next);
        System.out.println(head = head.next);
        System.out.println(head = head.next);
        System.out.println(head = head.next);
        System.out.println("-------------");
        System.out.println(head);
        System.out.println(head = head.pre);
        System.out.println(head = head.pre);
        System.out.println(head = head.pre);
*/

    }
}

class DoubleLinkList {
    private Node head = new Node(0, "", "");

    public Node getHead() {
        return head;
    }

    /**
     * 直接添加
     */
    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        node.pre = temp;
        temp.next = node;
    }

    /**
     * 有序添加
     */
    public void addByOrder(Node node) {
        Node temp = head;
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
        if (temp.next != null) {
            node.pre = temp;
            node.next = temp.next;
            temp.next = node;
            node.next.pre = node;
        } else {
            node.pre = temp;
            temp.next = node;
        }
    }

    /**
     * 根据编号修改
     */
    public void update(Node node) {
        Node temp = head;

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
        node.pre = temp;
        try {
            node.next.pre = node;
        } catch (Exception e) {
        }
    }

    /**
     * 删除
     */
    public void delete(int no) {
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                return;
            }
            if (temp.no == no) {
                break;
            }
            temp = temp.next;
        }
        temp.pre.next = temp.next;
        if (temp.next != null) {
            temp.next.pre = temp.pre;
        }
    }

    public void showLinkList() {
        if (head.next == null) {
            System.out.println("空链表");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}

class Node {
    public int no;
    public String name;
    public String nickname;
    public Node next;
    public Node pre;

    public Node(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
