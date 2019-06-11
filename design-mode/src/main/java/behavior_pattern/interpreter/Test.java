package behavior_pattern.interpreter;

/**
 * <p>解释器模式
 * <p>一般主要应用在OOP开发中的编译器的开发中，所以适用面比较窄
 * <p>解释器模式用来做各种各样的解释器，如正则表达式等的解释器等等！
 *
 * @author ZHR
 */
public class Test {
    public static void main(String[] args) {
        // 计算9+2-8的值
        int i = new Plus().interpret(new Context(9, 2));
        int result = new Minus().interpret(new Context(i, 8));
        System.out.println("result = " + result);
    }
}
