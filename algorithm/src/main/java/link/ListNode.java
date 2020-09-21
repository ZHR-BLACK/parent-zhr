package link;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ListNode
 * @Date 2020-09-21 11:42
 * @description 通用链表类
 **/
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * @Date 2019-12-31 14:42
     * @param  arr
     * @return link.ReverseList206.ListNode
     * 1、先创建头结点，在把头结点设置为当前节点，然后开始遍历，几乎成为了一个套路；
     * 2、current = current.next; 表示指针后移，模板代码；
     * 3、用头结点就可以代表一个链表，所以返回的是 head。
     * 注意：要考虑到数组为空的情况。
     *
     **/
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        // 把这个迭代想象成一个动画去理解，就很好理解了
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head){
        ListNode current =  head;
        while (current!=null){
            System.out.printf("%d -> ",current.val);
            current = current.next;
        }
        System.out.println("NULL");
    }
}
