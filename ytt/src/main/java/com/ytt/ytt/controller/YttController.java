package com.ytt.ytt.controller;

import com.alibaba.fastjson.JSON;
import com.ytt.ytt.pojo.RestResp;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/sfm/project")
public class YttController {

    @GetMapping("/exist")
    public String get(@RequestParam("uscc") String uscc) {
        RestResp restResp = new RestResp();
        restResp.setData(1);
        restResp.setMsg("成功");
        String string = JSON.toJSONString(restResp);
        return string;
    }
    @RequestMapping("/load")
    public ResponseEntity<byte[]> download(HttpServletRequest request, String filePath) throws IOException {
        request.setCharacterEncoding("UTF-8");

        //获取文件
        File file = new File("E:\\IDEAWorkspace\\demo\\ytt\\src\\main\\resources\\aaa.xlsx");

        //获取文件名
        String fileName = file.getName();

        //解决文件名乱码
        String fileName1 =new String(fileName.getBytes("UTF-8"),"iso-8859-1");

        //读取二进制文件
        byte[] body = null;
        InputStream is = new FileInputStream("E:\\IDEAWorkspace\\demo\\ytt\\src\\main\\resources\\aaa.xlsx");
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();

        //通知浏览器以attachment（下载方式）打开图片
        headers.add("Content-Disposition", "attchement;filename=" + fileName1);

        //application/octet-stream二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        //文件下载的Http协议中的状态最好使用HttpStatus.OK。
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;

    }
}
