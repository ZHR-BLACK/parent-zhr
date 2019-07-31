package stream.demo2;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Describe: 学生类
 * @author: morningcat.zhang
 * @Date: 2019/2/5 1:13 AM
 */
@Data
@ToString
@Accessors(chain = true)
@EqualsAndHashCode
public class Student implements Serializable, Comparable<Student> {

    private int id;
    private String name;
    private int age;

    private Double height;

    /**
     * 正序排列
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}
