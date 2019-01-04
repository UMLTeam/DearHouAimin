package service.Impl;


import dao.Impl.educationReformDetail1Dao;
import domain.dguterd1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class educationreformdetail1Service {
    public static dguterd1 getOneEducationReformDetail1Service(String title, String type, Date date, String origin, String content) {
        dguterd1 dgut = new dguterd1();
        dgut.setDguterd1_title(title);
        dgut.setDguterd1_type(type);
        dgut.setDguterd1_date(date);
        dgut.setDguterd1_origin(origin);
        dgut.setDguterd1_content(content);
        dgut.setDguterd1_state(0);
        return dgut;
    }

    public static dguterd1 findOneEducationReformDetail1Service(int num) {
        return educationReformDetail1Dao.findOneEducationReformDetail1(num);
    }

    public static boolean deleteOneEducationReformDetail1Service(int num) {
        if (educationReformDetail1Dao.deleteOneEducationReformDetail1(num))
            return true;
        return false;
    }

    public static boolean insertOneEducationReformDetail1Service(dguterd1 erd1) {
        if (educationReformDetail1Dao.insertEducationReformDetail1(erd1))
            return true;
        return false;
    }

    public static boolean modifyOneEducationReformDetail1Service(dguterd1 erd1, int num) {
        if (educationReformDetail1Dao.modifyEducationReformDetail1(erd1, num))
            return true;
        return false;
    }

    public static int getCountEducationReformDetail1Service() {
        return educationReformDetail1Dao.getCountEducationReformDetail1();
    }

    public static List<dguterd1> getAllEducationReformDetail1Service() {
        return educationReformDetail1Dao.getAllEducationReformDetail1();
    }

    public static boolean changeStateService(int num, int id) {
        return educationReformDetail1Dao.changeState(num, id);
    }

    public static List<dguterd1> getAllSameTypeEducationReformDetail1Service(String type) {
        return educationReformDetail1Dao.getAllSameTypeEducationReformDetail1(type);
    }

    public static List<dguterd1> findMeasuresNameService(String Name) {
        return educationReformDetail1Dao.findMeasuresName(Name);
    }

    public static ArrayList<dguterd1> getAlltitleOfErd1Service() {
        return educationReformDetail1Dao.getAlltitleOfErd1();
    }
}
