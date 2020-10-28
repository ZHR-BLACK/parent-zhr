package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName PrintStar
 * @Date 2020-10-28 15:26
 * @description 打印金字塔星星
 **/
public class PrintStar {

    public static void main(String[] args) {
        print(5);
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i * 2 + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
