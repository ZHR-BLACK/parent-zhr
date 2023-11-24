import java.util.Stack;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MyQueue
 * @Date 2023-07-18 16:11
 * @description MyQueue
 **/
public class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        judgeEmpty();
        return outStack.pop();
    }

    public int peek() {
        judgeEmpty();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    private void judgeEmpty() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
