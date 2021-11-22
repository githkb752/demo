package com.ytt.ytt.pdf.puppeter;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 *
 * @author zx
 * @date 2020/8/5
 * 用谷歌提供的node实现的Puppeteer，实现网页截图及把网页生成pdf文件采
 */
public class PuppeteerHtmlToPdf {
    /**
     * html转pdf,直接通过流输出到浏览器
     * @param response 浏览器响应
     * @param fileName 文件名称
     * @param puppeteerjs 要采用哪个js文件执行
     * @param webSiteUrl 要生成pdf/图片的网页
     * @param types 类型  ：pdf代表要生成pdf文件，jpg代表要生成jpg图片
     */
    public static void parseHtml2Pdf(HttpServletResponse response, String fileName, String puppeteerjs, String webSiteUrl, String types) {
        try {
            Runtime rt = Runtime.getRuntime();
            //Process p = rt.exec("node C:\\Users\\boshi\\Desktop\\iview-admin-master\\hn.js https://www.baidu.com pdf");
            Process p = rt.exec("node "+puppeteerjs+" "+webSiteUrl+" "+types);
            InputStream is = p.getInputStream();
            Loader
            BufferedInputStream bf=new BufferedInputStream(is);
            byte[] data = IOUtils.toByteArray(bf);
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + ".pdf" +  "\"");
            response.addHeader("Content-Length", "" + data.length);
            response.setContentType("application/octet-stream;charset=UTF-8");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
