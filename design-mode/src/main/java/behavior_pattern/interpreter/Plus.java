package behavior_pattern.interpreter;

/**
 * @Author ZHR
 * @Description 加法解释器
 * @Date 2019/5/23 17:12
 **/
public class Plus implements Expression {

    @Override
    public int interpret(Context context) {

        return context.getNum1() + context.getNum2();
    }

}
