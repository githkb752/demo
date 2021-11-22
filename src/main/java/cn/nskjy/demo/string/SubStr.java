package cn.nskjy.demo.string;

public class SubStr {
    public static void main(String[] args) {
        String url = "localhost:8080/user/add/index.jsp";
        int index = url.lastIndexOf("l");
        System.out.println(index);
        String subUrl = url.substring(index + 1);
        System.out.println(subUrl);
    }
}
