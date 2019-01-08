package dao.Impl;
//跟class_list_Dao一样，考虑合并

import domain.Class_List;
import utils.BeanUtil;
import utils.JDBCutils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class grade_list_Dao {
JDBCutils jdbcutil=new JDBCutils();
	
	//?界面显示添加的信息-》返回值    ！！分页等下再来
	public int add(Class_List class_list){
		String sqlString="insert into class_list values(null,?,?,?)";
		try {
			List<Object> params=new ArrayList<>();
			params.add(class_list.getClass_name());
			params.add(class_list.getMajor());
			params.add(class_list.getCourse());
			if(jdbcutil.updateByPreparedStatement(sqlString,params)){
				//return class_list;
				return 1;//添加成功
			}
			return 0;//添加失败
	    }catch (Exception e){
	            throw new RuntimeException(e.getMessage());
	    }
	}
	//根据关键字找班级名单。
	public List<Class_List> searchByKey(String key){
		int i;
		List<Class_List> class_Lists=new ArrayList<Class_List>();
		String sqlString="select * from class_list where class_name like '%"+key+"%'";
		try {
			List<Object> params=new ArrayList<>();
			List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sqlString,params);
			for(i=0;i<list.size();i++){
				Class_List class_list=new Class_List();
				Map<String, Object> map=(Map<String, Object>)list.get(i);
				class_list=(Class_List) BeanUtil.convertMap(Class_List.class, map);
				class_Lists.add(class_list);
			}
			return class_Lists;
	    }catch (Exception e){
	            throw new RuntimeException(e.getMessage());
	    }
	}
	
	//查询全部班级名单
	public List<Class_List> showAll(){
		int i;
		List<Class_List> class_Lists=new ArrayList<Class_List>();
		String sqlString="select * from class_list";
		try {
			List<Object> params=new ArrayList<>();
			List<Map<String, Object>> list= (List<Map<String, Object>>) jdbcutil.findModeResult(sqlString,params);
			for(i=0;i<list.size();i++){
				Class_List class_list=new Class_List();
				Map<String, Object> map=(Map<String, Object>)list.get(i);
				class_list=(Class_List) BeanUtil.convertMap(Class_List.class, map);
				class_Lists.add(class_list);
			}
			return class_Lists;
	    }catch (Exception e){
	            throw new RuntimeException(e.getMessage());
	    }
	}
	//删除班级名单，！暂时用本系统的
	public int deletes(String ids){
		if(ids!=null && ids.length()>0){
			String sqlString= "delete from class_list where class_id in ("+ids+")";
			try {
				List<Object> params=new ArrayList<>();
				if(jdbcutil.updateByPreparedStatement(sqlString,params)){
					//return class_list;
					return 1;//添加成功
				}
				return 0;//添加失败
		    }catch (Exception e){
		            throw new RuntimeException(e.getMessage());
		    }
		}else
			return -1;
		
	}
}
