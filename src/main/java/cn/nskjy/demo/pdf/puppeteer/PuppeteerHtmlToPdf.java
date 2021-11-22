//package cn.nskjy.demo.pdf.puppeteer;
//
//import org.apache.poi.util.IOUtils;
//
//import java.io.*;
//import java.net.URLEncoder;
//
///**
// *
// * @author zx
// * @date 2020/8/5
// * 用谷歌提供的node实现的Puppeteer，实现网页截图及把网页生成pdf文件采
// */
//public class PuppeteerHtmlToPdf {
//    /**
//     * html转pdf,直接通过流输出到浏览器
//     * @param response 浏览器响应
//     * @param fileName 文件名称
//     * @param puppeteerjs 要采用哪个js文件执行
//     * @param webSiteUrl 要生成pdf/图片的网页
//     * @param types 类型  pdf代表要生成pdf文件，jpg代表要生成jpg图片
//     * @param mobileWidth 需要转化的网页宽度
//     * @param mobileHight 需要转化的网页长度
//     */
//    public static void parseHtml2Pdf(HttpServletResponse response, String fileName, String puppeteerjs, String webSiteUrl, String types, String mobileWidth, String mobileHight) {
//        try {
//            Runtime rt = Runtime.getRuntime();
//            //Process p = rt.exec("node C:\\Users\\boshi\\Desktop\\iview-admin-master\\hn.js http://yunfu.ifutest.com/adminAchievement/viewPdfHtml/7e6bba53b5d34124a54c0648a825bcda pdf");
//            Process p = rt.exec("node " + puppeteerjs + " " + webSiteUrl + " " + types + " " + mobileWidth + " " + mobileHight);
//            InputStream is = p.getInputStream();
//            BufferedInputStream bf = new BufferedInputStream(is);
//            byte[] data = IOUtils.toByteArray(bf);
//            fileName = URLEncoder.encode(fileName, "UTF-8");
//            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//            response.addHeader("Content-Length", "" + data.length);
//            response.setContentType("application/octet-stream;charset=UTF-8");
//            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
//            outputStream.write(data);
//            outputStream.flush();
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
