package cn.nskjy.demo.serial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RePostSerial {

    private static final Logger log = LoggerFactory.getLogger(RePostSerial.class);

    public static void main(String[] args) {
        read();
    }

    public static void read() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("Serial.tex");
            ois = new ObjectInputStream(fis);
            String str =(String)ois.readObject();
            log.info("str:{}",str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ois)
                    ois.close();
                if (null != fis)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
