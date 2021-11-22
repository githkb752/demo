package com.ytt.ytt.phantomjs.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author diaoby
 *
 */
@Service
public class PhantomService {

    /**
     * 空格
     */
    private String BLANK = " ";
    /**
     * phantomjs exe
     */
    @Value("${phantom.exe}")
    private String binPath;
    /**
     * rasterize.js
     */
    @Value("${phantom.rasterizejs}")
    private String jsPath;

    /**
     * 执行命令
     * @param path
     * @param url
     * @return
     * @author diaoby
     */
    public String cmd(String path, String url) {
        return binPath + BLANK + jsPath + BLANK + url + BLANK + path;
    }

    /**
     * 页面转pdf
     * @param url
     * @throws IOException
     * @author diaoby
     */
    public Process printUrlScreen2pdf(String pdfPath,String url) throws IOException{
        //Java中使用Runtime和Process类运行外部程序
        String cmd = cmd(pdfPath,url);
        Process process = Runtime.getRuntime().exec(cmd);
        return process;
    }

    /**
     * 返回PDF 临时生产目录
     * @author diaoby
     */
    public String pdfTempleFilePath(String dirName) {
        return dirName+File.separator+UUID.randomUUID().toString()+".pdf";
    }
}
