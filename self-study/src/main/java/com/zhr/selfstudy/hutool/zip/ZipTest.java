package com.zhr.selfstudy.hutool.zip;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.ZipUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/3/18 11:47
 * @描述
 */
public class ZipTest {

    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("a","asddasd");
        json.put("asd","张三");
        json.put("asd2","张三1");
        json.put("asd3","张三2");
        json.put("asd4","张三3");
        json.put("asd5","张三4");
        json.put("asd6","张三5");
        json.put("asd7","张三6");
        json.put("asd8","张三7");
        json.put("asd9","张三8");
        json.put("asd11","张三9");
        json.put("asd12","张三11");
        json.put("asd22","张三22");
        json.put("asd33","张三33");
        json.put("asd44","张三44");
        json.put("asd55","张三55");
        json.put("asd66","张三66");
        json.put("asd77","张三77");
        json.put("asd88","张三88");

        String encode = Base64.encode(json.toJSONString());
        System.out.println("encode = " + encode);

        String s = Base64.decodeStr(encode);
        System.out.println("s = " + s);

        byte[] zlib = ZipUtil.zlib(json.toJSONString(), "UTF-8", 0);
        String encode1 = Base64.encode(zlib);
        System.out.println("encode1 = " + encode1);


    }
}
