package service.Impl;

import dao.Impl.TeachFileDao;
import domain.TeachEvalFile;

import java.sql.SQLException;
import java.util.List;

public class TeachFileService {
	
	dao.Impl.TeachFileDao TeachFileDao = new TeachFileDao();
	
    public List<TeachEvalFile> getHomeworkList(int page) {
        return TeachFileDao.getHomeworkList(page);
    }

    public int getAll() {
        return TeachFileDao.getAll();
    }

    public TeachEvalFile getById(String id) throws SQLException {
        return TeachFileDao.getById(id);
    }
    
    public void addHomework(TeachEvalFile TeachEvalFile){
        TeachFileDao.addHomework(TeachEvalFile);
    }
    public void deleteHomework(String id) {
        TeachFileDao.deleteHomework(id);
    }

}