package service.Impl;

import dao.Impl.achievementItemDao;
import dao.Impl.educationReformDetail3Dao;
import domain.Achievement;

import java.sql.SQLException;
import java.util.List;


public class educationReformDetail3Service {
	public List<Achievement> getAllAchievements() throws SQLException {
		educationReformDetail3Dao dao = new educationReformDetail3Dao();
		return dao.getAllAchievements();
	}
	
	public void deleteAchievement(Integer achievement_id) throws SQLException{
		educationReformDetail3Dao dao = new educationReformDetail3Dao();
		dao.deleteAchievement(achievement_id);
	}
	
	public void updateAchievement(Integer achievement_id,String title,String publish_time) throws SQLException{
		educationReformDetail3Dao dao = new educationReformDetail3Dao();
		dao.updateAchievement(achievement_id, title,publish_time);
	}
	
	public void insertAchievement(String title,String publish_time) throws SQLException{
		educationReformDetail3Dao dao = new educationReformDetail3Dao();
		dao.insertAchievement(title, publish_time);
	}
	
	public List<Achievement> findAchievementByTitle(String title) throws SQLException{
		educationReformDetail3Dao dao = new educationReformDetail3Dao();
		List<Achievement> achievements=dao.findAchievementByTitle(title);
		return achievements;
	}
	
	public void deleteAchievementItem(String id) throws SQLException{
		achievementItemDao dao = new achievementItemDao();
		dao.deleteAchievementItem(id);
	}
	
	public void insertAchievementItem(String achievement_id, String title, String author, String publish_time,String publication) throws SQLException {
		achievementItemDao dao = new achievementItemDao();
		dao.insertAchievementItem(achievement_id, title, author, publish_time, publication);
	}
	
	public void updateAchievementItem(String id, String title, String author, String publish_time,String publication) throws SQLException{
		achievementItemDao dao = new achievementItemDao();
		dao.updateAchievementItem(id, title, author, publish_time, publication);
	}
}
