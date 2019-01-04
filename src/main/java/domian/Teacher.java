package domian;

import java.io.Serializable;

public class Teacher implements Serializable {
	
	private int id;
	private String teacher_name;
	private String teacher_message;
	private int isLecturer;
	
	
	public int getIsLecturer() {
		return isLecturer;
	}
	public void setIsLecturer(int isLecturer) {
		this.isLecturer = isLecturer;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int id, String teacher_name, String teacher_message) {
		super();
		this.id = id;
		this.teacher_name = teacher_name;
		this.teacher_message = teacher_message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_message() {
		return teacher_message;
	}
	public void setTeacher_message(String teacher_message) {
		this.teacher_message = teacher_message;
	}
	
}
