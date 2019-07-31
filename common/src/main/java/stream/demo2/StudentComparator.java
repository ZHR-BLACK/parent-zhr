package stream.demo2;

import java.util.Comparator;

/**
 * @Describe: 倒序排列
 * @author: morningcat.zhang
 * @Date: 2019/2/5 9:11 PM
 */
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getAge() - o1.getAge();
    }
}
