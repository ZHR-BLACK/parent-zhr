package link;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LinkedTableTest
 * @Date 2020-03-13 17:46
 * @description 双向链表的增删改
 **/
public class LinkedTableTest {


    //构造单链表
    static Node node1 = new Node("name1");
    static Node node2 = new Node("name2");
    static Node node3 = new Node("name3");
    static Node node4 = new Node("name4");
    static Node node5 = new Node("name5");

    static Node head = node1;
    static Node tail = node5;

    public static void main(String[] args) {

        //循环遍历
        System.out.println("*******初始链表*******");
        //设置指针
        setPoint();

        out(head, tail);
        System.out.println();

        //插入节点在node2的后面
        Node node_add = new Node("name2.5");
        addNode(node_add, 0);

        // 循环遍历
        System.out.println("*******插入node后*******");
        out(head, tail);
        System.out.println();

        //删除节点
//        node2.setNextNode(node3);
//        node3.setNextNodeF(node2);
        Node anInt = getInt(3);
        deleteNode(anInt);

        // 循环遍历
        System.out.println("*******删除node后*******");
        out(head, tail);
        System.out.println();

    }

    //设置指针
    public static void setPoint() {

        //设置正向指针
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
        //设置反向指针
        node5.setNextNodeF(node4);
        node4.setNextNodeF(node3);
        node3.setNextNodeF(node2);
        node2.setNextNodeF(node1);
    }

    public static Node getInt(int index) {
        if (index == 0) {
            return head;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        return current;
    }

    //循环遍历单链表
    public static void outLinked(Node startNode) {
        Node node = new Node();
        node.setNextNode(startNode);
        do {
            node = node.getNextNode();
            System.out.print(node.getName() + "----");
        } while (node.getNextNode() != null);
    }

    //反向循环遍历单链表
    public static void outLinkedF(Node endNode) {
        Node node = new Node();
        node.setNextNodeF(endNode);
        do {
            node = node.getNextNodeF();
            System.out.print(node.getName() + "----");
        } while (node.getNextNodeF() != null);
    }

    //循环遍历
    public static void out(Node startNode, Node endNode) {
        outLinked(startNode);
        System.out.println();
//        outLinkedF(endNode);
    }

    //插入节点
    public static void addNode(Node node, int index) {
        Node preNode = null;
        Node nextNode = null;
        if(index == 0){
            node.setNextNode(head);
            head.setNextNodeF(node);
            head = node;
            return;
        } else {
            preNode = getInt(index - 1);
            nextNode = getInt(index + 1);
        }
        node.setNextNode(preNode.getNextNode());
        preNode.setNextNode(node);

        node.setNextNodeF(nextNode.getNextNodeF());
        nextNode.setNextNodeF(node);

    }

    public static void deleteNode(Node node) {
        Node preNode = node.getNextNodeF();
        Node nextNode = node.getNextNode();
        //删除节点
        preNode.setNextNode(nextNode);
        nextNode.setNextNodeF(preNode);
    }


}


class Node {
    private String name;
    private Node nextNode;
    private Node nextNodeF;

    public void setName(String name) {
        this.name = name;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setNextNodeF(Node nextNodeF) {
        this.nextNodeF = nextNodeF;
    }

    public String getName() {
        return this.name;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public Node getNextNodeF() {
        return this.nextNodeF;
    }

    public Node(String name) {
        this.name = name;
        this.nextNode = null;
    }

    public Node() {

    }
}
