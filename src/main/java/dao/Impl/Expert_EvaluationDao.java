package dao.Impl;

import domain.Expert_Evaluation;
import utils.JDBCutils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Expert_EvaluationDao {
    JDBCutils jdbcutil = new JDBCutils();

    public int addContent(Expert_Evaluation evaluation) {
        String sql = "insert into expert_evaluation values(?,?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(evaluation.getEvaluation_id());
        params.add(evaluation.getTitle());
        params.add(evaluation.getType());
        params.add(evaluation.getContent());
        params.add(evaluation.getTime());
        try {
            jdbcutil.updateByPreparedStatement(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return 1;
    }

    public Expert_Evaluation getContentById(String id) {
        String sql = "select * from expert_evaluation where id=?";
        try {
            List<Object> params = new ArrayList<>();
            params.add(id);
            List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcutil.findModeResult(sql, params);
            for (Map<String, Object> map : list) {
                Expert_Evaluation expert_evaluation = new Expert_Evaluation();
                expert_evaluation.setEvaluation_id((String) map.get("id"));
                expert_evaluation.setTitle((String) map.get("title"));
                expert_evaluation.setType((String) map.get("type"));
                expert_evaluation.setContent((String) map.get("content"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM");
                String time = simpleDateFormat.format(map.get("time"));
                expert_evaluation.setTime(time);
                return expert_evaluation;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    public void deleteContent(String id) {
        String sql = "DELETE FROM expert_evaluation WHERE id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        try {
            jdbcutil.updateByPreparedStatement(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int editContent(Expert_Evaluation evaluation) {
        String sql = "update expert_evaluation set title=?, type=?, content=?, time=? where id=?";
        List<Object> params = new ArrayList<>();
        params.add(evaluation.getTitle());
        params.add(evaluation.getType());
        params.add(evaluation.getContent());
        params.add(evaluation.getTime());
        params.add(evaluation.getEvaluation_id());
        try {
            jdbcutil.updateByPreparedStatement(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return 1;
    }

    public List<Expert_Evaluation> getEvaluationList(int QueryPage, String type) {
        String sql = null;
        List<Object> params = new ArrayList<>();
        if ("0".equals(type)) {
            sql = "select * from expert_evaluation limit ?,5";
        } else {
            sql = "select * from expert_evaluation where type=? limit ?,5";
            params.add(type);
        }
        try {
            params.add(QueryPage);
            List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcutil.findModeResult(sql, params);
            List<Expert_Evaluation> evaluation = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                Expert_Evaluation temp = new Expert_Evaluation();
                temp.setEvaluation_id((String) map.get("id"));
                temp.setTitle((String) map.get("title"));
                temp.setType((String) map.get("type"));
                temp.setContent((String) map.get("content"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM");
                String time = simpleDateFormat.format(map.get("time"));
                temp.setTime(time);
                evaluation.add(temp);
            }
            return evaluation;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getEvaluationTotal(String type) {
        String sql = null;
        List<Object> params = new ArrayList<>();
        if ("0".equals(type)) {
            sql = "select * from expert_evaluation";
        } else {
            sql = "select * from expert_evaluation where type=?";
            params.add(type);
        }
        try {

            List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcutil.findModeResult(sql, params);
            return list.size();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Expert_Evaluation getOneEvaluation(int number, String type) {
        String sql = null;
        List<Object> params = new ArrayList<>();
        sql = "select * from expert_evaluation where type=? limit ?,1";
        try {
            params.add(type);
            params.add(number);
            List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcutil.findModeResult(sql, params);
            Expert_Evaluation evaluation = new Expert_Evaluation();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                evaluation.setEvaluation_id((String) map.get("id"));
                evaluation.setTitle((String) map.get("title"));
                evaluation.setType((String) map.get("type"));
                evaluation.setContent((String) map.get("content"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM");
                String time = simpleDateFormat.format(map.get("time"));
                evaluation.setTime(time);
            }
            return evaluation;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
