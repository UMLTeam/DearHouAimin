package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.dguterd4;
import domain.educationReformDetail4Bean;
import utils.JDBCUtil;


public class educationReformDetail4Dao {
	public List<educationReformDetail4Bean> getAll() throws Exception{
		DatabaseDao databaseDao = new DatabaseDao();
		List<educationReformDetail4Bean> dgutRewardArticles = new ArrayList<educationReformDetail4Bean>();
		String sql = "select * from dguterd4_reward where rewardState=1";
		databaseDao.query(sql);
		while(databaseDao.next()) {
			educationReformDetail4Bean dgutRewardArticle = new educationReformDetail4Bean();
			dgutRewardArticle.setId(databaseDao.getString("rewardId"));
			dgutRewardArticle.setTitle(databaseDao.getString("rewardTitle"));
			dgutRewardArticle.setTime(databaseDao.getString("rewardPublishTime"));
			dgutRewardArticle.setArticle(databaseDao.getString("rewardArticle"));

			dgutRewardArticles.add(dgutRewardArticle);
		}
		return dgutRewardArticles;
	}
	public List<educationReformDetail4Bean> getById(String id) throws Exception{
		DatabaseDao databaseDao = new DatabaseDao();
		List<educationReformDetail4Bean> dgutRewardArticles = new ArrayList<educationReformDetail4Bean>();
		String sql = "select * from dguterd4_reward where rewardId='"+id+"'";
        System.out.println(sql);
		databaseDao.query(sql);
		while(databaseDao.next()) {
			educationReformDetail4Bean dgutRewardArticle = new educationReformDetail4Bean();
			dgutRewardArticle.setId(databaseDao.getString("rewardId"));
			dgutRewardArticle.setTitle(databaseDao.getString("rewardTitle"));
			dgutRewardArticle.setTime(databaseDao.getString("rewardPublishTime"));
			dgutRewardArticle.setArticle(databaseDao.getString("rewardArticle"));
			dgutRewardArticles.add(dgutRewardArticle);
            System.out.println(dgutRewardArticle.getId());
		}
		return dgutRewardArticles;
	}

	//得到数据库连接
	private static Connection connection = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	private static DataBaseConnectionImpl dataBaseConnection = new DataBaseConnectionImpl();

	static {
//		connection = dataBaseConnection.getConnection();
	}

