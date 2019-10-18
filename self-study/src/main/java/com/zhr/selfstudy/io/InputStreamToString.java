package com.zhr.selfstudy.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName InputStreamToString
 * @Date 2019-10-17 15:42
 * InputStream转为String
 **/
public class InputStreamToString {

    public String inputStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(StandardCharsets.UTF_8.name());
    }

    public static void main(String[] args) {

    }
}
