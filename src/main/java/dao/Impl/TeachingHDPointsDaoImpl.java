package dao.Impl;

import dao.DatabaseDao;
import dao.TeachingHDPointsDao;
import domain.TeachingPoints;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @authoor yangyuze
 * @create 2018-12-24 20:41
 */
public class TeachingHDPointsDaoImpl implements TeachingHDPointsDao {
    public TeachingPoints getCurPoint() throws SQLException, ClassNotFoundException {
        String sql = "select * from uml_teaching_points where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        TeachingPoints point = new TeachingPoints();
        dao.query(sql);
        ResultSet resultSet = dao.getRs();
        while (resultSet.next()){
            point.setPointId(resultSet.getInt("pointId"));
            point.setTheoryInfo(resultSet.getString("theoryInfo"));
            point.setExperimentInfo(resultSet.getString("experimentInfo"));
            point.setEnable(resultSet.getString("enable"));
            point.setTime(resultSet.getString("time"));
        }
        dao.close();
        return point;
    }

    public List<TeachingPoints> showAllPoints() throws SQLException, ClassNotFoundException {
        List<TeachingPoints> points = new ArrayList<>();
        DatabaseDao dao = new DatabaseDao();
        String sql = "select * from uml_teaching_points";
        dao.query(sql);
        ResultSet rs = dao.getRs();
        while (rs.next()){
            TeachingPoints point = new TeachingPoints();
            point.setPointId(rs.getInt("pointId"));
            point.setTheoryInfo(rs.getString("theoryInfo"));
            point.setExperimentInfo(rs.getString("experimentInfo"));
            point.setEnable(rs.getString("enable"));
            point.setTime(rs.getString("time"));
            points.add(point);
        }
        dao.close();
        return points;
    }

    public int usePoint(int pointId) throws SQLException, ClassNotFoundException {
        String sql = "update uml_teaching_points set enable = \"false\" where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        dao.update(sql);
        sql = "update uml_teaching_points set `enable` = \"true\" where pointId = "+pointId    ;
        return dao.update(sql);
    }

    public int delPoint(int pointId) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        String sql = "delete from uml_teaching_points where pointId = "+pointId;
        return dao.update(sql);
    }

    public void addPoint(TeachingPoints point) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        if("true".equals(point.getEnable())){
            String sql = "update uml_teaching_points set enable = \"false\" where enable = \"true\"";
            dao.update(sql);
        }
        String sql = "insert into uml_teaching_points(theoryInfo,experimentInfo,enable) values(\""+point.getTheoryInfo()+"\",\""+point.getExperimentInfo()+"\",\""+point.getEnable()+"\")";
        System.out.println(sql);
        dao.update(sql);
    }
}
