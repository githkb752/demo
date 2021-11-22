package cn.nskjy.demo.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoArray {

    @Test
    public void test01() {
        String[] str01 = new String[5];
        String[] str02 = new String[7];
        String[] str03;
        str01[0] = "001";
        str01[1] = "002";
        str01[2] = "003";
        str01[3] = "004";
        str01[4] = "005";
        str02[0] = "后端开发";
        str02[1] = "前端开发";
        str02[2] = "ui";
        str02[3] = "测试";
        str02[4] = "H5";
        str02[5] = "产品";
        str02[6] = "项目";
        str03 = Arrays.copyOfRange(str02,1,4);
        Map<String, String[]> map = new HashMap<>();
        map.put(str01[0], str02);
        map.put(str01[1], str03);
    }

}
