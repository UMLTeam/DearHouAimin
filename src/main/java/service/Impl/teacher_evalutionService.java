package service.Impl;


import dao.Impl.teacher_evalutionDao;
import domain.teacher_evalution;

import java.util.List;

public class teacher_evalutionService {
    teacher_evalutionDao evalutionDao = new teacher_evalutionDao();

    public void addEvalution(teacher_evalution evalution){
        evalutionDao.addEvalution(evalution);
    }

    public List getAll(){
        return evalutionDao.getAll();
    }

    public void deleteEvalator(String evalator_id){
        evalutionDao.deleteEvalator(evalator_id);
    }

    public List<teacher_evalution> getEvalatorList(int page) {
        return evalutionDao.getEvalatorList(page);
    }

    public int getEvalatorTotal() {
        return evalutionDao.getEvalatorTotal();
    }

    public boolean editStatus(int evalutionId, int status){
        return evalutionDao.editStatus(evalutionId,status);
    }

}
