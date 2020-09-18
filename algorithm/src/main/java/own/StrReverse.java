package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StrReverse
 * @Date 2020-09-17 19:42
 * @description todo
 **/
public class StrReverse {

    public static void main(String[] args) {
        String asdas = reverse("asdas");
        System.out.println("asdas==================" + asdas);

        int a = 100 >> 2;
        System.out.println("a==================" + a);
    }

    public static String reverse(String str){
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse =  str.charAt(i) + reverse;
        }
        return reverse;
    }
}
