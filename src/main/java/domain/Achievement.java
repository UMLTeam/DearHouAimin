package domain;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Achievement {
	private Integer achievement_id;
	private String title;
	private Timestamp publish_time;
	private List<AchievementItem> achievementItems;

	public Integer getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(Integer achievement_id) {
		this.achievement_id = achievement_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public List<AchievementItem> getAchievementItems() {
		return achievementItems;
	}

	public void setAchievementItems(List<AchievementItem> achievementItems) {
		this.achievementItems = achievementItems;
	}

	public String getPublish_time() {
		return publish_time.toString();
	}

	public void setPublish_time(Timestamp publish_time) {
		this.publish_time = publish_time;
	}
	
	@Override
	public String toString() {
		 return "{address: \"/educationReformDetail3Action?type=show&id="+achievement_id.toString()+"\", id: \""+achievement_id.toString()+"\", time: \""+publish_time.toString().substring(0,10)+"\", title: \""+title+"\"}";
	}
}
