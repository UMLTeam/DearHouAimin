package dao.Impl;


import domain.FileBean;
import utils.BeanUtil;
import utils.JDBCutils;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeworkDao {
	
    JDBCutils jdbcutil=new JDBCutils();
    
    public List<FileBean> getHomeworkList(int QueryPage) {
        String sql="select * from resources limit ?,5";
        try {
            List<Object> params=new ArrayList<>();
            params.add(QueryPage);
            List<Map<String, Object>> list= (List<Map<String, Object>>)jdbcutil.findModeResult(sql,params);
            List<FileBean> fileBean=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Map<String,Object> map=list.get(i);
                FileBean temp=new FileBean();
                temp.setId((int)map.get("id"));
                temp.setUuidname((String)map.get("uuidname"));
                temp.setRealname((String)map.get("realname"));
                temp.setSavepath((String)map.get("savepath"));
                Timestamp time = Timestamp.valueOf(map.get("timestamp").toString());//Timestamp.valueOf(()map.get("timestamp"));
 //               Object object = map.get("timestamp");
                temp.setTimestamp(time);
                temp.setDescription((String) map.get("description"));
                
                //ResultSet
                fileBean.add(temp);
            }
            return fileBean;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getAll() {
        String sql="select * from resources";
        try {
            List<Object> params=new ArrayList<>();
            List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sql,params);
            return list.size();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

	public FileBean getById(String id) throws SQLException {
		
        String sql="select * from resources where id=?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(id);
            Map<String, Object> map=jdbcutil.findSimpleResult(sql,params);
            FileBean fileBean = (FileBean) BeanUtil.convertMap(FileBean.class, map);
            return fileBean;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
	}
    
    public void addHomework(FileBean fileBean) {
        String sql="insert into resources values(null,?,?,?,?,?)";
        try {
            List<Object> params=new ArrayList<>();
            params.add(fileBean.getUuidname());
            params.add(fileBean.getRealname());
            params.add(fileBean.getSavepath());
            params.add(fileBean.getTimestamp());
            params.add(fileBean.getDescription());
            jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteHomework(String id) {
        String sql="delete from resources where id =?";
        try {
            List<Object> params=new ArrayList<>();
            params.add(id);
            jdbcutil.updateByPreparedStatement(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
