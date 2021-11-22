package cn.nskjy.demo.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

public class Demeter {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.masterSchoolManager = new MasterSchoolManager();
        schoolManager.subSchoolManager = new SubSchoolManager();
        schoolManager.print();
    }
}

class School{
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

class MasterSchool extends School{}

class SubSchool extends School{}

class MasterSchoolManager{
    public List<MasterSchool> getMasterIds() {
        List<MasterSchool> list = new ArrayList<>();
        for (int i = 1; i <= 70; i++) {
            MasterSchool school = new MasterSchool();
            school.setId(i);
            list.add(school);
        }
        return list;
    }
}

class SubSchoolManager{
    public List<SubSchool> getSubIds() {
        List<SubSchool> list = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            SubSchool school = new SubSchool();
            school.setId(i);
            list.add(school);
        }
        return list;
    }
}

class SchoolManager{
    MasterSchoolManager masterSchoolManager;
    SubSchoolManager subSchoolManager;

    public void print() {
        List<MasterSchool> masterIds = masterSchoolManager.getMasterIds();
        List<SubSchool> subIds = subSchoolManager.getSubIds();
        for (MasterSchool masterId : masterIds) {
            System.out.println("总部员工id：" + masterId.getId());
        }
        for (SubSchool subId : subIds) {
            System.out.println("子学院员工id：" + subId.getId());
        }
    }
}
