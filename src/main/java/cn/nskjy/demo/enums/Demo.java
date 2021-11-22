package cn.nskjy.demo.enums;

public class Demo {
    public static void main(String[] args) {
        String key = "2";
        String code = DpEnum.getCodeToKey(key);
        System.out.println(code);
    }
}
