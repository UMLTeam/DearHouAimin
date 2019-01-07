package dao;

import domain.TeachingPoints;

import java.sql.SQLException;
import java.util.List;

public interface TeachingHDPointsDao {
    public TeachingPoints getCurPoint() throws SQLException, ClassNotFoundException;

    public List<TeachingPoints> showAllPoints() throws SQLException, ClassNotFoundException;

    public int usePoint(int pointId) throws SQLException, ClassNotFoundException;

    public int delPoint(int pointId) throws SQLException, ClassNotFoundException;

    public void addPoint(TeachingPoints point) throws SQLException, ClassNotFoundException;

}
