package own;

import link.ListNode;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FindKthToTail
 * @Date 2020-09-25 16:15
 * @description 输入一个链表，输出该链表中的倒数第 k 个结点。比如链表为 head-->1-->2-->3-->4-->5。
 * 求倒数第三个结点（即值为 3 的节点）
 **/
public class FindKthToTail {

    public ListNode findKthToTail(ListNode head, int k) throws Exception {
        ListNode fastNode = head.next;
        ListNode slowNode = head.next;
        // 快指针先移到第k个结点
        int tmk = k - 1;
        while (tmk > 0 && fastNode != null) {
            fastNode = fastNode.next;
            tmk--;
        }
        // 临界条件：k大于链表长度
        if (fastNode == null) {
            throw new Exception("K结点不存在异常");
        }
        // slow和fast同时往后移,直到fast走到尾结点
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        // 将头结点赋给一个新节点
        return new ListNode(slowNode.val);
    }

    public static void main(String[] args) throws Exception {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ListNode linkedList = ListNode.createLinkedList(arr);
        ListNode.printLinkedList(linkedList);

        FindKthToTail findKthToTail = new FindKthToTail();
        ListNode listNode = findKthToTail.findKthToTail(linkedList, 3);
        ListNode.printLinkedList(listNode);
    }

}
