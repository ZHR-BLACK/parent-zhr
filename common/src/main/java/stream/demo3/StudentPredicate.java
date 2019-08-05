package stream.demo3;

import stream.demo2.Student;

import java.util.function.Predicate;

/**
 * @Describe:
 * @author: morningcat.zhang
 * @Date: 2019/2/5 9:26 PM
 */
public class StudentPredicate implements Predicate<Student> {
    @Override
    public boolean test(Student student) {
        if (student == null) {
            return false;
        }
        if (student.getAge() > 0) {
            return true;
        }
        return false;
    }
}
