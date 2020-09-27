package behavior_pattern.strategy;

/**
 * @Author ZHR
 * @Description 减法
 * @Date 2019/5/23 16:28
 **/
public class Minus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] arrayInt = split(exp, "-");
        return arrayInt[0] - arrayInt[1];
    }

}  
