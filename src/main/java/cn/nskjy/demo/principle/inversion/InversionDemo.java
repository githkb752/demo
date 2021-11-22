package cn.nskjy.demo.principle.inversion;

public class InversionDemo {
    public static void main(String[] args) {
        new Person().receive(new Email());
    }
}

class Email{
    public String getInfo() {
        return "Email 发送信息Hello";
    }
}

/**
 * 方式一：
 * 接收消息
 * 简单容易想到
 * 假如需要接收其它消息，需要添加新的方法
 * 解决思路：引入一个抽象的IReceiver接口，表示接收者，这样Person类和IReceiver接口依赖。
 * Email、QQ属于接收范围，分别去实现IReceiver接口，这样就符合依赖倒置原则
 *
 */
class Person{
    public void receive(Email email) {
        System.out.println("接收到：" + email.getInfo());
    }
}
