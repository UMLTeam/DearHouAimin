package dao.Impl;

import domain.AchievementItem;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class achievementItemDao {
	private static Connection connection = null;
	private static PreparedStatement pst = null;
	private static ResultSet database3Dao = null;
	public List<AchievementItem> getAchievementItemById(Integer achievement_id) throws SQLException {



		List<AchievementItem> items = new ArrayList<AchievementItem>();
//		Database3Dao database3Dao = new Database3Dao();
		String selectSQL = "select * from dguterd3_achievementItem where achievement_id=" + achievement_id.toString();

		connection = JDBCUtil.getConnection();
		pst = connection.prepareStatement(selectSQL);
		database3Dao = pst.executeQuery();

//		database3Dao.query(selectSQL);
		while (database3Dao.next()) {
			AchievementItem item = new AchievementItem();
			item.setAchievement_id(achievement_id);
			item.setAuthor(database3Dao.getString("author"));
			item.setTitle(database3Dao.getString("title"));
			item.setPublish_time(database3Dao.getTimestamp("publish_time"));
			item.setPublication(database3Dao.getString("publication"));
			item.setId(database3Dao.getInt("id"));
			items.add(item);
		}
		return items;
	}
	public void deleteAchievementItem(String id) throws SQLException{
//		Database3Dao database3Dao = new Database3Dao();
		String sql="delete from dguterd3_achievementItem where id="+id;

		connection = JDBCUtil.getConnection();
		pst = connection.prepareStatement(sql);
		int result = pst.executeUpdate();

//		database3Dao.update(sql);
	}
	
	public void insertAchievementItem(String achievement_id, String title, String author, String publish_time,String publication) throws SQLException{
//		Database3Dao database3Dao = new Database3Dao();
		String sql="insert into dguterd3_achievementItem (achievement_id,title,author,publish_time,publication) VALUES ("+achievement_id+",'"+title+"','"+author+"','"+publish_time+"','"+publication+"')";
//		database3Dao.update(sql);

		connection = JDBCUtil.getConnection();
		pst = connection.prepareStatement(sql);
		int result = pst.executeUpdate();
	}
	
	public void updateAchievementItem(String id, String title, String author, String publish_time,String publication) throws SQLException{
//		Database3Dao database3Dao = new Database3Dao();
		String sql="update dguterd3_achievementItem set"+" title='"+title+"',author='"+author+"',publish_time='"+publish_time+"',publication='"+publication+"' where id="+id;
//		database3Dao.update(sql);

		connection = JDBCUtil.getConnection();
		pst = connection.prepareStatement(sql);
		int result = pst.executeUpdate();
	}
}
