package fun.luomo;

/**
 * @author Luomo
 * 单链表
 * create 2020/6/22 17:21
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkList sl = new SingleLinkList();
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "吴用", "智多星");
        HeroNode node5 = new HeroNode(5, "吴用", "智多星");
       /* sl.add(node1);
        sl.add(node3);
        sl.add(node2);*/
        sl.addByOrder(node1);
        sl.addByOrder(node2);
        sl.addByOrder(node3);
        sl.addByOrder(node4);
        sl.addByOrder(node4);
        sl.addByOrder(node5);
        sl.showLinkList();
        System.out.println("----------------");
        sl.update(new HeroNode(3, "123", "123"));
        sl.showLinkList();
        System.out.println("----------------");
        sl.delete(6);
        sl.showLinkList();
        
    }
}

class SingleLinkList {
    private HeroNode head = new HeroNode(0, "", "");

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
