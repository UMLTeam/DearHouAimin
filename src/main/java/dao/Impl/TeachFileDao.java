package dao.Impl;


import domain.TeachEvalFile;
import utils.BeanUtil;
import utils.JDBCutil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeachFileDao {
	
    JDBCutil jdbcutil=new JDBCutil();
    
    public List<TeachEvalFile> getHomeworkList(int QueryPage) {
        String sql="select * from teachfile limit ?,5";
        try {
            List<Object> params=new ArrayList<>();
            params.add(QueryPage);
            List<Map<String, Object>> list= (List<Map<String, Object>>)jdbcutil.findModeResult(sql,params);
            List<TeachEvalFile> TeachEvalFile=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Map<String,Object> map=list.get(i);
                domain.TeachEvalFile temp=new TeachEvalFile();
                temp.setId((int)map.get("id"));
                temp.setUuidname((String)map.get("uuidname"));
                temp.setRealname((String)map.get("realname"));
                temp.setSavepath((String)map.get("savepath"));
                Timestamp time = Timestamp.valueOf(map.get("timestamp").toString());//Timestamp.valueOf(()map.get("timestamp"));
 //               Object object = map.get("timestamp");
                temp.setTimestamp(time);
                temp.setDescription((String) map.get("description"));
                
                //ResultSet
                TeachEvalFile.add(temp);
            }
            return TeachEvalFile;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getAll() {
        String sql="select * from teachfile";
        try {
            List<Object> params=new ArrayList<>();
            List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sql,params);
            return list.size();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

	public TeachEvalFile getById(String id) throws SQLException {
		
        String sql="select * from teachfile where id=?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(id);
            Map<String, Object> map=jdbcutil.findSimpleResult(sql,params);
            TeachEvalFile TeachEvalFile = (domain.TeachEvalFile) BeanUtil.convertMap(domain.TeachEvalFile.class, map);
            return TeachEvalFile;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
	}
    
    public void addHomework(TeachEvalFile TeachEvalFile) {
        String sql="insert into teachfile values(null,?,?,?,?,?)";
        try {
            List<Object> params=new ArrayList<>();
            params.add(TeachEvalFile.getUuidname());
            params.add(TeachEvalFile.getRealname());
            params.add(TeachEvalFile.getSavepath());
            params.add(TeachEvalFile.getTimestamp());
            params.add(TeachEvalFile.getDescription());
            jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteHomework(String id) {
        String sql="delete from teachfile where id =?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(id);
            jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}