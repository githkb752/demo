package com.ytt.ytt.pdf.puppeter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/puppeteer")
public class PuppeteerController {

    @Value("${puppeteer.puppeteerJs}")
    private String puppeteerJs;

    @GetMapping("/download")
    public void puppeteerResp(HttpServletResponse response) {
        PuppeteerHtmlToPdf.parseHtml2Pdf(response, "puppeteer",
                puppeteerJs, "https://www.baidu.com", "pdf" );
    }
}
