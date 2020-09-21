package link;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RemoveNthFromEnd19
 * @Date 2019-07-01 11:58
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 **/
public class RemoveNthFromEnd19 {

    /**
     * @param head
     * @param n
     * @return link.RemoveNthFromEnd19.ListNode
     * @Date 2019-07-01 11:58
     * 第一个指针从列表的开头向前移动 n+1n+1 步，而第二个指针将从列表的开头出发。现在，这两个指针被 nn 个结点分开。
     * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 nn 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     * <p>
     * 复杂度分析:
     * 时间复杂度：O(L)，该算法对含有 LL 个结点的列表进行了一次遍历。因此时间复杂度为 O(L)。
     * 空间复杂度：O(1)，我们只用了常量级的额外空间。
     * <p>
     * 执行用时：2ms，在所有Java提交中击败了89.89%的用户
     * 内存消耗：34.9MB，在所有Java提交中击败了86.69%的用户
     **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        // 移动第一个节点使其与第二个节点保持n个间隔
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        // 同时移动第一,二个节点,每次移动一步,直到第一个节点为空,此时第二个节点即为待删除节点的前一个节点
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 将第二个节点的下下个节点赋给其下个节点,即达到删除节点的效果
        second.next = second.next.next;
        // 返回头节点
        return dummy.next;
    }
}
