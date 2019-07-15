package link;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DeleteNode
 * @Date 2019/6/13 15:56
 * 237. 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <p>
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 说明:
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 **/
public class DeleteNode237 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    /**
     * @Date 2019/6/13 15:57
     * @param  node
     * @return void
     * 执行用时：1ms，在所有ava提交中击败了86.60%的用户内存消耗：35.5MB，在所有Java提交中击败了90.80%的用户
     * 时间和空间复杂度都是：O(1)。
     **/
    public void deleteNode(ListNode node) {
        // 将该节点后面节点的值赋给该节点
        node.val = node.next.val;
        // 将节点后一个的后一个节点赋给该节点的下一个节点
        node.next = node.next.next;
    }
}