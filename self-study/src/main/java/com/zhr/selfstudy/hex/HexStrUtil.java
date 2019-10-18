package com.zhr.selfstudy.hex;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName HexStr
 * @Date 2019-10-17 15:58
 * 字符串与16进制互转
 **/
public class HexStrUtil {

    /**
     * @Author ZHR
     * @Description 将字符串转为16进制字符串(无需Unicode编码)
     * @Date2019/4/1515:19
     * @param:str 待转化字符串
     * @returnjava.lang.String
     **/
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString().trim();
    }

    /**
     * @Author ZHR
     * @Description 将16进制字符串转为字符串(无需Unicode编码)
     * @Date2019/4/1515:23
     * @param: hexStr
     * @returnjava.lang.String
     **/
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

}
