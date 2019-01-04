package service.Impl;

import dao.Impl.HomeworkDao;
import domain.FileBean;

import java.sql.SQLException;
import java.util.List;

public class HomeworkService {
	
	HomeworkDao homeworkDao = new HomeworkDao();
	
    public List<FileBean> getHomeworkList(int page) {
        return homeworkDao.getHomeworkList(page);
    }

    public int getAll() {
        return homeworkDao.getAll();
    }

    public FileBean getById(String id) throws SQLException {
        return homeworkDao.getById(id);
    }
    
    public void addHomework(FileBean fileBean){
        homeworkDao.addHomework(fileBean);
    }
    public void deleteHomework(String id) {
        homeworkDao.deleteHomework(id);
    }

}
