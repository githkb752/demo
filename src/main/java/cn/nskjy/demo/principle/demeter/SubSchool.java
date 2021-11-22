package cn.nskjy.demo.principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class SubSchool extends School {

    SubSchool() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            list.add(i);
        }
        super.schoolId = list;
    }

    @Override
    public void print() {
        for (Integer integer : schoolId) {
            System.out.println("子学院员工id为：" + integer);
        }
    }
}
