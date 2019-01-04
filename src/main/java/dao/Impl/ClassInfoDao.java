package dao.Impl;

import domain.ClassInfo;
import utils.JDBCutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassInfoDao {
    JDBCutil jdbcutil=new JDBCutil();
    public List<ClassInfo> getClassInfoList(int QueryPage) {
        String sql="select * from classInfo limit ?,5";
        try {
            List<Object> params=new ArrayList<>();
            params.add(QueryPage);
            List<Map<String, Object>> list= (List<Map<String, Object>>)jdbcutil.findModeResult(sql,params);
            List<ClassInfo> classInfos=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Map<String,Object> map=list.get(i);
                ClassInfo temp=new ClassInfo();
                temp.setClass_name((String)map.get("class_name"));
                temp.setSpecialty((String)map.get("specialty"));
                temp.setCourse_name((String)map.get("course_name"));
                classInfos.add(temp);
            }
            return classInfos;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getClassInfoTotal() {
        String sql="select * from classInfo";
        try {
            List<Object> params=new ArrayList<>();
            List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sql,params);
            return list.size();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addEvaClassInfo(ClassInfo classInfo) {
        String sql="insert into classInfo values(?,?,?)";
        try {
            List<Object> params=new ArrayList<>();
            params.add(classInfo.getClass_name());
            params.add(classInfo.getSpecialty());
            params.add(classInfo.getCourse_name());
            jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteClassInfo(String class_name) {
        String sql="delete from classInfo where class_name =?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(class_name);
            jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
