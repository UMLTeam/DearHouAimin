package dao.Impl;

import dao.DatabaseDao;
import dao.TeachingMeasureDao;
import domain.TeachingMeasure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @authoor linzerong
 * @create 2018-12-23 12:18
 */
public class TeachingMeasureDaoImpl implements TeachingMeasureDao {
    public TeachingMeasure getCurMeasure() throws SQLException, ClassNotFoundException {
        String sql = "select * from uml_teaching_measure where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        TeachingMeasure measure = new TeachingMeasure();
        dao.query(sql);
        ResultSet resultSet = dao.getRs();
        while (resultSet.next()){
        //    System.out.println("!!!!!!!");
            measure.setMeasureId(resultSet.getInt("measureId"));
            measure.setMeasureName(resultSet.getString("measureName"));
            measure.setMeasureURL(resultSet.getString("measureURL"));
            measure.setEnable(resultSet.getString("enable"));
            measure.setTime(resultSet.getString("time"));
        }
        dao.close();
        return measure;
    }

    public List<TeachingMeasure> showAllMeasure() throws SQLException, ClassNotFoundException {
        List<TeachingMeasure> measures = new ArrayList<>();
        DatabaseDao dao = new DatabaseDao();
        String sql = "select * from uml_teaching_measure";
        dao.query(sql);
        ResultSet rs = dao.getRs();
        while (rs.next()){
            TeachingMeasure measure = new TeachingMeasure();
            measure.setMeasureId(rs.getInt("measureId"));
            measure.setMeasureName(rs.getString("measureName"));
            measure.setMeasureURL(rs.getString("measureURL"));
            measure.setEnable(rs.getString("enable"));
            measure.setTime(rs.getString("time"));
            measures.add(measure);
        }
        dao.close();
        return measures;
    }

    public int useMeasure(int measureId) throws SQLException, ClassNotFoundException {
        String sql = "update uml_teaching_measure set enable = \"false\" where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        dao.update(sql);
        sql = "update uml_teaching_measure set `enable` = \"true\" where measureId = "+measureId;
        return dao.update(sql);
    }

    public int delMeasure(int measureId) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        String sql = "delete from uml_teaching_measure where measureId = "+measureId;
        return dao.update(sql);
    }

    public void addMeasure(TeachingMeasure measure) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        if("true".equals(measure.getEnable())){
            String sql = "update uml_teaching_measure set enable = \"false\" where enable = \"true\"";
            dao.update(sql);
        }
        String sql = "insert into uml_teaching_measure(measureName,measureURL,enable) values(\""+measure.getMeasureName()+"\",\""+
                measure.getMeasureURL()+"\",\""+measure.getEnable()+"\")";
        dao.update(sql);
    }
}