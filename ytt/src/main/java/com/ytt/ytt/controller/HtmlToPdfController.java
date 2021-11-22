package com.ytt.ytt.controller;

import com.ytt.ytt.po.SaleOrderVo;
import com.ytt.ytt.util.PDFUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class HtmlToPdfController {

    @RequestMapping(value = "/exportPdf", method = {RequestMethod.POST, RequestMethod.GET},
            produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> exportPdf() {
        try {
            SaleOrderVo saleOrder = getSaleOrderById();
            ResponseEntity<?> responseEntity = export(saleOrder);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<String>("{ \"code\" : \"404\", \"message\" : \"not found\" }",
                headers, HttpStatus.NOT_FOUND);
    }

    /**
     * PDF 文件导出
     *
     * @return
     */
    public ResponseEntity<?> export(SaleOrderVo saleOrder) {
        HttpHeaders headers = new HttpHeaders();

        /**
         * 数据导出(PDF 格式)
         */
        Map<String, Object> dataMap = new HashMap<>(16);
        dataMap.put("createTime", saleOrder.getCreateTime());
        dataMap.put("orderCode", saleOrder.getOrderCode());
        dataMap.put("productPrice", saleOrder.getProductPrice());
        dataMap.put("userName", saleOrder.getUserName());

        String htmlStr = PDFUtil.freemarkerRender(dataMap, "templates/website/pz/pz.ftl");

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("templates/website/pz/simsun.ttc");
        // htmlStr = htmlStr.replaceAll("<br>", "");
        //htmlStr = htmlStr.replaceAll("</br>", "");
        byte[] pdfBytes = PDFUtil.createPDF(htmlStr, "templates/website/pz/simsun.ttc");
        if (pdfBytes != null && pdfBytes.length > 0) {
            String fileName = UUID.randomUUID() + ".pdf";
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(pdfBytes, headers, HttpStatus.OK);
        }
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<String>("{ \"code\" : \"404\", \"message\" : \"not found\" }",
                headers, HttpStatus.NOT_FOUND);
    }

    public SaleOrderVo getSaleOrderById() {
        SaleOrderVo saleOrderVo = new SaleOrderVo();
        saleOrderVo.setCreateTime(new Date());
        saleOrderVo.setOrderCode("1");
        saleOrderVo.setProductPrice("1");
        saleOrderVo.setUserName("ytt");
        return saleOrderVo;
    }
}
