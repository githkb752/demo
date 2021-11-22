package com.ytt.ytt.pdf.ex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class ExController {

    @PostMapping(value = "/saveDate")
    public void saveDate(@RequestParam("url") String url, HttpServletRequest request, HttpServletResponse response) {
        InputStream in = null;
        try {
            //这里我获取当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//20180315104140
            String timeStamp = sdf.format(new Date());
            //根据
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(30000);
            conn.setConnectTimeout(30000);
            conn.setDoOutput(true);
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setDoInput(true);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //得到输入流
            in = conn.getInputStream();

            //根据时间设置文件名
            timeStamp = timeStamp + ".pdf";
            //响应输出流，让用户自己选择保存路径 报文头 可以根据自己下载的文件格式去查询响应的报文头
            response.addHeader("Content-disposition",
                    "attachment; filename=\"" + timeStamp + "\"");
            response.setContentType("application/pdf");

            byte[] buffer = new byte[1024];
            int bytesRead = -1;
            while ((bytesRead = in.read(buffer)) != -1) {
                response.getOutputStream().write(buffer, 0, bytesRead);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }
        }
    }
}
