package behavior_pattern.state;

import lombok.Data;

/**
 * 状态类的核心类
 *
 * @author smilesnake
 */
@Data
public class State {

    private String value;

    public void method1() {
        System.out.println("execute the first opt!");
    }

    public void method2() {
        System.out.println("execute the second opt!");
    }

}
