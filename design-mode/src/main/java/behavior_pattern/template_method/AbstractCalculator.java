package behavior_pattern.template_method;

/**
 * @Author ZHR
 * @Description 抽象方法的模板，其中有一个方法定义了业务的流程，并含有需要子类重写的抽象方法
 * @Date 2019/5/23 16:45
 **/
public abstract class AbstractCalculator {
    /**
     * @return int
     * @Author ZHR
     * @Description 业务流程方法
     * @Date 2019/5/23 16:46
     * @param: exp
     * @param: opt
     **/
    public final int calculate(String exp, String opt) {
        int[] array = split(exp, opt);
        return calculate(array[0], array[1]);
    }

    /* 被子类重写的方法 */
    abstract public int calculate(int num1, int num2);

    public int[] split(String exp, String opt) {
        String[] array = exp.split(opt);
        int[] arrayInt = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}
