package cn.nskjy.demo;

import cn.nskjy.demo.params.Programmer;

import java.util.ArrayList;
import java.util.List;

public class MainDemo {

    public static void demo(HttpReqBasic<Programmer> body) {
        Programmer programmer = new Programmer();
        programmer.setComputer("联想笔记本");
        programmer.playEncoding(programmer.getComputer());
    }

    public static void main(String[] args) {
        String str = "010";
        String str1 = "010".equals(str) ? null : str;
        System.out.println(str1);
    }

}
