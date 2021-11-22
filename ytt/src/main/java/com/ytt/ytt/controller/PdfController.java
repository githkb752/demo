package com.ytt.ytt.controller;

import javax.servlet.http.HttpServletResponse;

import com.ytt.ytt.util.PdfFileCreator;
import com.ytt.ytt.po.PdfFileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;


@RestController
public class PdfController {

    private final PdfFileCreator pdfFileCreator;

    @Autowired
    public PdfController(PdfFileCreator pdfFileCreator) {
        this.pdfFileCreator = pdfFileCreator;
    }

    @RequestMapping(value = "/api/pdf", method = RequestMethod.POST)
    public void createPdf(@RequestBody PdfFileRequest fileRequest, HttpServletResponse response) {
        pdfFileCreator.writePdfToResponse(fileRequest, response);
    }


}