package fun.luomo.tree;

/**
 * @author Luomo
 * @date 2020/8/3 20:31
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        //创建需要的结点
        Node<Integer> root = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        //测试
//		System.out.println("前序遍历"); // 1,2,3,5,4
//		binaryTree.preOrder();

        //测试
//		System.out.println("中序遍历");
//		binaryTree.infixOrder(); // 2,1,5,3,4
//
//		System.out.println("后序遍历");
//		binaryTree.postOrder(); // 2,5,4,3,1

        //前序遍历
        //前序遍历的次数 ：4
//		System.out.println("前序遍历方式~~~");
//		HeroNode resNode = binaryTree.preOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //中序遍历查找
        //中序遍历3次
//		System.out.println("中序遍历方式~~~");
//		HeroNode resNode = binaryTree.infixOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //后序遍历查找
        //后序遍历查找的次数  2次
//		System.out.println("后序遍历方式~~~");
//		HeroNode resNode = binaryTree.postOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //测试一把删除结点

        System.out.println("删除前,前序遍历");
        binaryTree.preOrder(); //  1,2,3,5,4
        binaryTree.delNode(5);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder(); // 1,2,3,4


    }

}

//定义BinaryTree 二叉树
class BinaryTree<K> {
    private Node<K> root;

    public void setRoot(Node<K> root) {
        this.root = root;
    }

    //删除结点
    public void delNode(K ele) {
        if (root != null) {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if (root.getEle() == ele) {
                root = null;
            } else {
                //递归删除
                root.delNode(ele);
            }
        } else {
            System.out.println("空树，不能删除~");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历
    public Node<K> preOrderSearch(K ele) {
        if (root != null) {
            return root.preOrderSearch(ele);
        } else {
            return null;
        }
    }

    //中序遍历
    public Node<K> infixOrderSearch(K ele) {
        if (root != null) {
            return root.infixOrderSearch(ele);
        } else {
            return null;
        }
    }

    //后序遍历
    public Node<K> postOrderSearch(K ele) {
        if (root != null) {
            return this.root.postOrderSearch(ele);
        } else {
            return null;
        }
    }
}

class Node<K> {
    private K ele;
    private Node<K> left; //默认null
    private Node<K> right; //默认null

    public Node(K ele) {
        this.ele = ele;
    }

    public K getEle() {
        return ele;
    }

    public void setEle(K ele) {
        this.ele = ele;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node<K> left) {
        this.left = left;
    }

    public Node<K> getRight() {
        return right;
    }

    public void setRight(Node<K> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "ele=" + ele +
                '}';
    }


    public void delNode(K ele) {
        if (this.left != null && this.left.ele == ele) {
            this.left = null;
            return;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if (this.right != null && this.right.ele == ele) {
            this.right = null;
            return;
        }
        //4.我们就需要向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(ele);
        }
        //5.则应当向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode(ele);
        }
    }

    //编写前序遍历的方法
    public void preOrder() {
        System.out.println(this); //先输出父结点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {

        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父结点
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找

    /**
     * @param ele 查找no
     * @return 如果找到就返回该Node ,如果没有找到返回 null
     */
    public Node<K> preOrderSearch(K ele) {
        System.out.println("进入前序遍历");
        if (this.ele == ele) {
            return this;
        }
        Node<K> resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(ele);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(ele);
        }
        return resNode;
    }

    //中序遍历查找
    public Node<K> infixOrderSearch(K ele) {
        Node<K> resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(ele);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序查找");
        if (this.ele == ele) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(ele);
        }
        return resNode;

    }

    //后序遍历查找
    public Node<K> postOrderSearch(K ele) {

        Node<K> resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(ele);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(ele);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序查找");
        if (this.ele == ele) {
            return this;
        }
        return resNode;
    }

}