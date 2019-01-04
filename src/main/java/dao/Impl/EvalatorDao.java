package dao.Impl;

import domain.Online_Evalator;
import utils.JDBCutils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//
public class EvalatorDao {
    JDBCutils jdbcutil=new JDBCutils();
    public List<Online_Evalator> getEvalatorList(int QueryPage) {
        String sql="select * from online_evalator limit ?,5";
        try {
            List<Object> params=new ArrayList<>();
            params.add(QueryPage);
            List<Map<String, Object>> list= (List<Map<String, Object>>)jdbcutil.findModeResult(sql,params);
            List<Online_Evalator> evalators=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Map<String,Object> map=list.get(i);
                Online_Evalator temp=new Online_Evalator();
                temp.setEvalator_id((String)map.get("evalator_id"));
                temp.setCourse_teacher_name((String)map.get("course_teacher_name"));
                temp.setCourse_time((String)map.get("course_time"));
                temp.setCourse_name((String)map.get("course_name"));
                temp.setCourse_property((String)map.get("course_property"));
                temp.setCourse_grade((Double) map.get("course_grade"));
                temp.setCourse_level((String)map.get("course_level"));
                evalators.add(temp);
            }
            return evalators;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getEvalatorTotal() {
        String sql="select * from online_evalator";
        try {
            List<Object> params=new ArrayList<>();
            List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sql,params);
            return list.size();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addEvalator(Online_Evalator evalator) {
        String sql="insert into online_evalator values(?,?,?,?,?,?,?)";
        try {
            List<Object> params=new ArrayList<>();
            params.add(evalator.getEvalator_id());
            params.add(evalator.getCourse_teacher_name());
            params.add(evalator.getCourse_time());
            params.add(evalator.getCourse_name());
            params.add(evalator.getCourse_property());
            params.add(evalator.getCourse_grade());
            params.add(evalator.getCourse_level());
            jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteEvalator(String evalator_id) {
        String sql="delete from online_evalator where evalator_id =?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(evalator_id);
            jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    //测试一下
}
