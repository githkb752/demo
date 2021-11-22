/*
package cn.nskjy.demo.serial;

import cn.nskjy.demo.vo.User;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class PostSerial {
    public static void main(String[] args) {
        findSerial();
    }

    public static void findSerial() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            User user = new User("小珍", 29, '女');
            String userStr = JSONObject.toJSONString(user);
            File file = new File("Serial.tex");
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(userStr);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != oos)
                    oos.close();
                if (null != fos)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
*/
