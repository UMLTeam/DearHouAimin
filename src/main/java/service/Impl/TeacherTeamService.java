package service.Impl;

import java.util.List;

import dao.Impl.TeacherTeamDao;
import domain.CourseManager;
import domain.Teacher;
import domain.TrainingPlan;



public class TeacherTeamService {
	
	private TeacherTeamDao teacherdao = new TeacherTeamDao();
	
	public CourseManager getCourseManagerMessage() {
			return teacherdao.getCourseManagerMessage();
	}

	public TrainingPlan getTrainingPlan() {
		// TODO Auto-generated method stub
		return teacherdao.getTrainingPlan();
	}

	public List<Teacher> getTeacherList() {
		// TODO Auto-generated method stub
		return teacherdao.getTeacherList();
	}

	public int editCourseManager(CourseManager courseManager) {
			return teacherdao.editCourseManager(courseManager);
	}

	public int editTrainingPlan(TrainingPlan trainingPlan) {
		// TODO Auto-generated method stub
		return teacherdao.editTrainingPlan(trainingPlan);
	}

	public int editTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherdao.editTeacher(teacher);
	}

	public int addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherdao.addTeacher(teacher);
	}

	public int delTeacher(int teacherId) {
		// TODO Auto-generated method stub
		return teacherdao.delTeacher(teacherId);
	}

	public int addTeacherLecturer(String teacherName) {
		// TODO Auto-generated method stub
		return teacherdao.addTeacherLecturer(teacherName);
	}

	public int delTeacherLecturer(String teacherName) {
		// TODO Auto-generated method stub
		return teacherdao.delTeacherLecturer(teacherName);
	}

	public Teacher getTeacherDetailById(int teacherID) {
		// TODO Auto-generated method stub
		return teacherdao.getTeacherDetailById(teacherID);
	}


}
