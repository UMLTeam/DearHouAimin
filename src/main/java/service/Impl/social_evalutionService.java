package service.Impl;


import dao.Impl.social_evalutionDao;
import domain.social_evalution;

import java.util.List;

public class social_evalutionService {
    social_evalutionDao evalutionDao = new social_evalutionDao();

    public void addEvalution(social_evalution evalution){
        evalutionDao.addEvalution(evalution);
    }

    public void deleteEvalator(String evalator_id){
        evalutionDao.deleteEvalator(evalator_id);
    }

    public List<social_evalution> getEvalatorList(int page) {
        return evalutionDao.getEvalatorList(page);
    }

    public int getEvalatorTotal() {
        return evalutionDao.getEvalatorTotal();
    }

    public boolean editStatus(int evalutionId, int status){
        return evalutionDao.editStatus(evalutionId,status);
    }
    public social_evalution getSocialevalutionById(String id){
        return evalutionDao.getSocialevalutionById(id);
    }
}
