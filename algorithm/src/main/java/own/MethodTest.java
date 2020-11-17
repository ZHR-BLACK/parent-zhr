package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MethodTest
 * @Date 2020-11-04 17:25
 * @description 当程序执行Test tset时：jvm发现还没有加载过一个称为”Test”的类，它就开始查找并加载类文件”Test.class”。
 * 它从类文件中抽取类型信息并放在了方法区中，jvm于是以一个直接指向方法区lava类的指针替换了'test'符号引用，
 * 以后就可以用这个指针快速的找到Test类了。所以这也是为什么可以直接test.任何静态的东西
 **/
public class MethodTest {

    public static void hello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        MethodTest test = null;
        test.hello();
    }
}
