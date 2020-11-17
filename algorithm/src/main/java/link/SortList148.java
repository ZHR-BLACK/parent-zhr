package link;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SortList148
 * @Date 2019-07-04 18:01
 * 148. 排序链表
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 **/
public class SortList148 {

    /**
     * @param head
     * @return link.SortList148.ListNode
     * 执行用时：284ms，在所有Java提交中击败了14.59%的用户
     * 内存消耗：40.5MB，在所有Java提交中击败了98.56%的用户
     * @Date 2019-07-05 10:19
     **/
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }
    void quickSort(ListNode head, ListNode tail) {
        if (head == tail || head.next == tail)
            return;

        int pivot = head.val;
        ListNode left = head, cur = head.next;

        while (cur != tail) {
            if (cur.val < pivot) {
                left = left.next;
                swap(left, cur);
            }
            cur = cur.next;
        }
        swap(head, left);
        quickSort(head, left);
        quickSort(left.next, tail);
    }

    private void swap(ListNode left, ListNode right) {
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
    }

    /**
     * @param head
     * @return link.SortList148.ListNode
     * 执行用时：13ms，在所有Java提交中击败了31.95%的用户
     * 内存消耗：49.5MB，在所有Java提交中击败了5.04%的用户
     * @Date 2019-07-05 10:21
     **/
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;

        ListNode left = sortList(head);

        return merge(left, right);
    }

    /**
     * 找出中间的节点
     */
    public ListNode findMiddle(ListNode node) {
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 对两组链表进行归并排序
     */
    public ListNode merge(ListNode left, ListNode right) {
        ListNode a = left;
        ListNode b = right;

        ListNode result = new ListNode(0);
        ListNode tmp = result;

        while (a != null && b != null) {
            while (a != null && a.val <= b.val) {
                tmp.next = new ListNode(a.val);
                tmp = tmp.next;
                a = a.next;
            }
            while (a != null && b != null && b.val <= a.val) {
                tmp.next = new ListNode(b.val);
                tmp = tmp.next;
                b = b.next;
            }
        }

        if (a != null) {
            tmp.next = a;
        } else if (b != null) {
            tmp.next = b;
        }
        return result.next;
    }
}
