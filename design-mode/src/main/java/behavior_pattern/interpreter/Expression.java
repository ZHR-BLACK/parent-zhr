package behavior_pattern.interpreter;

/**
 * @Author ZHR
 * @Description 解释器接口
 * @Date 2019/5/23 17:12
 **/
public interface Expression {

    int interpret(Context context);

}
