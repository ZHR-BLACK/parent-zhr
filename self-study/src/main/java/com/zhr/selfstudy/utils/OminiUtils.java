package com.zhr.selfstudy.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.x500.X500Principal;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class OminiUtils {


    private static Logger log = LoggerFactory.getLogger(OminiUtils.class);

    private static String CLS_PREFIX = "com.qhjf.bankinterface";

    private OminiUtils() {

    }

    /**
     * 将字符串全部大写
     *
     * @param word
     * @return
     */
    public static String toUpperCase(String word) {
        return isNullOrEmpty(word) ? word : word.toUpperCase();
    }

    /**
     * 将字符串全部小写
     *
     * @param word
     * @return
     */
    public static String toLowerCase(String word) {
        return isNullOrEmpty(word) ? word : word.toLowerCase();
    }


    /**
     * 将字符串首字母大写
     *
     * @param word
     * @return
     */
    public static String capitalize(String word) {
        return isNullOrEmpty(word) ? word : toUpperCase(word.substring(0, 1)) + word.substring(1);
    }


    public static String filterQuota(String str) {
        return isNullOrEmpty(str) ? str : str.replaceAll("\"", "").replaceAll("\'", "");
    }


    /**
     * 把输入流的数据复制到输出流中
     *
     * @param is
     * @param os
     * @throws Exception
     */
    public static void copyInputStreamToOutStream(InputStream is, OutputStream os) throws Exception {
        byte[] buffer = new byte[1024 * 10];

        int length = is.read(buffer);

        while (length != -1) {
            os.write(buffer, 0, length);
            length = is.read(buffer);
        }

    }


    /**
     * 把输入流转换为字节数组
     *
     * @param is`
     * @return
     * @throws Exception
     */
    public static byte[] convertInputStreamToByteArray(InputStream is) throws Exception {
        byte[] buffer = new byte[1024 * 10];

        int length = is.read(buffer);
        ByteArrayOutputStream os = null;

        try {

            os = new ByteArrayOutputStream();
            while (length != -1) {
                os.write(buffer, 0, length);
                length = is.read(buffer);
            }
            return os.toByteArray();
        } finally {
            closeStream(os);
        }
    }

    /**
     * 关闭流
     *
     * @param stream 流
     */
    public static void closeStream(Object stream) {

        if (stream == null) {
            return;
        }

        if (stream instanceof InputStream) {
            try {
                ((InputStream) stream).close();
            } catch (IOException e) {

            }
        }

        if (stream instanceof OutputStream) {
            try {
                ((OutputStream) stream).close();
            } catch (IOException e) {

            }
        }

    }


    public static String convertPath2Pkg(String path) {
        if (!isNullOrEmpty(path)) {
            return path.replaceAll("/", "\\.");
        }
        return "";
    }

    public static String convertPkg2Path(String packageName) {
        if (!isNullOrEmpty(packageName)) {
            return packageName.replaceAll("\\.", "/");
        }
        return "";
    }


    /**
     * 在数值前面补0 ， 如果数值的长度超过最大长度，直接返回数值的字符串
     *
     * @param squence 数字
     * @param maxlen  最大长度
     * @return
     */
    public static String getSequence(int squence, int maxlen) {
        String str_squence = String.valueOf(squence);
        int len = str_squence.length();
        if (len > maxlen) {
            return str_squence;
        }
        int rest = maxlen - len;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rest; i++) {
            sb.append('0');
        }
        sb.append(str_squence);
        return sb.toString();
    }

    /**
     * 去除字符串首尾空格
     *
     * @param word
     * @return
     */
    public static String trim(String word) {
        return isNullOrEmpty(word) ? word : word.trim();
    }

    /**
     * 判断对象是否为空或null
     *
     * @param obj
     * @return
     */
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String) {
            return "".equals(obj);
        } else if (obj instanceof List) {
            return ((List<?>) obj).isEmpty();
        } else if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        } else if (obj instanceof Set) {
            return ((Set<?>) obj).isEmpty();
        } else {
            return obj instanceof Queue ? ((Queue<?>) obj).isEmpty() : false;
        }
    }


    /**
     * 根据classname获取实例对象
     *
     * @param clzname
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(String clzname) {
        T result = null;
        try {
            Class<T> clz = (Class<T>) Class.forName(clzname);
            Constructor<T> constructor = clz.getDeclaredConstructor();
            constructor.setAccessible(true);
            result = constructor.newInstance();
            constructor.setAccessible(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据classname获取实例对象,只能加载com.qhjf.bankinterface 下的类
     *
     * @param clzname
     * @return
     */
    public static Class<?> getClz(String clzname) {
        Class<?> clz = null;
        if (clzname.startsWith(CLS_PREFIX)) {
            try {
                clz = Class.forName(clzname);
                return clz;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return clz;
    }

    public static String getCNFromCertificate(X509Certificate cert) {
        X500Principal principal = cert.getSubjectX500Principal();
        String[] subjectItem = principal.toString().split(",");

        for (int i = 0; i < subjectItem.length; ++i) {
            String item = subjectItem[i];
            if (item.startsWith("CN")) {
                return item.split("=")[1];
            }
        }

        return principal.toString();
    }


    public static String getKeyStoreInstance(String filename) {
        log.info("Enter into getKeyStoreInstance");
        log.info("filename is " + filename);
        if (filename != null && !"".equals(filename)) {
            if (filename.toUpperCase().endsWith("PFX")) {
                return "PKCS12";
            } else {
                return "JKS";
            }
        }
        return "";
    }
}

