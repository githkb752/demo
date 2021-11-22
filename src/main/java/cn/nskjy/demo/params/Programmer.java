package cn.nskjy.demo.params;

public class Programmer {

    private String computer;

    public void playEncoding(String computer) {
        System.out.println("我正在使用" + computer + "进行编码工作");
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }
}
