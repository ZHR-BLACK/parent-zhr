package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CalMain
 * @Date 2020-09-17 16:54
 * @description 计算
 **/
public class CalMain {

    public static void main(String[] args) {
        int a = 10 >> 1;
        System.out.println("a==================" + a);
        int b = a++;
        System.out.println("b==================" + b);
        int c = ++a;
        System.out.println("c==================" + c);
        int d = b * a++;
        System.out.println("d==================" + d);
    }
}
