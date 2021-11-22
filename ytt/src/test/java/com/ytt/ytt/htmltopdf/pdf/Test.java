package com.ytt.ytt.htmltopdf.pdf;

import java.io.File;

public class Test {
    private File exportPDF(String fileName, String url, String outFileName) {
        String exePath;
        String param;
        String filePath;
        String os = System.getProperty("os.name");//获取当前操作系统名称
        if (os.toLowerCase().startsWith("win")) {//如果是windows系统
            exePath = "D:/wkhtmltopdf/bin/wkhtmltopdf.exe";
            param = "--page-size A4 --page-height 297 --page-width 210 --javascript-delay 1000 --no-stop-slow-scripts --load-error-handling ignore";
            filePath = System.getProperty("java.io.tmpdir") + File.separator;
        } else {
            exePath = "/app/tomcat/wkhtmltopdf/bin/wkhtmltopdf";
            param = "--page-size A4 --page-height 297 --page-width 210 --javascript-delay 1000 --no-stop-slow-scripts --load-error-handling ignore";
            filePath = "/app/tomcat/sendfile/";
        }
        return null;

    }

    public static void main(String[] args) {
        StringBuilder cmd = new StringBuilder();
        cmd.append("D:/wkhtmltopdf/bin/wkhtmltopdf.exe");//wkhtmltopdf程序所在位置
        cmd.append(" ");
        cmd.append("--page-size A2");// 参数
        cmd.append(" ");
        cmd.append("https://123.sogou.com https://123.sogou.com https://123.sogou.com");//可多个
        cmd.append(" ");
        cmd.append("D:/pdf_test.pdf");//保存路径
        WKLin wu = new WKLin();
        wu.winExec(cmd.toString());
    }
}