package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.impl.DBConnectionImpl;
import domian.ErrorMess;
import domian.Resource;

public class TeachingExperimentMissionService implements IAddTeachingVideoService {
	/**
	 * 添加教学资源——教学任务
	 * @param res
	 * @throws ErrorMess
	 */
	public static void add(Resource res) throws ErrorMess {
		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = "insert into course (resName,resTime,resPath,resType,resTag,isCheck) values (?,?,?,?,?,?)";
			PreparedStatement ps = null;
			assert con != null;
			ps = con.prepareStatement(sql);
			ps.setString(1, res.getResName());
			ps.setString(2, res.getResTime().toString());
			ps.setString(3, res.getResPath());
			ps.setString(4, res.getResType());
			ps.setString(5, res.getResTag());
			ps.setString(6, res.getIsCheck());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorMess("添加教学任务出错！");
		}
	}
	/**
	 * 删除教学资源——教学任务
	 * @param res
	 * @throws ErrorMess
	 */
	public static void delete(Resource res) throws ErrorMess {
		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = "delete from course where id=?";
			PreparedStatement ps = null;
			assert con != null;
			ps = con.prepareStatement(sql);
			ps.setString(1, String.valueOf(res.getId()));
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorMess("删除教学任务出错！");
		}
	}
	/**
	 * 查找教学资源——教学任务
	 * @param res
	 * @throws ErrorMess
	 */
	public static ArrayList<Resource> queryAll() throws ErrorMess {
		try {
			Connection con = DBConnectionImpl.getConnection();
			ArrayList<Resource> resList = new ArrayList<Resource>();
			String sql = "select * from course";
			PreparedStatement ps = null;
			assert con != null;
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Resource res = new Resource();
			while(rs.next()){
				res.setId(rs.getInt("id"));
				res.setResName(rs.getString("resName"));
				res.setResPath(rs.getString("resPath"));
				res.setResTime(rs.getTimestamp("resTime"));
				res.setResType(rs.getString("resType"));
				res.setIsCheck(rs.getString("isCheck"));
				res.setResTag(rs.getString("resTag"));
				resList.add(res);
			}
			ps.close();
			con.close();
			return resList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorMess("查找教学任务出错！");
		}
	}
}
