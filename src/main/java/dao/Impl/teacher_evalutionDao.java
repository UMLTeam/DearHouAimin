package dao.Impl;

import domain.teacher_evalution;
import utils.JDBCutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class teacher_evalutionDao {
    JDBCutil jdbcutil = new JDBCutil();

    public int addEvalution(teacher_evalution evaluation){
        String sql = "insert into teacher_evalution values(NULL,?,?,?,?,0)";
        List<Object> params = new ArrayList<>();

        params.add(evaluation.getEvalutionTitle());
        params.add(evaluation.getTeacherName());
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

    public List getAll() {
        String sql="select * from teacher_evalution";
        try {
            List<Object> params=new ArrayList<>();
            List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sql,params);
            return list;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteEvalator(String evalator_id) {
        String sql="delete from teacher_evalution where evalutionId =?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(evalator_id);
            jdbcutil.updateByPreparedStatement(sql,params);
            System.out.println("deleted");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<teacher_evalution> getEvalatorList(int QueryPage) {
        String sql="select * from teacher_evalution limit ?,5";
        try {
            List<Object> params=new ArrayList<>();
            params.add(QueryPage);
            List<Map<String, Object>> list= (List<Map<String, Object>>)jdbcutil.findModeResult(sql,params);
            List<teacher_evalution> evalators=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Map<String,Object> map=list.get(i);
                teacher_evalution temp=new teacher_evalution();
                temp.setEvalutionId((int)map.get("evalutionId"));
                temp.setEvalutionTitle((String)map.get("evalutionTitle"));
                temp.setTeacherName((String)map.get("teacherName"));
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
        String sql="select * from teacher_evalution";
        try {
            List<Object> params=new ArrayList<>();
            List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sql,params);
            return list.size();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean editStatus(int evalutionId, int status){
        String sql = "update teacher_evalution set status=? where evalutionId=?";
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
