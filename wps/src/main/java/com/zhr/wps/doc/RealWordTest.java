package com.zhr.wps.doc;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成docx文件
 */
@Slf4j
public class RealWordTest {

    @Test
    public void test() {
        String filePath = "/Programdata/doc/toolWord.docx";
        // 1.创建一个新的Word文档
        XWPFDocument document = new XWPFDocument();
        FileOutputStream fos = null;
        document.createParagraph().createRun().setText("b-比对报告");

        XWPFParagraph paragraph = document.createParagraph();
        paragraph.createRun().setText(String.format("%1$-9s", "任务名称："));
        paragraph.createRun().setText("b");

        XWPFParagraph paragraph2 = document.createParagraph();
        paragraph2.createRun().setText(String.format("%1$-10s", "创建人："));
        paragraph2.createRun().setText("管理员");

        XWPFParagraph paragraph21 = document.createParagraph();
        paragraph21.createRun().setText(String.format("%1$-9s", "创建时间："));
        paragraph21.createRun().setText("2023年08月21日 18时55分");

        XWPFParagraph paragraph22 = document.createParagraph();
        paragraph22.createRun().setText(String.format("%1$-9s", "比对结果："));
        paragraph22.createRun().setText("扫描件有误");

        XWPFParagraph paragraph3 = document.createParagraph();
        paragraph3.createRun().setText("标准文件名称：");
        paragraph3.createRun().setText("b.jpg");

        XWPFParagraph paragraph4 = document.createParagraph();
        paragraph4.createRun().setText("比对文件名称：");
        paragraph4.createRun().setText("aaaaaa.jpg");

        XWPFParagraph paragraph5 = document.createParagraph();
        paragraph5.createRun().setText(String.format("%1$-10s", "差异数："));
        // 数字读取
        int totalErrorNum = 18;
        int ignoreNum = 2;
        int errorNum = 16;
        int duplicateNum = 30;
        paragraph5.createRun().setText("差异总数(" + totalErrorNum + ")   忽略总数(" + ignoreNum + ")   有误总数(" + errorNum + ")");
        // 设置固定文本的格式
        setFixedParagraphsFont(document);

        // 设置有误详细信息模块
        setErrorText(document);
        setIgnoreText(document);
        // 设置标准文件重复文本信息模块
        setDuplicateText(document);
        try {
            // 输出流，用于将文档写入磁盘
            fos = new FileOutputStream(filePath);
            // 将文档写入输出流
            document.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    // 关闭输出流
                    fos.close();
                    // 关闭 Word文档
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("Word文档生成成功！");
    }

    private void setErrorText(XWPFDocument document) {
        // 换行
        document.createParagraph();

        XWPFParagraph paragraph6 = document.createParagraph();
        int modifyCount = 4;
        int addCount = 6;
        int delCount = 6;
        paragraph6.createRun().setText("有误详细信息：");
        paragraph6.createRun().setText("修改(" + modifyCount + ")  ");
        paragraph6.createRun().setText("增加(" + addCount + ")  ");
        paragraph6.createRun().setText("删除(" + delCount + ")");

        setNotFixedParagraphsFont(document);
        // 换行
        document.createParagraph();

        // 2.创建一个新的表格，15行5列
        XWPFTable table = document.createTable(modifyCount + addCount + delCount + 1, 5);
        // 3.设置表格样式
        XWPFTableCell cell;
        table.getCTTbl().addNewTblPr().addNewTblStyle().setVal("Table Grid");
        for (int i = 0; i < 5; i++) {
            cell = table.getRow(0).getCell(i);
            cell.setText(getTableTitleText(i));
            // 粗体
            cell.getParagraphs().get(0).getRuns().get(0).setBold(true);
            // 字号
            cell.getParagraphs().get(0).getRuns().get(0).setFontSize(11);
            // 字体
            cell.getParagraphs().get(0).getRuns().get(0).setFontFamily("宋体");
            cell.setWidth(String.valueOf(getWidthByCol(i)));
            // 设置单元格内容垂直靠上
            cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.TOP);
            // 设置单元格内容水平向左(获取单元格中的第一个段落对象)
            cell.getParagraphArray(0).setAlignment(ParagraphAlignment.CENTER);
        }
        // 4.填充表格内容

        for (int row = 1; row < modifyCount + addCount + delCount + 1; row++) { // 循环遍历表格的行
            for (int col = 0; col < 5; col++) { // 循环遍历表格的列
                // 获取当前单元格
                cell = table.getRow(row).getCell(col);
                // 设置单元格内容垂直靠上
                cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.TOP);
                // 设置单元格内容水平向左(获取单元格中的第一个段落对象)
                cell.getParagraphArray(0).setAlignment(ParagraphAlignment.LEFT);
                cell.setWidth(String.valueOf(getWidthByCol(col)));
                // 设置单元格内容
                if (col == 2 || col == 3) {
                    // 读取文本
                    String text = "今年以<span class='e1'>来,</span>各<span class='e2'>地区</span>各部门接连出台政asdasf<span class='e3'>赛U币风水宝地办公</span>室的，策措施支持广大经营";
                    List<TextMsg> textMsgs = splitTextAndSetRun(cell.getParagraphs().get(0), text);
                    if (CollectionUtils.isNotEmpty(textMsgs)) {
                        // 根据span标签中class值设置文本颜色
                        setRunsFontColor(cell.getParagraphs().get(0).getRuns(), textMsgs);
                    }
                } else {
                    cell.setText(String.valueOf(row));
                }
                setRunsFont(cell.getParagraphs().get(0).getRuns());
            }
        }
    }

    private void setIgnoreText(XWPFDocument document) {
        // 换行
        document.createParagraph();

        XWPFParagraph paragraph6 = document.createParagraph();
        int modifyCount = 1;
        int addCount = 1;
        int delCount = 0;
        paragraph6.createRun().setText("忽略详细信息：");
        paragraph6.createRun().setText("修改(" + modifyCount + ")  ");
        paragraph6.createRun().setText("增加(" + addCount + ")  ");
        paragraph6.createRun().setText("删除(" + delCount + ")");

        setNotFixedParagraphsFont(document);
        // 换行
        document.createParagraph();

        // 2.创建一个新的表格，15行5列
        XWPFTable table = document.createTable(modifyCount + addCount + delCount + 1, 5);
        // 3.设置表格样式
        table.getCTTbl().addNewTblPr().addNewTblStyle().setVal("Table Grid");
        for (int i = 0; i < 5; i++) {
            XWPFTableCell cell = table.getRow(0).getCell(i);
            cell.setText(getTableTitleText(i));
            // 粗体
            cell.getParagraphs().get(0).getRuns().get(0).setBold(true);
            // 字号
            cell.getParagraphs().get(0).getRuns().get(0).setFontSize(11);
            // 字体
            cell.getParagraphs().get(0).getRuns().get(0).setFontFamily("宋体");
            cell.setWidth(String.valueOf(getWidthByCol(i)));
            // 设置单元格内容垂直靠上
            cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.TOP);
            // 设置单元格内容水平向左(获取单元格中的第一个段落对象)
            cell.getParagraphArray(0).setAlignment(ParagraphAlignment.CENTER);
        }
        // 4.填充表格内容
        XWPFTableCell cell;
        for (int row = 1; row < modifyCount + addCount + delCount + 1; row++) { // 循环遍历表格的行
            for (int col = 0; col < 5; col++) { // 循环遍历表格的列
                // 获取当前单元格
                cell = table.getRow(row).getCell(col);
                // 设置单元格内容垂直靠上
                cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.TOP);
                // 设置单元格内容水平向左(获取单元格中的第一个段落对象)
                cell.getParagraphArray(0).setAlignment(ParagraphAlignment.LEFT);
                cell.setWidth(String.valueOf(getWidthByCol(col)));
                // 设置单元格内容
                if (col == 2 || col == 3) {
                    // 读取文本
                    String text = "今年以<span class='e1'>来,</span>各<span class='e2'>地区</span>各部门接连出台政asdasf<span class='e3'>赛U币风水宝地办公</span>室的，策措施支持广大经营";
                    List<TextMsg> textMsgs = splitTextAndSetRun(cell.getParagraphs().get(0), text);
                    if (CollectionUtils.isNotEmpty(textMsgs)) {
                        // 根据span标签中class值设置文本颜色
                        setRunsFontColor(cell.getParagraphs().get(0).getRuns(), textMsgs);
                    }
                } else {
                    cell.setText(String.valueOf(row));
                }
                setRunsFont(cell.getParagraphs().get(0).getRuns());
            }
        }
    }


    private void setDuplicateText(XWPFDocument document) {
        // 换行
        document.createParagraph();

        XWPFParagraph paragraph = document.createParagraph();
        paragraph.createRun().setText("标准文件重复文本信息：");
        int duplicateNum = 10;
        // 换行
        document.createParagraph();

        setNotFixedParagraphsFont(document);

        // 2.创建一个新的表格，15行5列
        XWPFTable table = document.createTable(duplicateNum + 1, 4);
        // 3.设置表格样式
        table.getCTTbl().addNewTblPr().addNewTblStyle().setVal("Table Grid");
        for (int i = 0; i < 4; i++) {
            XWPFTableCell cell = table.getRow(0).getCell(i);
            cell.setText(getTableTitleText(i));
            // 粗体
            cell.getParagraphs().get(0).getRuns().get(0).setBold(true);
            // 字号
            cell.getParagraphs().get(0).getRuns().get(0).setFontSize(11);
            // 字体
            cell.getParagraphs().get(0).getRuns().get(0).setFontFamily("宋体");
            cell.setWidth(String.valueOf(getWidthByCol(i)));
            // 设置单元格内容垂直靠上
            cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.TOP);
            // 设置单元格内容水平向左(获取单元格中的第一个段落对象)
            cell.getParagraphArray(0).setAlignment(ParagraphAlignment.CENTER);
        }
        // 4.填充表格内容
        XWPFTableCell cell;
        for (int row = 1; row < duplicateNum + 1; row++) { // 循环遍历表格的行
            for (int col = 0; col < 4; col++) { // 循环遍历表格的列
                // 获取当前单元格
                cell = table.getRow(row).getCell(col);
                // 设置单元格内容垂直靠上
                cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.TOP);
                // 设置单元格内容水平向左(获取单元格中的第一个段落对象)
                cell.getParagraphArray(0).setAlignment(ParagraphAlignment.LEFT);
                cell.setWidth(String.valueOf(getWidthByCol(col)));
                // 设置单元格内容
                if (col == 2 || col == 3) {
                    // 读取文本
                    String text = "今年以<span class='e1'>来,</span>各<span class='e2'>地区</span>各部门接连出台政asdasf<span class='e3'>赛U币风水宝地办公</span>室的，策措施支持广大经营";
                    List<TextMsg> textMsgs = splitTextAndSetRun(cell.getParagraphs().get(0), text);
                    if (CollectionUtils.isNotEmpty(textMsgs)) {
                        // 根据span标签中class值设置文本颜色
                        setRunsFontColor(cell.getParagraphs().get(0).getRuns(), textMsgs);
                    }
                } else {
                    cell.setText(String.valueOf(row));
                }
                setRunsFont(cell.getParagraphs().get(0).getRuns());
            }
        }
    }

    private List<TextMsg> splitTextAndSetRun(XWPFParagraph xwpfParagraph, String text) {
        if (StrUtil.hasBlank(text) || !text.contains("span")) {
            return new ArrayList<>();
        }
        Document document = Jsoup.parse(text);
        List<TextMsg> textMsgList = new ArrayList<>();
        Elements paragraphs = document.getElementsByTag("span");
        int index = 0;
        for (Element paragraph : paragraphs) {
            TextMsg tm = new TextMsg(index++, paragraph.text(), paragraph.className(), 0);
            textMsgList.add(tm);
        }
        index = 0;
        List<Node> nodes = document.body().childNodes();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).toString().contains("<span")) {
                TextMsg textMsg = textMsgList.get(index++);
                // 设置不同的run
                xwpfParagraph.createRun().setText(textMsg.getText());
                // 设置当前span标签在整个字符串根据span标签拆分后的index
                textMsg.setSpanIndex(i);
            } else {
                xwpfParagraph.createRun().setText(nodes.get(i).toString());
            }
        }
        return textMsgList;
    }

    private void setNotFixedParagraphsFont(XWPFDocument document) {
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        log.info("paragraphs = " + paragraphs.size());
        for (int i = 6; i < paragraphs.size(); i++) {
            List<XWPFRun> runs = document.getParagraphs().get(i).getRuns();
            if (!runs.isEmpty()) {
                setParagraphFont(runs);
                // 遍历找到 有误详细信息或忽略详细信息 段落 进行处理
                if (runs.get(0).getText(0).startsWith("有误详细信息")
                        || runs.get(0).getText(0).startsWith("忽略详细信息")) {
                    runs.get(1).setColor("FF0000");
                    runs.get(1).setBold(true);
                    runs.get(2).setColor("0000FF");
                    runs.get(2).setBold(true);
                    runs.get(3).setColor("008000");
                    runs.get(3).setBold(true);
                }
            }

        }
    }

    private void setFixedParagraphsFont(XWPFDocument document) {
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (int i = 0; i < paragraphs.size(); i++) {
            List<XWPFRun> runs = document.getParagraphs().get(i).getRuns();
            if (i == 0) {
                // 标题设置
                runs.get(0).setFontSize(15);
                runs.get(0).setBold(true);
                runs.get(0).setFontFamily("宋体");
                document.getParagraphs().get(i).setAlignment(ParagraphAlignment.CENTER);
            } else {
                // 至少有两个run
                if (runs.size() > 1) {
                    setParagraphFont(runs);
                }
            }
        }
    }

    private void setParagraphFont(List<XWPFRun> runs) {
        runs.get(0).setFontSize(12);
        runs.get(0).setFontFamily("宋体");
        runs.get(0).setBold(true);
        for (int j = 1; j < runs.size(); j++) {
            runs.get(j).setFontFamily("宋体");
            runs.get(j).setFontSize(12);
        }
    }

    private void setRunsFontColor(List<XWPFRun> list, List<TextMsg> textMsgList) {
        for (int i = 0; i < list.size(); i++) {
            for (TextMsg textMsg : textMsgList) {
                if (i == textMsg.getSpanIndex()) {
                    // 设置文字颜色
                    if ("e1".equals(textMsg.getClassVal())) {
                        list.get(i).setColor("FF0000");
                    } else if ("e2".equals(textMsg.getClassVal())) {
                        list.get(i).setColor("0000FF");
                    } else if ("e3".equals(textMsg.getClassVal())) {
                        list.get(i).setColor("008000");
                    }
                }
            }
        }
    }

    private void setRunsFont(List<XWPFRun> list) {
        list.forEach(item -> {
            item.setFontFamily("宋体");
            item.setFontSize(12);
        });
    }

    private String getTableTitleText(int col) {
        String title = "";
        switch (col) {
            case 0:
                title = "序号";
                break;
            case 1:
                title = "页码";
                break;
            case 2:
                title = "标准文件内容";
                break;
            case 3:
                title = "比对文件内容";
                break;
            case 4:
                title = "差异类型";
                break;
            default:
                break;
        }
        return title;
    }

    private int getWidthByCol(int col) {
        if (col == 0 || col == 1) {
            return 800;
        } else if (col == 2 || col == 3) {
            return 2899;
        }
        return 1600;
    }

}
