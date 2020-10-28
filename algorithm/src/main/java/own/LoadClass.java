package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LoadClass
 * @Date 2020-09-21 14:05
 * @description 测试加载顺序
 * 美团面试题
 **/
public class LoadClass {

    public static LoadClass c = new LoadClass();
    public static LoadClass c1 = new LoadClass();
    {
        System.out.println("普通代码块");
    }
    static {
        System.out.println("静态代码块");
    }
    public static void main(String[] args) {
        LoadClass c = new LoadClass();
    }
}
