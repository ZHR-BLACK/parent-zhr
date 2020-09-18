package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName NodeTest
 * @Date 2020-09-17 16:20
 * @description todo
 **/
public class NodeReverseTest {

    public class Node{
        int val;
        Node next;

        Node(int x){
            val = x;
        }
    }

    public Node reverse(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node p = reverse(node);
        node.next.next = node;
        node.next = null;
        return p;
    }

    public static void main(String[] args) {

    }
}
