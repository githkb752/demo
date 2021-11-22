package cn.nskjy.demo.principle.inversion.improve;

public class InversionDemo {
    public static void main(String[] args) {
        new Person().receive(new QQ());
        new Person().receive(new Email());
    }
}

/**
 * 表示接收者
 */
interface IReceiver{
    void getInfo();
}

class Email implements IReceiver{
    @Override
    public void getInfo() {
        System.out.println("Email 发送Hello");
    }
}

class QQ implements IReceiver{

    @Override
    public void getInfo() {
        System.out.println("QQ 发送Hello");
    }
}

class Person{
    public void receive(IReceiver iReceiver) {
        iReceiver.getInfo();
    }
}


