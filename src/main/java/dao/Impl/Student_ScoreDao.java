package dao.Impl;


import domain.Student_Score;
import utils.JDBCutils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student_ScoreDao {
    JDBCutils jdbcutil=new JDBCutils();
    public List<Student_Score> getEvalatorList(int QueryPage) {
        String sql="select * from student_score limit ?,5";
        try {
            List<Object> params=new ArrayList<>();
            params.add(QueryPage);
            List<Map<String, Object>> list= (List<Map<String, Object>>)jdbcutil.findModeResult(sql,params);
            List<Student_Score> students=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Map<String,Object> map=list.get(i);
                Student_Score temp=new Student_Score();
                temp.setStudentName((String)map.get("StudentName"));
                temp.setStudentNo((String)map.get("StudentNo"));
                temp.setClassName((String)map.get("ClassName"));
                temp.setCourse((String)map.get("course"));
                temp.setMajor((String)map.get("major"));
                if(map.get("score")==null ||"".equals(map.get("score"))){
                    temp.setScore(-1);
                }else{
                    temp.setScore((Double) map.get("score"));
                }
                //System.out.println(map.get("score"));
                students.add(temp);
            }
            return students;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getEvalatorTotal() {
        String sql="select * from student_score";
        try {
            List<Object> params=new ArrayList<>();
            List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sql,params);
            return list.size();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addEvalator(Student_Score student) {
        String sql="insert into student_score values(?,?,?,?,?,?)";
        try {
            List<Object> params=new ArrayList<>();
            params.add(student.getStudentNo());
            params.add(student.getStudentName());
            params.add(student.getMajor());
            params.add(student.getClassName());
            params.add(student.getCourse());
            params.add(student.getScore());
            jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteEvalator(String StudentNo) {
        String sql="delete from student_score where StudentNo =?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(StudentNo);
            jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public boolean modifyStudnt(String StudentNo,double score){
        String sql="UPDATE student_score SET score=? WHERE StudentNo= ?";
        boolean flag;
        try {
            List<Object> params=new ArrayList<>();
            params.add(score);
            params.add(StudentNo);
            flag=jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return flag;
    }
    public List<Student_Score> selectStudent(String studentNo, int pages){

        String sql="SELECT * FROM student_score WHERE StudentNo=? limit ?,5";
        try {
            List<Object> params=new ArrayList<>();
            params.add(studentNo);
            params.add(pages);
            List<Map<String, Object>> list= (List<Map<String, Object>>)jdbcutil.findModeResult(sql,params);
            List<Student_Score> students=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Map<String,Object> map=list.get(i);
                Student_Score temp=new Student_Score();
                temp.setStudentName((String)map.get("StudentName"));
                temp.setStudentNo((String)map.get("StudentNo"));
                temp.setClassName((String)map.get("ClassName"));
                temp.setCourse((String)map.get("course"));
                temp.setMajor((String)map.get("major"));
                if(map.get("score")==null ||"".equals(map.get("score"))){
                    temp.setScore(-1);
                }else{
                    temp.setScore((Double) map.get("score"));
                }
                students.add(temp);
            }
            return students;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
    public int getOneStudentTotal(String studentNo) {
        String sql="select * from student_score WHERE StudentNo=?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(studentNo);
            List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sql,params);
            return list.size();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
