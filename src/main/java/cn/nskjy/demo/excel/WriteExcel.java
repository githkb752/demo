package cn.nskjy.demo.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteExcel {

    /**
     * 向Excel中写入数据
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        List<String> strList = new ArrayList<String>();
        strList.add("张三");
        strList.add("李四");
        strList.add("王五");

        String filePath = "C:\\Users\\Administrator\\Desktop\\现场考察2.xlsx";
        boolean flag = fileExist(filePath);
        if (flag){
            writeExcel(strList,filePath);
        }else {
            File file = new File(filePath);
            writeExcel(strList,filePath);
        }
    }

    //判断文件是否存在
    public static boolean fileExist(String filePath){
        boolean flag = false;
        File file = new File(filePath);
        flag = file.exists();
        return flag;
    }

    //向Excel中写数据
    public static void writeExcel(List<String> list ,String filePath){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");
        XSSFRow row = sheet.createRow(1);
        for(int i = 0; i< list.size();i++) {
            XSSFCell cell = row.createCell(i + 2);
            cell.setCellValue(list.get(i));
        }


        //循环设置表头信息


        //遍历list,将数据写入Excel中

        OutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
