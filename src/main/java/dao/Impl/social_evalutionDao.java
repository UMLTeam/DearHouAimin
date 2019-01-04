package dao.Impl;

import domain.social_evalution;
import utils.JDBCutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class social_evalutionDao {
    JDBCutil jdbcutil = new JDBCutil();

    public int addEvalution(social_evalution evaluation){
        String sql = "insert into social_evalution values(NULL,?,?,?,0)";
        List<Object> params = new ArrayList<>();

        params.add(evaluation.getEvalutionTitle());

        params.add(evaluation.getContent());
        params.add(evaluation.getEvalutionTime());

        try {
            System.out.println(params);
            jdbcutil.updateByPreparedStatement(sql, params);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return 1;
    }


    public void deleteEvalator(String evalator_id) {
        String sql="delete from social_evalution where evalutionId =?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(evalator_id);
            jdbcutil.updateByPreparedStatement(sql,params);
            System.out.println("deleted");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<social_evalution> getEvalatorList(int QueryPage) {
        String sql="select * from social_evalution limit ?,5";
        try {
            List<Object> params=new ArrayList<>();
            params.add(QueryPage);
            List<Map<String, Object>> list= (List<Map<String, Object>>)jdbcutil.findModeResult(sql,params);
            List<social_evalution> evalators=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Map<String,Object> map=list.get(i);
                social_evalution temp=new social_evalution();
                temp.setEvalutionId((int)map.get("evalutionId"));
                temp.setEvalutionTitle((String)map.get("evalutionTitle"));
                temp.setContent((String)map.get("content"));
                temp.setEvalutionTime((String)map.get("evalutionTime"));
                temp.setStatus((int)map.get("status"));
                evalators.add(temp);
            }
            return evalators;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getEvalatorTotal() {
        String sql="select * from social_evalution";
        try {
            List<Object> params=new ArrayList<>();
            List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sql,params);
            return list.size();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean editStatus(int evalutionId, int status){
        String sql = "update social_evalution set status=? where evalutionId=?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(status);
            params.add(evalutionId);
            return jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }


}
