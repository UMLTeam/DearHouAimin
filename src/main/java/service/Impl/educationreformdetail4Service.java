package service.Impl;


import dao.Impl.educationReformDetail4Dao;
import domain.dguterd4;

import java.sql.Date;
import java.util.List;

public class educationreformdetail4Service {
    public static dguterd4 getOneEducationReformDetail4Service(String title, String type, Date date, String content) {
        dguterd4 dgut = new dguterd4();
        dgut.setDguterd4_title(title);
        dgut.setDguterd4_type(type);
        dgut.setDguterd4_date(date);
        dgut.setDguterd4_content(content);
        dgut.setDguterd4_state(0);
        return dgut;
    }

    public static dguterd4 findOneEducationReformDetail4Service(int num) {
        return educationReformDetail4Dao.findOneEducationReformDetail4(num);
    }

    public static boolean deleteOneEducationReformDetail4Service(int num) {
        if (educationReformDetail4Dao.deleteOneEducationReformDetail4(num))
            return true;
        return false;
    }

    public static boolean insertOneEducationReformDetail4Service(dguterd4 erd4) {
        if (educationReformDetail4Dao.insertEducationReformDetail4(erd4))
            return true;
        return false;
    }

    public static boolean modifyOneEducationReformDetail4Service(dguterd4 erd4, int num) {
        if (educationReformDetail4Dao.modifyEducationReformDetail4(erd4, num))
            return true;
        return false;
    }

    public static int getCountEducationReformDetail4Service() {
        return educationReformDetail4Dao.getCountEducationReformDetail4();
    }

    public static List<dguterd4> getAllEducationReformDetail4Service() {
        return educationReformDetail4Dao.getAllEducationReformDetail4();
    }

    public static boolean changeStateService(int num, int id) {
        return educationReformDetail4Dao.changeState(num, id);
    }

    public static List<dguterd4> getAllSameTypeEducationReformDetail4Service(String type) {
        return educationReformDetail4Dao.getAllSameTypeEducationReformDetail4(type);
    }

    public static List<dguterd4> findMeasuresNameService(String Name) {
        return educationReformDetail4Dao.findMeasuresName(Name);
    }

    public static List<dguterd4> getAlltitleOfErd4Service() {
        return educationReformDetail4Dao.getAlltitleOfErd4();
    }
}
