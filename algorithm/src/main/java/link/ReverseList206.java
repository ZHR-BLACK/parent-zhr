package link;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReverseList206
 * @Date 2019-07-02 16:03
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 **/
public class ReverseList206 {

    /**
     * @param head
     * @return link.ReverseList206.ListNode
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
     * 在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
     * 时间复杂度：O(n)，假设 nn 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)。
     * @Date 2019-07-02 16:05
     * 执行用时：1ms，在所有Java提交中击败了83.50%的用户
     * 内存消耗：36.4MB，在所有Java提交中击败了55.69%的用户
     **/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            // 这两句代码相当于将当前的头结点添加到prev中
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归
     *
     * @param head
     * @return link.ReverseList206.ListNode
     * 时间复杂度：O(n)，假设 nn 是列表的长度，那么时间复杂度为 O(n)。
     * 空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n层。
     * <p>
     * 执行用时：1ms，在所有Java提交中击败了83.50%的用户
     * 内存消耗：35.9MB，在所有Java提交中击败了56.12%的用户
     * @Date 2019-07-02 16:06
     **/
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        ListNode linkedList = ListNode.createLinkedList(arr);
        ListNode.printLinkedList(linkedList);

        ReverseList206 reverseList206 = new ReverseList206();
        ListNode listNode = reverseList206.reverseList(linkedList);
        ListNode.printLinkedList(listNode);

//        ListNode listNode2 = reverseList206.reverseList2(linkedList);
//        ListNode.printLinkedList(listNode2);
    }


}
