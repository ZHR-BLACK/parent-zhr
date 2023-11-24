package com.zhr.wps.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.Test;

import java.io.IOException;

public class PdfTest {

    public static final String pdfName = "pdfdemo.pdf";

    @Test
    public void createPdf() throws IOException {
        PDDocument document = new PDDocument();
        // 添加页面
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        document.save("/Programdata/pdf\\" + pdfName);

        document.close();
    }


}
