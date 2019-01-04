package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import domain.CourseManager;
import domain.Teacher;
import domain.TrainingPlan;

public class TeacherTeamDao {
	
//	Connection connection = JDBCUtil.getConnection();
	
	Logger logger = LogManager.getLogger(ResourceManageDaoImpl.class);
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	private static DataBaseConnectionImpl dataBaseConnection;

	public TeacherTeamDao() {
		dataBaseConnection = new DataBaseConnectionImpl();
		connection = dataBaseConnection.getConnection();
	}
	
	@Override
	protected void finalize() {
		dataBaseConnection.free(connection, preparedStatement, resultSet);
	}

	public CourseManager getCourseManagerMessage() {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM courseManager where id=1");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CourseManager courseManager = new CourseManager();
				courseManager.setId(resultSet.getInt("id"));
				courseManager.setMessage(resultSet.getString("message"));
				courseManager.setName(resultSet.getString("name"));
				return courseManager;
			}
			return null;
		} catch (Exception e) {
			logger.error(e.toString());
			return null;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	public TrainingPlan getTrainingPlan() {
		// TODO Auto-generated method stubs
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM trainingPlan where id=0");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				TrainingPlan trainingPlan = new TrainingPlan();
				trainingPlan.setId(resultSet.getInt("id"));
				trainingPlan.setMessage(resultSet.getString("detail"));
				return trainingPlan;
			}
			return null;
		} catch (Exception e) {
			logger.error(e.toString());
			return null;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	public List<Teacher> getTeacherList() {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM teacherTeam");
			resultSet = preparedStatement.executeQuery();
			List<Teacher> teacherList = new ArrayList<Teacher>();
			while(resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setIsLecturer(resultSet.getInt("isLecturer"));
				teacher.setTeacher_name(resultSet.getString("teacher_name"));
				teacher.setTeacher_message(resultSet.getString("teacher_message"));
				teacherList.add(teacher);
			}
			return teacherList;
		} catch (Exception e) {
			logger.error(e.toString());
			return null;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	public int editCourseManager(CourseManager courseManager) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("update courseManager set name='"+courseManager.getName()+"',message='"+courseManager.getMessage()+"' where id="+courseManager.getId());
			return preparedStatement.executeUpdate()>0 ? 1 : 0;
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	public int editTrainingPlan(TrainingPlan trainingPlan) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("update trainingPlan set detail='"+trainingPlan.getMessage()+"' where id="+trainingPlan.getId());
			return preparedStatement.executeUpdate()>0 ? 1 : 0;
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	public int editTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("update teacherTeam set teacher_name='"+teacher.getTeacher_name()+"',teacher_message='"+teacher.getTeacher_message()+"' where id="+teacher.getId());
			return preparedStatement.executeUpdate()>0 ? 1 : 0;
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	public int addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("insert into teacherTeam(teacher_name,teacher_message) values('"+teacher.getTeacher_name()+"','"+teacher.getTeacher_message()+"')");
			return preparedStatement.executeUpdate()>0 ? 1 : 0;
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	public int delTeacher(int teacherId) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("delete from teacherTeam  where id="+teacherId);
			return preparedStatement.executeUpdate()>0 ? 1 : 0;
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	public int addTeacherLecturer(String teacherName) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("update teacherTeam set isLecturer=1 where teacher_name='"+teacherName+"'");
			return preparedStatement.executeUpdate()>0 ? 1 : 0;
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	public int delTeacherLecturer(String teacherName) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("update teacherTeam set isLecturer=0 where teacher_name='"+teacherName+"'");
			return preparedStatement.executeUpdate()>0 ? 1 : 0;
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	public Teacher getTeacherDetailById(int teacherID) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM teacherTeam where id = ?");
			preparedStatement.setInt(1, teacherID);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setIsLecturer(resultSet.getInt("isLecturer"));
				teacher.setTeacher_name(resultSet.getString("teacher_name"));
				teacher.setTeacher_message(resultSet.getString("teacher_message"));
				return teacher;
			}
			return null;
		} catch (Exception e) {
			logger.error(e.toString());
			return null;
		} finally {
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}
	
	
}
