package cn.nskjy.demo.regex;

import java.util.Scanner;

public class FillOutPwd {
    public static void fillOutPwd(String regex) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入六位密码：");
        String pwd = scanner.next();
        if (pwd.matches(regex)) {
            System.out.println("密码输入格式正确");
        } else {
            System.out.println("密码输入格式错误");
        }
    }

    public static void main(String[] args) {
        String regex = "[0-9]+";
        fillOutPwd(regex);
    }
}
