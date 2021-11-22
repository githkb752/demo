package cn.nskjy.demo.principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class MasterSchool extends School {

    MasterSchool() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 70; i++) {
            list.add(i);
        }
        super.schoolId = list;
    }

    @Override
    public void print() {
        for (Integer integer : schoolId) {
            System.out.println("总部员工id为：" + integer);
        }
    }
}
