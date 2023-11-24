package com.zhr.wps.pdf.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jing.zhang31
 * @ClassName MakeData
 * @description: 生成测试数据
 * @date 2023年09月01日
 * @version: 1.0
 */
public class MakeData {

    public static List<Text> makeTextList() {
        List<Text> textList = new ArrayList<>();
        Text text1 = Text.builder().pageIndex(1).originText("广告制作安装合同甲方:广安斜" +
                        "技有限么司(以下简称甲方)乙" +
                        "方:个接中厂0区打发(以下简称" +
                        "乙方)甲乙双方为明确各自的权" +
                        "利和义务，经友好协商，根据" +
                        "《中华人民共和国合同法》、" +
                        "《中华人民共和国广告法》和" +
                        "《建筑安装工程承包合同条例" +
                        "》<span class='e1'>及其他法律、法规之规定" +
                        "，现就乙方</span>承揽广告牌(以下简" +
                        "称广告牌)的制作安装事宜达成" +
                        "如下一致协议。一、广告牌制" +
                        "作广告牌规格、材质:(详见附" +
                        "件)二、广告牌<span class='e2'>安装安装地点" +
                        ":厂区三、支付方式1、广告牌" +
                        "制作费(即合</span>同总价款):共计人" +
                        "民币[2189、88_元。2、支付方" +
                        "式:制作安装完成后，经甲方验" +
                        "收合格，即付清所有款项")
                .compareText("低俗本公司独个半死固定归属感，少年队干部苏北沟IU说不过IU的观点是不爱的是吧")
                .diffType("文字删除").build();

        Text text2 = Text.builder().pageIndex(3).compareText("广告制作安装合同甲方:广安斜" +
                        "技有限么司(以下简称甲方)乙" +
                        "方:个接中厂0区打发(以下简称" +
                        "乙方)甲乙双方为明确各自的权" +
                        "利和义务，经友好协商，根据" +
                        "《中华人民共和国合同法》、" +
                        "《中华人民共和国广告法》和" +
                        "《建<span class='e2'>筑安装工程承包合同条例" +
                        "》及其他法律、法规</span>之规定" +
                        "，现就乙方承揽广告牌(以下简" +
                        "称广告牌)的制作安装事宜达成" +
                        "如下一致协议。一、广告牌制" +
                        "作广告牌规格、材质:(详见附" +
                        "件)二、广告牌安装安装地点" +
                        ":厂区三、支付方式1、广告牌" +
                        "制作费(即合同总价款):共计人" +
                        "民币[2189、88_元。2、支付方" +
                        "式:制作安装完成后，经甲方验" +
                        "收合格，即付清所有款项")
                .originText("低俗本公司独个半死固定归属感，少年队干部苏北沟IU说不过IU的观点是不爱的是吧")
                .diffType("文字添加").build();
        textList.add(text1);
        textList.add(text1);
        textList.add(text1);
        textList.add(text2);
        textList.add(text2);
        textList.add(text1);
        textList.add(text2);
        return textList;
    }

    public static List<Text> makeTextList2() {
        List<Text> textList = new ArrayList<>();
        Text text1 = Text.builder().pageIndex(1).originText("2.背景介绍")
                .compareText("2.背景")
                .diffType("文字删除").build();

        Text text2 = Text.builder().pageIndex(3).compareText("C A M C N N 特征可视化技术之C A M ,在文章末尾提到了C A M")
                .originText("C A M C N N 特征可视化技术之C A M ,在文章末尾提到了C A M")
                .diffType("文字修改").build();
        textList.add(text1);
        textList.add(text2);
        return textList;
    }
}
