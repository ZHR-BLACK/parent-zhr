package stream.demo2;

import java.util.function.Predicate;

/**
 * @Describe:
 * @author: morningcat.zhang
 * @Date: 2019/2/5 1:25 AM
 */
public class MyPredicate implements Predicate<Student> {

    @Override
    public boolean test(Student o) {
        if (o == null) {
            return false;
        }
        if (o.getAge() == 18) {
            return false;
        }
        return true;
    }
}
