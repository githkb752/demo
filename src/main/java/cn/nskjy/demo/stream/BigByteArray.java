package cn.nskjy.demo.stream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BigByteArray {

    @Test
    public void byteArray() {
        FileOutputStream fos;
        FileInputStream fis;

        try {
            // 文件输入流读取MainDemo.java文件
            fis = new FileInputStream("E:\\IDEAWorkspace\\demo\\src\\main\\java\\cn\\nskjy\\demo\\MainDemo.java");
            // 文件输出流写入text.txt文件中
            fos= new FileOutputStream("text.txt");
            int readInt = -1;
            // 定义一个字节数组,用于存放输入流数据
            byte[] bytes = new byte[1028];
            // 输入流每一次读的数据量
            while((readInt = fis.read(bytes)) > 0) {
                // 将字节数组存储的数据通过输出流写入到text.txt文件中
                fos.write(bytes,0,readInt);
//                fos.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
