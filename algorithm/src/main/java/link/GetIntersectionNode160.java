package link;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName GetIntersectionNode160
 * @Date 2019-07-02 11:21
 * 160. 相交链表
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 **/
public class GetIntersectionNode160 {

    /**
     * 有配图,image/160.png
     *
     * @param headA
     * @param headB
     * @return link.GetIntersectionNode160.ListNode
     * 执行用时：2ms，在所有Java提交中击败了96.34%的用户
     * 内存消耗：47.7MB，在所有Java提交中击败了10.55%的用户
     * @Date 2019-07-02 11:23
     * 定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
     * 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while (pA != pB) {
            pA = (pA == null ? headB : pA.next);
            pB = (pB == null ? headA : pB.next);
        }
        return pA;
    }

    /**
     * @param headA
     * @param headB
     * @return link.GetIntersectionNode160.ListNode
     * @Date 2019-07-02 11:22
     * 执行用时：20ms，在所有Java提交中击败了12.00%的用户
     * 内存消耗：47.9MB，在所有Java提交中击败了8.29%的用户
     **/
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }

    /**
     * @param headA
     * @param headB
     * @return link.GetIntersectionNode160.ListNode
     * 执行用时：2ms，在所有Java提交中击败了96.34%的用户
     * 内存消耗：47.6MB，在所有Java提交中击败了12.86%的用户
     * @Date 2019-07-02 11:33
     **/
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 将B的尾节点指向其头节点使其成为一个环
        ListNode last = headB;
        while (last.next != null) {
            last = last.next;
        }
        last.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 进入这里说明两个快慢指针在环中相遇
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // 将B链表环断开
                last.next = null;
                return fast;
            }
        }
        // 将B链表环断开
        last.next = null;
        return null;
    }

}
