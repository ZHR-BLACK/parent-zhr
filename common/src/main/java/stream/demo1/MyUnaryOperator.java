package stream.demo1;

import java.util.function.UnaryOperator;

/**
 * @Describe:
 * @author: morningcat.zhang
 * @Date: 2019/2/4 5:05 PM
 */
public class MyUnaryOperator implements UnaryOperator<Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 2;
    }
}
