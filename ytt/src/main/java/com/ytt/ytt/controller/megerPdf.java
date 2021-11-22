package com.ytt.ytt.controller;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;

public class megerPdf {

    public static void main(String[] args) throws Exception {
        PDFMergerUtility mergePdf = new PDFMergerUtility();
        String folder = "E:/pdf/";
//        String folder = "D:/pdf/";
        String destinationFileName = "mergedTest.pdf";
        String[] filesInFolder = getFiles(folder);
        for (int i = 0; i < filesInFolder.length; i++)
        {
            mergePdf.addSource(folder + File.separator + filesInFolder[i]);
        }
        mergePdf.setDestinationFileName(folder + File.separator + destinationFileName);
        mergePdf.mergeDocuments();
        System.out.print("合并完成__LLL丶禾羊__博客");
    }
    private static String[] getFiles(String folder) throws IOException {
        File _folder = new File(folder);
        String[] filesInFolder;
        if (_folder.isDirectory()) {
            filesInFolder = _folder.list();
            return filesInFolder;
        } else {
            throw new IOException("Path is not a directory");
        }
    }

}
