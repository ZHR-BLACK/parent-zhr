package link;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DoubleLink 暂不考虑
 * @Date 2020-03-13 17:40
 * @description 双向链表
 **/
public class DoubleLink<T> {

    /**
     * Node<AnyType>类定义了双向链表中节点的结构，它是一个私有类， 而其属性和构造函数都是公有的，这样，其父类可以直接访问其属性
     * 而外部类根本不知道Node类的存在。
     *
     * @param <T>  类型
     * @param Data 是节点中的数据
     * @param pre  指向前一个Node节点
     * @param next 指向后一个Node节点
     * @author ZHB
     */
    private class Node<T> {
        public Node<T> pre;
        public Node<T> next;
        public T data;

        public Node(T data, Node<T> pre, Node<T> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public Node() {
            this.data = null;
            this.pre = null;
            this.next = null;
        }
    }

    // 下面是DoubleLinkedList类的数据成员和方法
    private int theSize;
    private Node<T> Header;
    private Node<T> Tail;

    /*
     * 构造函数 我们构造了一个带有头、尾节点的双向链表 头节点的Next指向尾节点 为节点的pre指向头节点 链表长度起始为0。
     */
    public DoubleLink() {

        theSize = 0;
        Header = new Node<T>(null, null, null);
        Tail = new Node<T>(null, Header, null);

        Header.next = Tail;
    }

    public void add(T item) {

        Node<T> aNode = new Node<T>(item, null, null);

        Tail.pre.next = aNode;
        aNode.pre = Tail.pre;
        aNode.next = Tail;
        Tail.pre = aNode;

        theSize++;
    }

    public boolean isEmpty() {
        return (this.theSize == 0);
    }

    public int size() {
        return this.theSize;
    }

    public T getInt(int index) {
        if (index > this.theSize - 1 || index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> current = Header.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void print() {
        Node<T> current = Header.next;

        while (current.next != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
    }

    public static void main(String[] args) {
        DoubleLink<String> dLink = new DoubleLink<String>();

        dLink.add("zhb");
        dLink.add("zzb");
        dLink.add("zmy");
        dLink.add("zzj");

        System.out.println("size : " + dLink.size());
        System.out.println("isEmpty? : " + dLink.isEmpty());
        System.out.println("3 : " + dLink.getInt(2));
        dLink.print();

        System.out.println("********************");
        dLink.add("www");
        dLink.print();

    }
}
