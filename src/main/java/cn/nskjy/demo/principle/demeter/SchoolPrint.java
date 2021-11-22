package cn.nskjy.demo.principle.demeter;

public class SchoolPrint {
    public static void main(String[] args) {
        new MasterSchool().print();
        new SubSchool().print();
    }
}
