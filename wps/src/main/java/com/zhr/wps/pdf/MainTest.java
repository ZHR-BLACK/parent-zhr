package com.zhr.wps.pdf;

import com.zhr.wps.pdf.bean.CellText;
import com.zhr.wps.pdf.bean.MakeData;
import com.zhr.wps.pdf.bean.TeamVariable;
import com.zhr.wps.pdf.bean.Text;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jing.zhang31
 * @ClassName Main
 * @description: 生成 pdf文件
 * @date 2023年08月29日
 * @version: 1.0
 */
public class MainTest {

    @Test
    public void test() throws IOException {
        // 读取文件
        String filePath = "/Programdata/pdf/pdfdemo.pdf";
        File file = new File(filePath);

        PDDocument doc = PDDocument.load(file);
        // 导入楷体
        PDFont font = PDType0Font.load(doc, this.getClass().getResourceAsStream(
                "/fonts/STSONG.TTF"));
        // 华文中宋 简体
        PDFont font2 = PDType0Font.load(doc, this.getClass().getResourceAsStream(
                "/fonts/STZHONGS.TTF"));
        int pageIndex = 0;
        PDPage page = doc.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.OVERWRITE, false, false);
        PDRectangle mediaBox = page.getMediaBox();
        float height = mediaBox.getHeight();
        // 初始左上角坐标
        float x = revertPt(56);
        float y = height - revertPt(270);
        float tableHeight = 24;

        TeamVariable teamVariable;
        teamVariable = setFixedPdf(contentStream, font, font2, height);
        contentStream = teamVariable.getStream();

        int errUpdateNum = 5;
        int errAddNum = 7;
        int errDelNum = 6;
        // 有误详细详细
        teamVariable = setErrorPdf(doc, contentStream, font, font2, x, y, tableHeight, pageIndex);
        contentStream = teamVariable.getStream();
        y = teamVariable.getY();
        pageIndex = teamVariable.getPageIndex();
        int ignoreUpdateNum = 1;
        int ignoreAddNum = 0;
        int ignoreDelNum = 1;

        teamVariable = setIgnorePdf(doc, contentStream, font, font2, x, y, tableHeight, pageIndex);
        contentStream = teamVariable.getStream();
        y = teamVariable.getY();
        pageIndex = teamVariable.getPageIndex();

