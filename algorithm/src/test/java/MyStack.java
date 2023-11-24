import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MyStack
 * @Date 2023-07-18 16:22
 * @description MyStack
 **/
public class MyStack {

    Deque<Integer> inDeque;
    Deque<Integer> outDeque;

    public MyStack() {
        inDeque = new LinkedList<>();
        outDeque = new LinkedList<>();
    }

    public void push(int x) {
        inDeque.push(x);
    }

    public int pop() {
        judgeEmpty();
        return outDeque.pop();
    }

    public int top() {
        judgeEmpty();
        return outDeque.getFirst();
    }

    public boolean empty() {
        return inDeque.isEmpty() && outDeque.isEmpty();
    }

    private void judgeEmpty() {
        while (!inDeque.isEmpty()) {
            outDeque.push(inDeque.pollLast());
        }
    }
}
