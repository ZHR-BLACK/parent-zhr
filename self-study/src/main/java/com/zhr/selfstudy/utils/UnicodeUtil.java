package com.zhr.selfstudy.utils;

public class UnicodeUtil {

    /**
     * 将String转换成unicode编码格式
     *
     * @param str
     * @return String
     * @throws
     */
    public static String unicodeEncoding(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        StringBuffer unicodeBytes = new StringBuffer();
        for (int byteIndex = 0; byteIndex < str.length(); byteIndex++) {
            String hexB = Integer.toHexString(str.charAt(byteIndex));
            unicodeBytes.append("\\u");
            if (hexB.length() <= 2) {
                unicodeBytes.append("00");
            }
            unicodeBytes.append(hexB);
        }
        return unicodeBytes.toString();
    }

    /**
     * 将unicode转中文
     *
     * @param dataStr
     * @return
     */
    public static String decodeUnicode(String dataStr) {
        int start = 0;
        int end = 0;
        StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。     
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
    	/*String dataStr = "\\u5929";
        String decodeUnicode = UnicodeUtil.decodeUnicode(dataStr);
        System.out.println(decodeUnicode);
        String unicodeEncoding = UnicodeUtil.unicodeEncoding(decodeUnicode);
        System.out.println(unicodeEncoding);*/

        String str = "123中国str";
        System.out.println(unicodeEncoding(str));
        System.out.println(decodeUnicode("\\u0031\\u0032\\u0033\\u4e2d\\u56fd\\u0073\\u0074\\u0072"));
    }
}
