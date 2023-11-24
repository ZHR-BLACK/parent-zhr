package com.zhr.wps.pdf;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfAddSealTest2 {

    @Test
    public void addSealTest() {
        addSeal("D:\\Programdata\\selfpdf/first1.pdf",
                "D:\\Programdata\\selfpdf/first1.pdf",
                "中国", "文书", "2020", "办公室", "30年", "numb");
    }

    public boolean addSeal(String inPath, String outPath, String qz, String lb, String year, String dep, String deadline, String numb) {
        try {
            // 读取文件
            File file = new File(inPath);
            if (!file.exists()) {
                System.out.println("找不到文件：" + inPath);
            }
            // 文件夹不存在新建文件夹
            String outDir = outPath.substring(0, outPath.lastIndexOf("/"));
            File outDirFile = new File(outDir);
            if (!outDirFile.exists()) {
                outDirFile.mkdirs();
                System.out.println("归档章，新建文件夹成功：" + outDir);
            }

            PDDocument doc = PDDocument.load(file);
            // 导入楷体
            PDFont font = PDType0Font.load(doc, this.getClass().getResourceAsStream(
                    "/fonts/STSONG.TTF"));

            PDPage page = doc.getPage(0);
            PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, false, false);
            float width = page.getMediaBox().getWidth();
            float height = page.getMediaBox().getLowerLeftY() + page.getMediaBox().getHeight();

            // 表格起始x,y坐标;印章距离右上角各5mm
            float x = width - countMM(95);
            float y = height - countMM(12);
            // 所有表格高度mm转point
            float allTableheight1 = countMM(8);
            float allTableheight2 = countMM(8);
            // 上层左起第一个表格
            float topOneTableWidth = countMM(75);// 宽度

            // 上层左起第二个表格
            float topTwoTableWidth = countMM(15);
            float topTwoTableX = x + topOneTableWidth;

            float bottomTableY = y - allTableheight2;
            // 下层左起第一个表格
            float bottomOneTableWidth = countMM(11);

            // 下层左起第二个表格
            float bottomTwoTableWidth = countMM(53);
            float bottomTwoTableX = x + bottomOneTableWidth;

            float bottomThreeTableWidth = countMM(11);
            float bottomThreeTableX = bottomTwoTableX + bottomTwoTableWidth;

            float bottomFourTableWidth = countMM(15);
            float bottomFourTableX = bottomThreeTableX + bottomThreeTableWidth;

            // 画表格
            drawTable(contentStream, x, y, topOneTableWidth, allTableheight1);
            drawTable(contentStream, topTwoTableX, y, topTwoTableWidth, allTableheight1);
            drawTable(contentStream, x, bottomTableY, bottomOneTableWidth, allTableheight2);
            drawTable(contentStream, bottomTwoTableX, bottomTableY, bottomTwoTableWidth, allTableheight2);
            drawTable(contentStream, bottomThreeTableX, bottomTableY, bottomThreeTableWidth, allTableheight2);
            drawTable(contentStream, bottomFourTableX, bottomTableY, bottomFourTableWidth, allTableheight2);

            // 文字上移2毫米,居中
            float move2mm = countMM(3);
            int fontSize = 12;

            writeText(contentStream, font, fontSize, x + countMM(1), y + move2mm, qz);
            writeText(contentStream, font, fontSize, topTwoTableX + countMM(1), y + move2mm, lb);
            writeText(contentStream, font, fontSize, x + countMM(1), bottomTableY + countMM(3), year);
            if (dep.length() > 12) {
                int length1 = dep.length();
                if (length1 > 18) {
                    length1 = 18;
                    String str1 = dep.substring(0, length1);
                    writeText(contentStream, font, 8, bottomTwoTableX + countMM(1), bottomTableY + countMM(4), str1);
                    String str2 = dep.substring(18);
                    writeText(contentStream, font, 8, bottomTwoTableX + countMM(1), bottomTableY + countMM(1), str2);
                } else {
                    String str1 = dep.substring(0, length1);
                    writeText(contentStream, font, 8, bottomTwoTableX + countMM(1), bottomTableY + countMM(4), str1);
                }
            } else {
                writeText(contentStream, font, fontSize, bottomTwoTableX + countMM(1), bottomTableY + countMM(3), dep);
            }
            writeText(contentStream, font, fontSize, bottomThreeTableX + countMM(1), bottomTableY + countMM(3), deadline);
            writeText(contentStream, font, fontSize, bottomFourTableX + countMM(1), bottomTableY + countMM(3), numb);
            contentStream.close();
            doc.save(outPath);
            doc.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 画表格，通过画线段来画出表格
     *
     * @param contentStream
     * @param x             横坐标
     * @param y             纵坐标
     * @param tableWidth    表格宽度
     * @param tableHeight   表格高度
     */
    public void drawTable(PDPageContentStream contentStream, float x, float y, float tableWidth, float tableHeight) {
        // 画笔颜色
        // contentStream.setStrokingColor(Color.black);
        drawLine(contentStream, x, y, x, y + tableHeight);
        drawLine(contentStream, x, y + tableHeight, x + tableWidth, y + tableHeight);
        drawLine(contentStream, x + tableWidth, y + tableHeight, x + tableWidth, y);
        drawLine(contentStream, x + tableWidth, y, x, y);
    }

    /**
     * 画线段
     *
     * @param contentStream
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    private void drawLine(PDPageContentStream contentStream, float startX, float startY, float endX, float endY) {
        try {
            contentStream.moveTo(startX, startY);
            contentStream.lineTo(endX, endY);
            contentStream.stroke();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private float countMM(float point) {
        return (float) (point * 72 / 25.4);
    }

    /**
     * 添加文字
     *
     * @param contentStream
     * @param font          字体
     * @param fontSize      字体大小
     * @param startX        起始横坐标
     * @param startY        起始纵坐标
     * @param txt           文本
     * @throws IOException
     */
    public void writeText(PDPageContentStream contentStream, PDFont font, float fontSize, float startX, float startY, String txt) throws IOException {
        if (StrUtil.hasBlank(txt)) {
            return;
        }
        contentStream.beginText();
        // 文字位置
        contentStream.newLineAtOffset(startX, startY);

        // 设置字体type,size
        contentStream.setFont(font, fontSize);

        contentStream.setNonStrokingColor(Color.black);
        // TODO 插入文本,此处要考虑文本换行
        contentStream.showText(txt);

        contentStream.endText();
    }

    public void writeTextColor(PDPageContentStream contentStream, PDFont font, float fontSize, float startX, float startY, String txt,Color color) throws IOException {
        if (StrUtil.hasBlank(txt)) {
            return;
        }
        contentStream.beginText();
        // 文字位置
        contentStream.newLineAtOffset(startX, startY);
        // 设置字体type,size

        contentStream.setFont(font, fontSize);

        contentStream.setNonStrokingColor(color);
        contentStream.showText(txt);
        contentStream.endText();
    }

    public void writeText2(PDPageContentStream contentStream, PDFont font, float fontSize, float startX, float startY, List<String> txtList) throws IOException {
        if (CollectionUtils.isEmpty(txtList)) {
            return;
        }
        contentStream.beginText();
        // 文字位置
        contentStream.newLineAtOffset(startX, startY);
        // 设置字体type,size
        contentStream.setFont(font, fontSize);
        contentStream.setLeading(12);

        contentStream.setNonStrokingColor(Color.black);
        // TODO 插入文本,此处要考虑文本换行
        for (String s : txtList) {
            contentStream.showText(s);
            contentStream.newLine();
        }
        contentStream.endText();
    }
}
