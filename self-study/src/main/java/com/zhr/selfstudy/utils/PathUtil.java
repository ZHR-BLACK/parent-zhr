package com.zhr.selfstudy.utils;

public class PathUtil {

    public static String getConfigFilePath() {
        String path = null;
        try {
            path = PathUtil.class.getClassLoader().getResource("").getPath() + "config/";
        } catch (Exception e) {
            path = "config/";
        }
        return path;
    }

}
