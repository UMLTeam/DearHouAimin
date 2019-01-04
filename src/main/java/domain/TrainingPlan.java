package domain;

public class TrainingPlan {
	private int id;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TrainingPlan(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public TrainingPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
