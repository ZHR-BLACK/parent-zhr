package stack;

import java.util.Stack;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MinStack155
 * @Date 2019-07-04 16:56
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * <p>
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 **/
public class MinStack155 {

    /**
     * @Date 2019-07-04 17:56
     * Stack.Peek 与 stack.pop 的区别
     *
     * 相同点：大家都返回栈顶的值。
     * 不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
     **/
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    /**
     * @param
     * @return 执行用时：107ms，在所有Java提交中击败了52.87%的用户
     * 内存消耗：44.4MB，在所有Java提交中击败了59.09%的用户
     * @Date 2019-07-04 17:05
     **/
    public MinStack155() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    // 入栈
    public void push(int x) {
        stack.push(x);
        // 用min_stack存放最小值
        if (min_stack.isEmpty() || x <= min_stack.peek())
            min_stack.push(x);
    }
    // 出栈
    public void pop() {
        // 如果stack顶是最小元素,则同时将min_stack顶的元素取出
        if (stack.pop().equals(min_stack.peek()))
            // 取出栈顶的元素
            min_stack.pop();
    }

    public int top() {
        // 查看栈顶元素
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

}
