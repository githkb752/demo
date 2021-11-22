package com.ytt.ytt.htmltopdf;

import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class HtmlToPdf {

    public static void main(String[] args) {
        createPDF("C:\\Users\\Administrator\\Desktop\\redown.pdf","C:\\Users\\Administrator\\Desktop\\springboot 将html页面导出成pdf格式_百度搜索.html");

    }

    private static void createPDF(String fileName , String html)  {
        OutputStream os = null;
        try {
            os = new FileOutputStream(fileName);
            ITextRenderer renderer = new ITextRenderer();

            ITextFontResolver fontResolver = renderer.getFontResolver();
            //指定字体。为了支持中文字体
            fontResolver.addFont("templates/website/pz/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            String content = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"></meta><style type=\"text/css\">     body { font-family: SimSun; }</style>  </head><body>" + html + "</body></html>";
            renderer.setDocumentFromString(content);
            renderer.layout();
            renderer.createPDF(os);
            renderer.finishPDF();
            renderer = null;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                if(os!=null)
                    os.close();
            }catch (Exception ex1){
                ex1.printStackTrace();
            }
        }
    }
}
