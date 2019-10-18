package com.zhr.selfstudy.xml;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Map;
import java.util.Set;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName JsonToXmlUtil
 * @Date 2019-10-17 15:46
 * dom4j和gson 实现json转为xml
 **/
public class JsonToXmlUtil {


    public static void main(String[] args) {
        String jsonStr = "{" +
                "\"INFO\": {" +
                "\"RET_CODE\": \"0000\"" +
                "}," +
                "\"QTRANSRSP\": {" +
                "\"QTDETAIL\": [{" +
                "\"BATCHID\": \"200604000007479-0001571023744921\"" +
                "}, {" +
                "\"BATCHID\": \"200604000007479-0001571023744921\"" +
                "}]" +
                "}" +
                "}";
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("AIPG"); //默认根节点
        Element el;
        try {
            el = JsonToXmlUtil.jsonToXml(jsonStr, root);
            String xml = el.asXML();
            System.out.println("xml = " + xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 将json字符串转换成xml
     *
     * @param json          json字符串
     * @param parentElement xml根节点
     * @throws Exception
     */
    public static Element jsonToXml(String json, Element parentElement) throws Exception {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        Element ee = toXml(jsonObject, parentElement, null);
        return ee;
    }

    /**
     * 将json字符串转换成xml
     *
     * @param jsonElement   待解析json对象元素
     * @param parentElement 上一层xml的dom对象
     * @param name          父节点
     */
    public static Element toXml(JsonElement jsonElement, Element parentElement, String name) {
        if (jsonElement instanceof JsonArray) {
            //是json数据，需继续解析
            JsonArray sonJsonArray = (JsonArray) jsonElement;
            for (int i = 0; i < sonJsonArray.size(); i++) {
                JsonElement arrayElement = sonJsonArray.get(i);
                toXml(arrayElement, parentElement, name);
            }
        } else if (jsonElement instanceof JsonObject) {
            //说明是一个json对象字符串，需要继续解析
            JsonObject sonJsonObject = (JsonObject) jsonElement;
            Element currentElement = null;
            if (name != null) {
                currentElement = parentElement.addElement(name);
            }
            Set<Map.Entry<String, JsonElement>> set = sonJsonObject.entrySet();
            for (Map.Entry<String, JsonElement> s : set) {
                toXml(s.getValue(), currentElement != null ? currentElement : parentElement, s.getKey());
            }
        } else {
            //说明是一个键值对的key,可以作为节点插入了
            addAttribute(parentElement, name, jsonElement.getAsString());
        }
        return parentElement;
    }

    /**
     * @param element 父节点
     * @param name    子节点的名字
     * @param value   子节点的值
     */
    public static void addAttribute(Element element, String name, String value) {
        //增加子节点，并为子节点赋值
        Element el = element.addElement(name);
        el.addText(value);
    }
}
