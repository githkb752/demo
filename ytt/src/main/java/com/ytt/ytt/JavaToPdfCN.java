package com.ytt.ytt;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JavaToPdfCN {
    private static final String DEST = "ytt/target/HelloWorld_CN.pdf";
    private static final String FONT = "simhei.ttf";


    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        Font f1 = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        document.add(new Paragraph("hello world,我是鲁家宁", f1));
        document.close();
        writer.close();
    }
}
