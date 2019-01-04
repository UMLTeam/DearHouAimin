package service.Impl;

import dao.Impl.Expert_EvaluationDao;
import domain.Expert_Evaluation;

import java.util.List;

public class Expert_EvaluationService {
    Expert_EvaluationDao expert_evaluationDao = new Expert_EvaluationDao();
    public void addContent(Expert_Evaluation evaluation) {
        expert_evaluationDao.addContent(evaluation);
        return;
    }
    public void editContent(Expert_Evaluation evaluation) {
        expert_evaluationDao.editContent(evaluation);
        return;
    }

    public Expert_Evaluation getContentById(String id){
        return expert_evaluationDao.getContentById(id);
    }

    public void deleteContent(String id){
        expert_evaluationDao.deleteContent(id);
        return;
    }
    public List<Expert_Evaluation> getEvaluationList(int page, String type) {
        return expert_evaluationDao.getEvaluationList(page, type);
    }

    public int getEvaluationTotal(String type) {
        return expert_evaluationDao.getEvaluationTotal(type);
    }

    public Expert_Evaluation getOneEvaluation(int number, String type){
        return expert_evaluationDao.getOneEvaluation(number, type);
    }
}
