package dao;

import domain.TeachingMeasure;

import java.sql.SQLException;
import java.util.List;

public interface TeachingMeasureDao {
    public TeachingMeasure getCurMeasure() throws SQLException, ClassNotFoundException;

    public List<TeachingMeasure> showAllMeasure() throws SQLException, ClassNotFoundException;

    public int useMeasure(int measureId) throws SQLException, ClassNotFoundException;

    public int delMeasure(int measureId) throws SQLException, ClassNotFoundException;
    public void addMeasure(TeachingMeasure measure) throws SQLException, ClassNotFoundException;

}
