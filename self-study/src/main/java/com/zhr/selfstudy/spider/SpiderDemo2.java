package com.zhr.selfstudy.spider;

import cn.hutool.core.util.XmlUtil;
import com.alibaba.fastjson.JSON;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import java.io.IOException;

/**
 * @author zhangjing710
 * @description 爬虫2
 * @date 2022/3/7 6:00 下午
 */
public class SpiderDemo2 {

    public static void main(String[] args) throws Exception {
        String url = "https://top.baidu.com/buzz?b=1&fr=topindex";
        String exp = "//*[@id=\"sanRoot\"]/main/div[2]/div/div[2]/div";

        String html = null;
        try {
            Connection connect = Jsoup.connect(url);
            html = connect.get().body().html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HtmlCleaner hc = new HtmlCleaner();
        TagNode tn = hc.clean(html);
        Document dom = new DomSerializer(new CleanerProperties()).createDOM(tn);
//        XPath xPath = XPathFactory.newInstance().newXPath();
        Object result;
//        result = xPath.evaluate(exp, dom, XPathConstants.NODESET);
        result = XmlUtil.getByXPath(exp, dom, XPathConstants.NODESET);
        if (result instanceof NodeList) {
            NodeList nodeList = (NodeList) result;
            System.out.println(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                /**
                 * Node.getTextContent() 此属性返回此节点及其后代的文本内容。
                 * Node.getFirstChild()  此节点的第一个子节点。
                 * Node.getAttributes() 包含此节点的属性的 NamedNodeMap（如果它是 Element）；否则为 null
                 * 如果想获取相应对象的相关属性，可以调用  getAttributes().getNamedItem("属性名") 方法
                 */
                System.out.println("node = " + JSON.toJSONString(node));
//                System.out.println("node2 = " + JSON.toJSONString(node.getChildNodes()));
//                NodeList childNodes = node.getChildNodes();
//                for (int j = 0; j < childNodes.getLength(); j++) {
//                System.out.println("node2 = " + JSON.toJSONString(childNodes.item(3)));
//                System.out.println("node2 = " + JSON.toJSONString(childNodes.item(3).getChildNodes().item(3).getTextContent().trim()));


//                System.out.println("node2 = " + JSON.toJSONString(childNodes.item(7).getChildNodes().item(1).getChildNodes().item(1).getTextContent().trim()));
//                }
//                Document ownerDocument = node.getOwnerDocument();
                // 如果想匹配当前路径div下的东西，前面要加"."
                String exp2 = ".//div[2]/a/div[1]/text()";
//                Object result2 = xPath.evaluate(exp2, node, XPathConstants.STRING);
                Object result2 = XmlUtil.getByXPath(exp2, node, XPathConstants.STRING);
                System.out.println("result2 = " + String.valueOf(result2).trim());

//                System.out.println("node = " + node.getNodeValue().trim());
            }
        }
    }
}
