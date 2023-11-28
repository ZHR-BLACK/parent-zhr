package own;

import java.util.logging.Logger;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StrReverse
 * @Date 2020-09-17 19:42
 * @description 字符串反转
 **/
public class StrReverse {

    static Logger log = Logger.getLogger("StrReverse");

    public static void main(String[] args) {
        String asdas = reverse("asdas");
        log.info(asdas);
    }

    public static String reverse(String str) {
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }
}
