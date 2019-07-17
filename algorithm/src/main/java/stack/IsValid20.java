package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IsValid20
 * @Date 2019-07-12 17:05
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 **/
public class IsValid20 {

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public IsValid20() {
        this.mappings = new HashMap();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    /**
     * @param s
     * @return boolean
     * <p>
     * 执行用时：8ms，在所有Java提交中击败了31.56%的用户
     * 内存消耗：34.5MB，在所有Java提交中击败了83.87%的用户
     * <p>
     * 初始化栈 S。
     * 一次处理表达式的每个括号。
     * 如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
     * 如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
     * 如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
     * <p>
     * 复杂度分析
     * 时间复杂度：O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1) 的推入和弹出操作。
     * 空间复杂度：O(n)，当我们将所有的开括号都推到栈上时以及在最糟糕的情况下，我们最终要把所有括号推到栈上。例如 ((((((((((。
     * @Date 2019-07-12 17:08
     **/
    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            // 如果是闭符号,进入逻辑判断
            if (this.mappings.containsKey(c)) {
                // 如果面对一个闭符号,而栈中是空的,则说明是无效的了,因为闭符号不能在第一个位置
                if (stack.empty()) {
                    return false;
                }
                // 如果栈中深度超过一半的元素数量,则说明剩下的肯定匹配不完栈中的元素了,最后栈中还剩下元素
                if (stack.size() > length / 2) {
                    return false;
                }
                // Get the top element of the stack.
                // 栈中弹出一个开符号
                char topElement = stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                // 如果弹出的开符号跟this.mappings.get(c)不一致,说明匹配不上,说明无效了
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                // 说明是开符号,将其添加到栈中
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

}
