package fun.luomo.hashtab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Luomo
 * @date 2020/8/2 16:36
 */

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab<Integer, String> hashTab = new HashTab<>(7);
        hashTab.add(new Emp<>(1, "2"));
        hashTab.add(new Emp<>(8, "5"));
        hashTab.add(new Emp<>(2, "5"));
        hashTab.list();
        hashTab.find(8);
        Hashtable<String, String>[] a = new Hashtable[10];


    }
}

class Emp<K, V> {
    public K key;
    public V value;
    public Emp<K, V> next;

    public Emp(K Key, V value) {
        this.key = Key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + key +
                ", name='" + value + '\'' +
                '}';
    }
}

class EmpLinkedList<K, V> {
    private Emp<K, V> head;

    public void add(Emp<K, V> emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp<K, V> curEmp = head;

        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int i) {
        if (head == null) {
            System.out.println("第" + (i + 1) + "链表为空");
            return;
        }
        Emp<K, V> curEmp = head;
        System.out.print("第" + (i + 1) + "链表信息为： ");
        while (true) {
            System.out.print("=> " + curEmp.toString() + "  ");
            if (curEmp.next == null) {
                System.out.println();
                break;
            }
            curEmp = curEmp.next;
        }

    }

    public Emp<K, V> find(K id) {
        if (head == null) {
            return null;
        }
        Emp<K, V> curEmp = head;
        while (true) {
            if (curEmp.key == id) {
                break;
            }
            if (curEmp.next == null) {
                return null;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

}

class HashTab<K, V> {

    private EmpLinkedList<K, V>[] empLinkedListArray;
    int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList<>();
        }
    }

    public void add(Emp<K, V> emp) {
        int empLinkedListNO = hashFun(emp.key);
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    public void find(K id) {
        int i = hashFun(id);
        Emp<K, V> emp = empLinkedListArray[i].find(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到雇员 %d\n", i + 1, emp.key);
        } else {
            System.out.println("未找到");
        }
    }

    public int hashFun(K id) {
        return id.hashCode() % size;
    }

}