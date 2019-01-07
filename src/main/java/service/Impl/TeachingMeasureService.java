package service.Impl;

import dao.Impl.TeachingMeasureDaoImpl;
import dao.TeachingMeasureDao;
import domain.TeachingMeasure;

import java.sql.SQLException;
import java.util.List;

public class TeachingMeasureService {
	public TeachingMeasure getCurMeasure() throws SQLException, ClassNotFoundException {
        TeachingMeasureDao TADao = new TeachingMeasureDaoImpl();
        TeachingMeasure measure = TADao.getCurMeasure();
        return measure;
    }

    public List<TeachingMeasure> showAllMeasures() throws SQLException, ClassNotFoundException {
        TeachingMeasureDao TAD = new TeachingMeasureDaoImpl();
        return TAD.showAllMeasure();
    }

    public int useMeasure(int measureId) throws SQLException, ClassNotFoundException {
        TeachingMeasureDao tad = new TeachingMeasureDaoImpl();
        return tad.useMeasure(measureId);
    }

    public int delMeasure(int measureId) throws SQLException, ClassNotFoundException {
        TeachingMeasureDao tad = new TeachingMeasureDaoImpl();
        return tad.delMeasure(measureId);
    }
    public void addMeasure(TeachingMeasure measure) throws SQLException, ClassNotFoundException {
        TeachingMeasureDao TAD = new TeachingMeasureDaoImpl();
        TAD.addMeasure(measure);
        return;
    }
}
