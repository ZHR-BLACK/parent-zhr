package com.zhr.selfstudy.record;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtils {
    /**
     * 将json对象序列化为Record
     *
     * @param jobj
     * @return
     */
    public static Record parse(JSONObject jobj) {
        return buildJSONObject(jobj);
    }


    /**
     * 将json的字符串序列化为Record
     *
     * @param str
     * @return
     */
    public static Record parse(String str) {
        if (StrKit.isBlank(str)) return null;
        JSONObject jobj = JSONObject.parseObject(str);
        return buildJSONObject(jobj);
    }


    private static Record buildJSONObject(JSONObject jobj) {
        Record record = new Record();
        if (jobj != null) {
            for (Map.Entry<String, Object> entry : jobj.entrySet()) {
                if (entry.getValue() instanceof JSONObject) {
                    record.set(entry.getKey(), buildJSONObject((JSONObject) entry.getValue()));
                } else if (entry.getValue() instanceof JSONArray) {
                    record.set(entry.getKey(), addChild((JSONArray) entry.getValue()));
                } else {
                    record.set(entry.getKey(), entry.getValue());
                }
            }
        }
        return record;
    }

    private static List<Object> addChild(JSONArray array) {
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            Object o = array.get(i);
            if (o instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) o;
                Record record = buildJSONObject(jsonObject);
                result.add(record);
            } else if (o instanceof JSONArray) {
                addChild((JSONArray) o);
            } else {
                result.add(o);

            }
        }
        return result;
    }
}
