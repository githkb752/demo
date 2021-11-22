package com.ytt.ytt.phantomjs.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ytt.ytt.phantomjs.service.PhantomService;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author diaoby
 * PhantomControl PDF 导出
 */
@RestController
public class PhantomControl {

    /**
     * PhantomService
     */
    @Resource
    private PhantomService phantomService;

    /**
     * Phantom servie
     */
    /**
     *  图片保存目录
     */
    @Value("${phantom.pdf.tempPath}")
    private String tempPath ;
    /**
     *
     */
//    @Resource
//    private CommonService commonService;

    /**
     * html 转pdf
     * @param request
     * @return
     * @author diaoby
     * @throws UnsupportedEncodingException
     * @throws InterruptedException
     */
    @PostMapping("/pdfdownload")
    public ResponseEntity<byte[]> html2Pdf(HttpServletRequest request, @RequestParam("url") List<String> url, @RequestParam("fileName")String fileName) throws UnsupportedEncodingException, InterruptedException{
        byte[] body = null;
        HttpHeaders headers = new HttpHeaders();
        fileName=new String(fileName.getBytes("GBK"),"iso-8859-1");
//        fileName=new String(fileName.getBytes());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName +".pdf");
        ResponseEntity<byte[]> responseEntity = null;
        InputStream inputStream = null ;
        Process process = null;
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        String dirName = tempPath + UUID.randomUUID().toString();
//        User currentUser = Security.getCurrentUser();
//        String token = commonService.getToken2(currentUser.getLoginName());
//        String token = ""; // TODO
        //url 添加token 和 isPdf 参数，方便过滤页面弹出框
//        url = url+"&Authorization="+token+"&isPdf=true";
        try {
            for (String s : url) {
                String filePath = phantomService.pdfTempleFilePath(dirName);
                process = phantomService.printUrlScreen2pdf(filePath,s);
                //等到 process 完成 产生pdf附件
                process.waitFor();
            }
            PDFMergerUtility mergePdf = new PDFMergerUtility();
            String destinationFileName = UUID.randomUUID().toString()+".pdf";
            String[] filesInFolder = getFiles(dirName);
            for (int i = 0; i < filesInFolder.length; i++)
            {
                mergePdf.addSource(dirName + File.separator + filesInFolder[i]);
            }
            mergePdf.setDestinationFileName(dirName + File.separator + destinationFileName);
            mergePdf.mergeDocuments();
            //读取产生的文件到输出流
            File pdfFile = new File(dirName + File.separator + destinationFileName);
            if(pdfFile.exists()){
                fis = new FileInputStream(pdfFile);
                bos = new ByteArrayOutputStream();
                byte[] b = new byte[1024];
                int n;
                while ((n = fis.read(b)) != -1)
                {
                    bos.write(b, 0, n);
                }
                body = bos.toByteArray();
            }
            responseEntity = new ResponseEntity<byte[]>(body,headers,HttpStatus.CREATED);
        } catch (IOException e) {
//            throw new AcwsGenerelException("pdf导出异常", e);
            throw new RuntimeException("pdf导出异常", e);
        } finally {
            try {
                fis.close();
                bos.close();
                close(process, inputStream);
                //删除生产的pdf文件
//                delPdfTempleFile(filePath);
                deleteDir(new File(dirName));
            } catch (IOException e) {
//                throw new AcwsGenerelException("pdf流关闭异常", e);
                throw new RuntimeException("pdf流关闭异常", e);
            }
        }
        return responseEntity;
    }


    /**
     * 关闭命令和流
     * @param process
     * @param inputStream
     * @throws IOException
     * @author diaoby
     */
    private void close(Process process, InputStream inputStream) throws  IOException {
        if (inputStream != null) {
            inputStream.close();
            inputStream = null;
        }
        if (process != null) {
            process.destroy();
            process = null;
        }
    }


    /**
     * 删除PDF 临时文件
     * @param pdfPath
     * @return
     * @author diaoby
     */
    private void delPdfTempleFile(String pdfPath) {
        File pdfFile = new File(pdfPath);
        if(pdfFile.exists()){
            pdfFile.delete();
        }
    }

    public void deleteDir(File file){
        //判断是否为文件夹
        if(file.isDirectory()){
            //获取该文件夹下的子文件夹
            File[] files = file.listFiles();
            //循环子文件夹重复调用delete方法
            for (int i = 0; i < files.length; i++) {
                deleteDir(files[i]);
            }
        }
        //若为空文件夹或者文件删除，File类的删除方法
        file.delete();
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