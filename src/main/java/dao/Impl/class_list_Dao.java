package dao.Impl;

//查找，优化删除，优化增加

import domain.Class_List;
import utils.BeanUtil;
import utils.JDBCutil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

////
public class class_list_Dao {
	JDBCutil jdbcutil = new JDBCutil();

	public Class_List getById(String class_id) throws SQLException {
		String sql = "select * from class_list where class_id=?";
		try {
			List<Object> params = new ArrayList<>();
			params.add(class_id);
			Map<String, Object> map = jdbcutil.findSimpleResult(sql, params);
			Class_List class_List = (Class_List) BeanUtil.convertMap(Class_List.class, map);
			return class_List;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Class_List> getClassLists(int QueryPage) {
		String sql = "select * from class_list limit ?,5";
		try {
			List<Object> params = new ArrayList<>();
			params.add(QueryPage);
			List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcutil.findModeResult(sql, params);
			List<Class_List> class_Lists = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				Class_List temp = new Class_List();
				temp.setClass_id((Long) map.get("class_id"));
				temp.setClass_name((String) map.get("class_name"));
				temp.setMajor((String) map.get("major"));
				temp.setCourse((String) map.get("course"));
				String class_file_name = (String) map.get("class_file_name");
				// class_file_name=class_file_name.substring(0,class_file_name.lastIndexOf("."));
				temp.setClass_file_name(class_file_name);
				temp.setClass_file_uuidname((String)map.get("class_file_uuidname"));
				temp.setClass_file((String) map.get("class_file"));
				class_Lists.add(temp);
			}
			return class_Lists;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	public void addClassList(Class_List class_List) {
		String sql = "insert into class_list(class_name,major,course,class_file_name,class_file_uuidname,class_file) values(?,?,?,?,?,?)";// file
		try {
			List<Object> params = new ArrayList<>();
			params.add(class_List.getClass_name());
			params.add(class_List.getMajor());
			params.add(class_List.getCourse());
			params.add(class_List.getClass_file_name());
			params.add(class_List.getClass_file_uuidname());
			params.add(class_List.getClass_file());
			// file
			jdbcutil.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	// //根据关键字找班级名单。
	// public List<Class_List> searchByKey(String key){
	// int i;
	// List<Class_List> class_Lists=new ArrayList<Class_List>();
	// String sqlString="select * from class_list where class_name like
	// '%"+key+"%'";
	// try {
	// List<Object> params=new ArrayList<>();
	// List<Map<String, Object>> list= (List<Map<String, Object>>)
	// jdbcutil.findModeResult(sqlString,params);
	// for(i=0;i<list.size();i++){
	// Class_List class_list=new Class_List();
	// Map<String, Object> map=(Map<String, Object>)list.get(i);
	// class_list=(Class_List) BeanUtil.convertMap(Class_List.class, map);
	// class_Lists.add(class_list);
	// }
	// return class_Lists;
	// }catch (Exception e){
	// throw new RuntimeException(e.getMessage());
	// }
	// }
	// 查询全部班级名单
	public int getClassListTotal() {
		String sql = "select * from class_list";
		try {
			List<Object> params = new ArrayList<>();
			List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcutil.findModeResult(sql, params);
			return list.size();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	// //查询全部班级名单
	// public List<Class_List> showAll(){
	// int i;
	// List<Class_List> class_Lists=new ArrayList<Class_List>();
	// String sqlString="select * from class_list";
	// try {
	// List<Object> params=new ArrayList<>();
	// List<Map<String, Object>> list= (List<Map<String, Object>>)
	// jdbcutil.findModeResult(sqlString,params);
	// for(i=0;i<list.size();i++){
	// Class_List class_list=new Class_List();
	// Map<String, Object> map=(Map<String, Object>)list.get(i);
	// class_list=(Class_List) BeanUtil.convertMap(Class_List.class, map);
	// class_Lists.add(class_list);
	// }
	// return class_Lists;
	// }catch (Exception e){
	// throw new RuntimeException(e.getMessage());
	// }
	// }
	// 删除班级名单，->删除多个
	public void deleteClassList(String class_id) {
		String sql = "delete from class_list where class_id =?";
		try {
			List<Object> params = new ArrayList<>();
			params.add(class_id);
			jdbcutil.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	public List<Class_List> searchByName(String name) {
		String sql = "select * from class_list where class_name like '%" + name + "%' ";
		try {
			List<Object> params = new ArrayList<>();
			// params.add(name);
			// jdbcutil.findSimpleResult(sql,params);
			List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcutil.findModeResult(sql, params);
			List<Class_List> class_Lists = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				Class_List temp = new Class_List();
				temp.setClass_id((Long) map.get("class_id"));
				temp.setClass_name((String) map.get("class_name"));
				temp.setMajor((String) map.get("major"));
				temp.setCourse((String) map.get("course"));
				String class_file_name = (String) map.get("class_file_name");
				//class_file_name = class_file_name.substring(0, class_file_name.lastIndexOf("."));
				temp.setClass_file_name(class_file_name);
				temp.setClass_file_uuidname((String)map.get("class_file_uuidname"));
				temp.setClass_file((String) map.get("class_file"));
				class_Lists.add(temp);
			}
			return class_Lists;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}