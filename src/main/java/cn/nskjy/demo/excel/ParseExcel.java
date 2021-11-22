package cn.nskjy.demo.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseExcel {
    public static void main(String[] args) {
        String[][] strings = parse("C:\\Users\\Administrator\\Desktop\\现场考察2.xlsx");
        for (String[] string : strings) {
            for (String str : string) {
                System.out.print(str + "\t");
            }
            System.out.println();
        }
    }

    public static void get() {
        String[] str = {"张三", "李四", "王五"};
        File file = new File("C:\\Users\\Administrator\\Desktop\\现场考察2.xlsx");

    }

    public static String[][] parse(String filePath) {
        Workbook workbook = getWork(filePath);
        // 循环工作簿中的表
        for (int feelNum = 0; feelNum <= workbook.getNumberOfSheets(); feelNum++) {
            Sheet sheet = workbook.getSheetAt(feelNum);
            if (null == sheet) {
                continue;
            }
            // 获取表中所有的行
            int rows = sheet.getLastRowNum() + 1;
            // 获取表中开始行
            int firstRowNum = sheet.getFirstRowNum();
            // 获取所有列
            int columns = sheet.getRow(firstRowNum).getPhysicalNumberOfCells();
            List<String> data = new ArrayList<String>();
            data.add("张三");
            data.add("李四");
            data.add("ytt");
            for (int i = 1; i <= 1; i++) {

            }
            // 实例化一个二维数组,存储表格数据
            /*String[][] contents = new String[rows][columns];
            for (int k = 2; k < rows; k++) {
                Row row = sheet.getRow(k);
                if (null != row) {
                    for (int j = 2; j < columns; j++) {
                        if (k==3) {
                            contents[k][j] = getCellFormatValue(row.getCell(j));
                            Double value = Double.valueOf(contents[k][j]);
                            if (value < 0 || value > 40)
                                return null;
                        } else {
                            contents[k][j] = getCellFormatValue(row.getCell(j));
                            Double value = Double.valueOf(contents[k][j]);
                            if (value < 0 || value > 20)
                                return null;
                        }
                    }
                }
            }
            return contents;*/
        }
        return null;
    }

    public static String getCellFormatValue(Cell cell) {
        String cellValue = "";
        if (null != cell) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    cellValue = new Double(cell.getNumericCellValue()).intValue() + "";
                    break;
                default:
                    cellValue = "";
            }
        } else {
            return "";
        }
        return cellValue;
    }

    public static Workbook getWork(String filePath) {
        // 定义输入流
        InputStream is = null;
        // 定义工作簿
        Workbook workbook = null;
        try {
            // 文件输入流实现
            is = new FileInputStream(new File(filePath));
            if (filePath.endsWith("xlsx")) {
                // 工作簿的实现
                workbook = new XSSFWorkbook(is);
            } else if(filePath.endsWith("xls")) {
                workbook = new HSSFWorkbook(is);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    // 关闭输入流
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return workbook;
    }

}
