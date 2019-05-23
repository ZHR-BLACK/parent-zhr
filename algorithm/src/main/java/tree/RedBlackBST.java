package tree;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RedBlackBST
 * @Date 2019/5/15 18:32
 * @description 红黑树实现代码
 **/
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key; //键
        private Value val; //值
        private Node left, right, parent; //左右子树和父节点
        private boolean color; //由其父节点指向它的链接的颜色

        public Node(Key key, Value val, Node parent, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (root == null) { //如果是根节点，就将节点新建为黑色
            root = new Node(key, val, null, BLACK);
            return;
        }
        //寻找合适的插入位置
        Node parent = null;
        Node cur = root;
        while (cur != null) {
            parent = cur;
            if (key.compareTo(cur.key) > 0) cur = cur.right;
            else cur = cur.left;
        }
        Node n = new Node(key, val, parent, RED); //普通的新建节点为红色
        //将新节点插入parent下
        if (key.compareTo(parent.key) > 0) parent.right = n;
        else parent.left = n;
        //插入新节点后要调整树中部分节点的颜色和属性来保证红黑树的特征不被破坏
        fixAfterInsertion(n);
    }

    private Node parentOf(Node x) {
        return (x == null ? null : x.parent);
    }

    private boolean colorOf(Node x) {
        return (x == null ? BLACK : x.color);
    }

    private Node leftOf(Node x) {
        return (x == null ? null : x.left);
    }

    private Node rightOf(Node x) {
        return (x == null ? null : x.right);
    }

    private void setColor(Node x, boolean color) {
        if (x != null)
            x.color = color;
    }

    private void fixAfterInsertion(Node x) {
        while (x != null && colorOf(parentOf(x)) == RED) {
            Node grandPa = parentOf(parentOf(x));
            Node parent = parentOf(x);
            if (parent == leftOf(grandPa)) {//case 1 || case2 || case3
                Node uncle = rightOf(grandPa);
                if (colorOf(uncle) == RED) {//case1, uncle is red
                    setColor(parent, BLACK);    //父节点置黑
                    setColor(uncle, BLACK);    //叔叔节点置黑
                    setColor(grandPa, RED);    //祖父节点置红
                    x = grandPa; //因为祖父节点由黑转红，故要重新调整父节点及其祖先的红黑属性
                } else {//case2 || case3,uncle is black
                    if (x == rightOf(parent)) { //case2
                        x = parent;
                        rotateLeft(x);
                    }
                    //case3
                    setColor(parent, BLACK);
                    setColor(grandPa, RED);
                    rotateRight(grandPa);
                }

            } else {//case4 || case 5 || case6
                Node uncle = leftOf(grandPa);
                if (colorOf(uncle) == RED) { //case4 || case5 || case6
                    setColor(parent, BLACK);
                    setColor(uncle, BLACK);
                    setColor(grandPa, RED);
                    x = grandPa;
                } else { //case5 || case6, uncle is black
                    if (x == leftOf(parent)) { //case5
                        x = parent;
                        rotateRight(x);
                    }
                    //case6
                    setColor(parent, BLACK);
                    setColor(grandPa, RED);
                    rotateLeft(grandPa);
                }
            }
        }
    }

    private void rotateLeft(Node x) {
        if (x == null) return;
        Node y = x.right;
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;
        y.left = x;
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x.parent.left == x) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        x.parent = y;
    }

    private void rotateRight(Node x) {
        if (x == null) return;
        Node y = x.left;
        x.left = y.right;
        if (y.right != null)
            y.right.parent = x;
        y.right = x;
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x.parent.left == x) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        x.parent = y;
    }
}