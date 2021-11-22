package cn.nskjy.demo.systemparam;

public class ParamDemo {
    public static void main(String[] args) {
        String name = System.getProperty("protocolName");
        String mock = System.getProperty("mock");
        if ("".equals(name) || name == null) name = "http";
        switch (name) {
            case "dubbo":
                System.out.println("使用dubbo协议");
                break;
            case "http":
                System.out.println("使用http协议");
                break;
            default:
                 break;
        }
        System.out.println(mock);
        System.out.println("获取system参数");
    }
}