	//查找改革措施
	public static dguterd4 findOneEducationReformDetail4(int num) {
		connection = JDBCUtil.getConnection();
		//connection = dataBaseConnection.getConnection();
		String sql = "select * from dguterd4_reward where rewardId = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, num);
			rs = pst.executeQuery();
			dguterd4 erd4 = new dguterd4();
			if (rs.next()) {
				erd4.setDguterd4_id(rs.getInt("rewardId"));
				erd4.setDguterd4_title(rs.getString("rewardTitle"));
				erd4.setDguterd4_type(rs.getString("rewardType"));
				erd4.setDguterd4_date(rs.getDate("rewardPublishTime"));
				erd4.setDguterd4_content(rs.getString("rewardArticle"));
				erd4.setDguterd4_state(rs.getInt("rewardState"));
			}
			return erd4;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	//删除改革措施
	public static boolean deleteOneEducationReformDetail4(int num) {
		connection = JDBCUtil.getConnection();
		//connection = dataBaseConnection.getConnection();
		String sql = "delete from dguterd4_reward where rewardId = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, num);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	//插入改革措施
	public static boolean insertEducationReformDetail4(dguterd4 erd4) {
		connection = JDBCUtil.getConnection();
		//connection = dataBaseConnection.getConnection();
		String sql = "insert into dguterd4_reward(rewardTitle,rewardType,rewardPublishTime,rewardArticle,rewardState) values('" + erd4.getDguterd4_title() + "','" + erd4.getDguterd4_type() + "','" + erd4.getDguterd4_date() + "','" + erd4.getDguterd4_content() + "','" + erd4.getDguterd4_state() + "')";
		try {
			pst = connection.prepareStatement(sql);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	//修改改革措施
	public static boolean modifyEducationReformDetail4(dguterd4 erd4, int num) {
		connection = JDBCUtil.getConnection();
		//connection = dataBaseConnection.getConnection();
		String sql = "update dguterd4_reward set rewardTitle = ? , rewardType = ? , rewardPublishTime = ? , rewardArticle = ? ,rewardState = ? where rewardId=?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, erd4.getDguterd4_title());
			pst.setString(2, erd4.getDguterd4_type());
			pst.setDate(3, erd4.getDguterd4_date());
			pst.setString(4, erd4.getDguterd4_content());
			pst.setInt(5, 0);
			pst.setInt(6, num);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public static List<dguterd4> getAllSameTypeEducationReformDetail4(String type) {
		connection = JDBCUtil.getConnection();
		//connection = dataBaseConnection.getConnection();
		List<dguterd4> erd4List = new ArrayList<>();
		String sql = "select * from dguterd4_reward where rewardType = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, type);
			rs = pst.executeQuery();
			while (rs.next()) {
				dguterd4 erd4 = new dguterd4();
				erd4.setDguterd4_id(rs.getInt("rewardId"));
				erd4.setDguterd4_title(rs.getString("rewardTitle"));
				erd4.setDguterd4_type(rs.getString("rewardType"));
				erd4.setDguterd4_date(rs.getDate("rewardPublishTime"));
				erd4.setDguterd4_state(rs.getInt("rewardState"));
				erd4List.add(erd4);
			}
			return erd4List;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<dguterd4> findMeasuresName(String Name) {
		connection = JDBCUtil.getConnection();
		//connection = dataBaseConnection.getConnection();
		List<dguterd4> erd4List = new ArrayList<>();
		String sql = "select * from dguterd4_reward where rewardTitle = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, Name);
			rs = pst.executeQuery();
			while (rs.next()) {
				dguterd4 erd4 = new dguterd4();
				erd4.setDguterd4_id(rs.getInt("rewardId"));
				erd4.setDguterd4_title(rs.getString("rewardTitle"));
				erd4.setDguterd4_type(rs.getString("rewardType"));
				erd4.setDguterd4_date(rs.getDate("rewardPublishTime"));
				erd4.setDguterd4_state(rs.getInt("rewardState"));
				erd4List.add(erd4);
			}
			return erd4List;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<dguterd4> getAllEducationReformDetail4() {
		connection = JDBCUtil.getConnection();
		//connection = dataBaseConnection.getConnection();
		List<dguterd4> erd4List = new ArrayList<>();
		String sql = "select * from dguterd4_reward";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				dguterd4 erd4 = new dguterd4();
				erd4.setDguterd4_id(rs.getInt("rewardId"));
				erd4.setDguterd4_title(rs.getString("rewardTitle"));
				erd4.setDguterd4_type(rs.getString("rewardType"));
				erd4.setDguterd4_date(rs.getDate("rewardPublishTime"));
				erd4.setDguterd4_content(rs.getString("rewardArticle"));
				erd4.setDguterd4_state(rs.getInt("rewardState"));
				erd4List.add(erd4);
			}
			return erd4List;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static int getCountEducationReformDetail4() {
		connection = JDBCUtil.getConnection();
		//connection = dataBaseConnection.getConnection();
		String sql = "select * from dguterd4_reward";
		int i = 0;
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				i++;
			}
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

	public static boolean changeState(int num, int id) {
		connection = JDBCUtil.getConnection();
		//connection = dataBaseConnection.getConnection();
		String sql = "update dguterd4_reward set rewardState = ? where rewardId=?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, num);
			pst.setInt(2, id);
			if (pst.executeUpdate() == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}


	public static List<dguterd4> getAlltitleOfErd4() {
		connection = JDBCUtil.getConnection();
		//connection = dataBaseConnection.getConnection();
		List<dguterd4> erd4List = new ArrayList<>();
		String sql = "select * from dguterd4_reward GROUP BY rewardPublishTime desc,rewardId desc";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				dguterd4 erd4 = new dguterd4();
				erd4.setDguterd4_id(rs.getInt("rewardId"));
				erd4.setDguterd4_title(rs.getString("rewardTitle"));
				erd4.setDguterd4_type(rs.getString("rewardType"));
				erd4.setDguterd4_date(rs.getDate("rewardPublishTime"));
				erd4.setDguterd4_state(rs.getInt("rewardState"));
				erd4List.add(erd4);
			}
			return erd4List;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