        teamVariable = setDuplicatePdf(doc, contentStream, font, font2, x, y, tableHeight, pageIndex);
        contentStream = teamVariable.getStream();
        contentStream.close();
        doc.save(filePath);
        doc.close();
    }

    private TeamVariable setDuplicatePdf(PDDocument doc, PDPageContentStream contentStream
            , PDFont font, PDFont font2, float x, float y, float tableHeight, Integer pageIndex) throws IOException {
        PdfAddSealTest2 pt = new PdfAddSealTest2();
        pt.writeTextColor(contentStream, font2, 12, revertPt(45), y - revertPt(25), "标准文件重复文本信息：", Color.black);
        // 画表头
        y -= revertPt(80);
        drawTableRow(contentStream, font2, x + revertPt(60), y, tableHeight, true);

        return drawTableAndWriteList(doc, contentStream, font, x + revertPt(60), y, pageIndex, MakeData.makeTextList(), true);
    }

    private TeamVariable drawTableAndWriteList(PDDocument doc, PDPageContentStream contentStream
            , PDFont font, float x, float y, Integer pageIndex, List<Text> textList, boolean isDuplicateModule) throws IOException {
        TeamVariable teamVariable = null;
        for (int i = 0; i < textList.size(); i++) {
            Text text = fillTextBean(textList.get(i));
            if (text.isOriginTextMoreHigher()) {
                y -= revertPt(text.getOriginTotalHeight());
                teamVariable = drawTableAndWrite(contentStream, doc, pageIndex, font, x
                        , y, text.getOriginTotalHeight(), i, text, isDuplicateModule);
            } else {
                y -= revertPt(text.getCompareTotalHeight());
                teamVariable = drawTableAndWrite(contentStream, doc, pageIndex, font, x
                        , y, text.getCompareTotalHeight(), i, text, isDuplicateModule);
            }
            contentStream = teamVariable.getStream();
            y = teamVariable.getY();
            pageIndex = teamVariable.getPageIndex();
        }
        return teamVariable;
    }

    private TeamVariable setIgnorePdf(PDDocument doc, PDPageContentStream contentStream
            , PDFont font, PDFont font2, float x, float y, float tableHeight, Integer pageIndex) throws IOException {
        PdfAddSealTest2 pt = new PdfAddSealTest2();
        pt.writeTextColor(contentStream, font2, 12, revertPt(45), y - revertPt(25), "忽略详细信息： ", Color.black);
        pt.writeTextColor(contentStream, font2, 12, revertPt(45 + 100), y - revertPt(25), "修改(1)", Color.red);
        pt.writeTextColor(contentStream, font2, 12, revertPt(45 + 100 + 50), y - revertPt(25), "增加(0)", Color.blue);
        pt.writeTextColor(contentStream, font2, 12, revertPt(45 + 100 + 50 + 50), y - revertPt(25), "删除(0)", Color.green);

        // 画表头
        y -= revertPt(80);
        drawTableRow(contentStream, font2, x, y, tableHeight, false);

        return drawTableAndWriteList(doc, contentStream, font, x, y, pageIndex, MakeData.makeTextList2(), false);
    }

    private TeamVariable setFixedPdf(PDPageContentStream contentStream, PDFont font, PDFont font2
            , float y) throws IOException {
        PdfAddSealTest2 pt = new PdfAddSealTest2();
        pt.writeTextColor(contentStream, font2, 14, revertPt(300), y - revertPt(67), "b-比对报告", Color.black);

        pt.writeTextColor(contentStream, font2, 12, revertPt(45), y - revertPt(90), "任务名称：", Color.black);
        pt.writeTextColor(contentStream, font, 12, revertPt(45 + 100), y - revertPt(90), "b", Color.black);

        pt.writeTextColor(contentStream, font2, 12, revertPt(45), y - revertPt(110), "创建人：", Color.black);
        pt.writeTextColor(contentStream, font, 12, revertPt(45 + 100), y - revertPt(110), "管理员", Color.black);

        pt.writeTextColor(contentStream, font2, 12, revertPt(45), y - revertPt(130), "创建时间：", Color.black);
        pt.writeTextColor(contentStream, font, 12, revertPt(45 + 100), y - revertPt(130), "2023年08月21日 18时55分", Color.black);

        pt.writeTextColor(contentStream, font2, 12, revertPt(45), y - revertPt(150), "比对结果：", Color.black);
        pt.writeTextColor(contentStream, font, 12, revertPt(45 + 100), y - revertPt(150), "扫描件有误", Color.black);

        pt.writeTextColor(contentStream, font2, 12, revertPt(45), y - revertPt(170), "标准文件名称：", Color.black);
        pt.writeTextColor(contentStream, font, 12, revertPt(45 + 100), y - revertPt(170), "b.jpg", Color.black);

        pt.writeTextColor(contentStream, font2, 12, revertPt(45), y - revertPt(190), "比对文件名称：", Color.black);
        pt.writeTextColor(contentStream, font, 12, revertPt(45 + 100), y - revertPt(190), "aaaaaa.jpg", Color.black);

        pt.writeTextColor(contentStream, font2, 12, revertPt(45), y - revertPt(210), "差异数：", Color.black);
        pt.writeTextColor(contentStream, font, 12, revertPt(45 + 100), y - revertPt(210), "差异总数(19) 忽略总数(2) 有误总数(17)", Color.black);
        return TeamVariable.builder().stream(contentStream).build();
    }

    private TeamVariable setErrorPdf(PDDocument doc, PDPageContentStream contentStream, PDFont font, PDFont font2
            , float x, float y, float tableHeight, Integer pageIndex) throws IOException {
        PdfAddSealTest2 pt = new PdfAddSealTest2();
        pt.writeTextColor(contentStream, font2, 12, revertPt(45), y + revertPt(40), "有误详细信息： ", Color.black);
        pt.writeTextColor(contentStream, font2, 12, revertPt(45 + 100), y + revertPt(40), "修改(5)", Color.red);
        pt.writeTextColor(contentStream, font2, 12, revertPt(45 + 100 + 50), y + revertPt(40), "增加(7)", Color.blue);
        pt.writeTextColor(contentStream, font2, 12, revertPt(45 + 100 + 50 + 50), y + revertPt(40), "删除(6)", Color.green);
        // 画表头
        drawTableRow(contentStream, font2, x, y, tableHeight, false);

        return drawTableAndWriteList(doc, contentStream, font, x, y, pageIndex, MakeData.makeTextList(), false);
    }

    private PDPage addPage(PDDocument doc, Integer pageIndex) {
        // 添加一个A4页面
        PDPage page = new PDPage(PDRectangle.A4);
        doc.addPage(page);
        return doc.getPage(pageIndex);
    }

    private TeamVariable drawTableAndWrite(PDPageContentStream contentStream
            , PDDocument doc
            , Integer pageIndex
            , PDFont font
            , float x, float y, float tableHeight
            , int i, Text text
            , boolean isDuplicateModule) throws IOException {
        if (y < revertPt(56)) {
            // 关闭上一页contentStream
            contentStream.close();
            pageIndex++;
            PDPage page = addPage(doc, pageIndex);

            contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.OVERWRITE, false, false);
            y = page.getMediaBox().getHeight() - revertPt(43) - revertPt(tableHeight);
            drawTableRowText(contentStream, font, x, y, tableHeight, i + 1, text, isDuplicateModule);
        } else {
            drawTableRowText(contentStream, font, x, y, tableHeight, i + 1, text, isDuplicateModule);
        }
        return TeamVariable.builder().stream(contentStream).y(y).pageIndex(pageIndex).build();
    }

    private Text fillTextBean(Text text) {
        CellText cellText = autoLine(text.getOriginText());
        CellText cellText2 = autoLine(text.getCompareText());
        text.setAutoOriginTextList(cellText.getTextList());
        text.setAutoCompareTextList(cellText2.getTextList());
        text.setOriginTotalHeight(cellText.getTotalHeight());
        text.setCompareTotalHeight(cellText2.getTotalHeight());
        text.setOriginTextMoreHigher(cellText.getTotalHeight() >= cellText2.getTotalHeight());
        return text;
    }

    private void drawTableRowText(PDPageContentStream contentStream, PDFont font, float x
            , float y, float height, int index, Text text, boolean isDuplicateModule) throws IOException {
        PdfAddSealTest2 pt = new PdfAddSealTest2();
        int fontSize = 10;
        // 第一个表格
        pt.drawTable(contentStream, x, y, revertPt(43), revertPt(height));
        pt.writeText2(contentStream, font, fontSize, x + revertPt(17), y + revertPt(height - fontSize) / 2, Collections.singletonList(String.valueOf(index)));
        // 第二个表格
        x += revertPt(43);
        pt.drawTable(contentStream, x, y, revertPt(43), revertPt(height));
        pt.writeText2(contentStream, font, fontSize, x + revertPt(17), y + revertPt(height - fontSize) / 2, Collections.singletonList(String.valueOf(text.getPageIndex())));

        // 第三个表格
        x += revertPt(43);
        pt.drawTable(contentStream, x, y, revertPt(190), revertPt(height));
        pt.writeText2(contentStream, font, fontSize, x + revertPt(8), y + revertPt(height - 14), text.getAutoOriginTextList());

        // 第四个表格
        x += revertPt(190);
        pt.drawTable(contentStream, x, y, revertPt(190), revertPt(height));
        pt.writeText2(contentStream, font, fontSize, x + revertPt(8), y + revertPt(height - 14), text.getAutoCompareTextList());

        if (!isDuplicateModule) {
            // 第五个表格
            x += revertPt(190);
            pt.drawTable(contentStream, x, y, revertPt(131), revertPt(height));
            pt.writeText2(contentStream, font, fontSize, x + revertPt(37), y + revertPt(height - fontSize) / 2, Collections.singletonList(text.getDiffType()));
        }
    }

    private void drawTableRow(PDPageContentStream contentStream, PDFont font, float x, float y, float height, boolean isDuplicateModule) throws IOException {
        PdfAddSealTest2 pt = new PdfAddSealTest2();
        int fontSize = 10;
        // 第一个表格
        pt.drawTable(contentStream, x, y, revertPt(43), revertPt(height));
        pt.writeText(contentStream, font, fontSize, x + revertPt(7), y + revertPt(8), "序号");
        // 第二个表格
        x += revertPt(43);
        pt.drawTable(contentStream, x, y, revertPt(43), revertPt(height));
        pt.writeText(contentStream, font, fontSize, x + revertPt(7), y + revertPt(8), "页码");

        // 第三个表格
        x += revertPt(43);
        pt.drawTable(contentStream, x, y, revertPt(190), revertPt(height));
        pt.writeText(contentStream, font, fontSize, x + revertPt(49), y + revertPt(8), "标准文件内容");

        // 第四个表格
        x += revertPt(190);
        pt.drawTable(contentStream, x, y, revertPt(190), revertPt(height));
        pt.writeText(contentStream, font, fontSize, x + revertPt(49), y + revertPt(8), "比对文件内容");
        if (!isDuplicateModule) {
            // 第五个表格
            x += revertPt(190);
            pt.drawTable(contentStream, x, y, revertPt(131), revertPt(height));
            pt.writeText(contentStream, font, fontSize, x + revertPt(37), y + revertPt(8), "差异类型");
        }
    }

    private CellText autoLine(String text) {
        List<String> list = new ArrayList<>();
        int appointRow = 100;
        int maxWidth = 15;
        list = SubstrUtil2.autoLineByMaxWidth(text, maxWidth, appointRow, list);
        // 兜底最后一行
        int length = text.length();
        if (length > SubstrUtil2.index) {
            list.add(text.substring(SubstrUtil2.index));
        }
        int height = 3;
        int fontSize = 12;
        // 总高度 = 总行高 + 总文字高度 + 修正值
        int totalHeight = (list.size() + 1) * height + (fontSize * list.size()) + 6;
        SubstrUtil2.index = 0;
        return CellText.builder().textList(list).totalHeight(totalHeight).build();
    }

    private float revertPt(float pt) {
        return (float) (pt / 1.25);
    }

}
