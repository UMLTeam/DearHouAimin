package domain;

import java.sql.Timestamp;

public class AchievementItem {
	private Integer achievement_id;
	private String title;
	private String author;
	private Timestamp publish_time;
	private String publication;
	private Integer id;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublication() {
		return publication;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public Timestamp getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Timestamp publish_time) {
		this.publish_time = publish_time;
	}


}
