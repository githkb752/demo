package cn.nskjy.demo.utils.qrcode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 生成二维码
 */
public class GenerateQrcode {
    public static void main(String[] args) {
        BufferedImage bufferedImage = new BufferedImage(400,400,1);
        try {
            ImageIO.write(bufferedImage,"jpg",new File("F:\\javaUtils\\qg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
