package fun.luomo;

/**
 * @author Luomo
 * create 2020/6/22 17:21
 */
public class SingleLinkedList {
    public static void main(String[] args) {

    }
}

class HeroNode {
    private int no;
    private String name;
    private String nickname;
    private HeroNode next;

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
