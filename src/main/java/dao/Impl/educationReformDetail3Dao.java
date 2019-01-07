package dao.Impl;

import domain.Achievement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class educationReformDetail3Dao {

	public List<Achievement> getAllAchievements() throws SQLException {
		List<Achievement> achievements = new ArrayList<Achievement>();
		String sqlSelect = "select * from dguterd3_achievement";
		Database3Dao database3Dao = new Database3Dao();
		achievementItemDao achievementItemDao = new achievementItemDao();
		System.out.println(sqlSelect);
		database3Dao.query(sqlSelect);
		while (database3Dao.next()) {
			Achievement achievement = new Achievement();
			achievement.setAchievement_id(database3Dao.getInt("achievement_id"));
			achievement.setPublish_time(database3Dao.getTimestamp("publish_time"));
			achievement.setTitle(database3Dao.getString("title"));
			achievement.setAchievementItems(
					achievementItemDao.getAchievementItemById(database3Dao.getInt("achievement_id")));
			achievements.add(achievement);
		}
		return achievements;
	}
	public void deleteAchievement(Integer achievement_id) throws SQLException{
		Database3Dao database3Dao = new Database3Dao();
		String sql="delete from dguterd3_achievement where achievement_id="+achievement_id.toString();
		database3Dao.update(sql);
	}
	
	public void updateAchievement(Integer achievement_id,String title,String publish_time) throws SQLException{
		Database3Dao database3Dao = new Database3Dao();
		String sql="UPDATE dguterd3_achievement set title='"+title+"',publish_time='"+ publish_time+"' where achievement_id="+achievement_id.toString();
		System.out.println(sql);
		database3Dao.update(sql);
	}
	
	public void insertAchievement(String title,String publish_time) throws SQLException{
		Database3Dao database3Dao = new Database3Dao();
		String sql="insert into dguterd3_achievement(title,publish_time) values('"+title+"','"+publish_time+"')";
		database3Dao.update(sql);
	}
	
	
	public List<Achievement> findAchievementByTitle(String title) throws SQLException {
		List<Achievement> achievements = new ArrayList<Achievement>();
		String sqlSelect = "select * from dguterd3_achievement where title like '%"+title+"%'";
		Database3Dao database3Dao = new Database3Dao();
		achievementItemDao achievementItemDao = new achievementItemDao();
		System.out.println(sqlSelect);
		database3Dao.query(sqlSelect);
		while (database3Dao.next()) {
			Achievement achievement = new Achievement();
			achievement.setAchievement_id(database3Dao.getInt("achievement_id"));
			achievement.setPublish_time(database3Dao.getTimestamp("publish_time"));
			achievement.setTitle(database3Dao.getString("title"));
			achievement.setAchievementItems(
					achievementItemDao.getAchievementItemById(database3Dao.getInt("achievement_id")));
			achievements.add(achievement);
		}
		return achievements;
	}
}
