package behavior_pattern.state;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 状态模式的切换类
 *
 * @author smilesnake
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Context {

    private State state;

    public void method() {
        if (state.getValue().equals("state1")) {
            state.method1();
        } else if (state.getValue().equals("state2")) {
            state.method2();
        }
    }
}
