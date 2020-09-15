package behavior_pattern.strategy;

/**
 * 策略模式
 * <p>策略模式的决定权在用户，系统本身提供不同算法的实现，
 * <p>新增或者删除算法，对各种算法做封装。因此，
 * <p>策略模式多用在算法决策系统中，外部用户只需要决定用哪个算法即可。
 * 一般这些不同的算法实现统一的接口，因此性质属于一类
 *
 * @author smilesnake
 */
public class StrategyTest {
    public static void main(String[] args) {
        // 加法
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);

        // 乘法
        String exp2 = "2*8";
        ICalculator cal2 = new Multiply();
        int result2 = cal2.calculate(exp2);
        System.out.println(result2);
    }
}
