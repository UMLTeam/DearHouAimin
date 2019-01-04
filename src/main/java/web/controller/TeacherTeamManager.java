package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domian.CourseManager;
import domian.Message;
import domian.Teacher;
import domian.TrainingPlan;
import service.Impl.TeacherTeamService;




@WebServlet("/TeacherTeamManager")
public class TeacherTeamManager extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private TeacherTeamService teacherService = new TeacherTeamService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String action = req.getParameter("type");
		switch (action) {

		case "courseManager-edits": {
			editCourseManagerMessage(req, resp);
			break;
		}
		case "teacherTeam-edits": {
			editTeacher(req, resp);
			break;
		}

		case "teacherTeam-add": {
			addTeacher(req, resp);
			break;
		}
		case "teacherTeam-del": {
			delTeacher(req, resp);
			break;
		}
		case "lecturer-add": {
			addTeacherLecturer(req, resp);
			break;
		}
		
		case "lecturer-del": {
			delTeacherLecturer(req, resp);
			break;
		}

		case "trainingPlan-edits": {
			editTrainingPlan(req, resp);
			break;
		}
		default: {
			break;
		}
		}

	}

	private void delTeacherLecturer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacherName = req.getParameter("name");
		Message message = new Message();
		if(teacherService.delTeacherLecturer(teacherName)==1) {
			message.setMessage("删除主讲教师成功！");
			message.setRedirectUrl("/admin/index.html");
		}else {
			message.setMessage("删除主讲教师失败！");
			message.setRedirectUrl("/admin/index.html");
		}
		req.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/admin/teacherTeam/message.jsp").forward(req, resp);
		
	}


	private void addTeacherLecturer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teacherName = req.getParameter("name");
		Message message = new Message();
		if(teacherService.addTeacherLecturer(teacherName)==1) {
			message.setMessage("添加主讲教师成功！");
			message.setRedirectUrl("/admin/index.html");
		}else {
			message.setMessage("添加主讲教师失败！");
			message.setRedirectUrl("/admin/index.html");
		}
		req.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/admin/teacherTeam/message.jsp").forward(req, resp);
		
	}

	private void addTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		Message message = new Message();
		teacher.setTeacher_name(req.getParameter("name"));
		teacher.setTeacher_message(req.getParameter("content"));
		if(teacherService.addTeacher(teacher)==1) {
			message.setMessage("添加新老师信息成功！");
			message.setRedirectUrl("/admin/index.html");
		}else {
			message.setMessage("添加新老师信息失败！");
			message.setRedirectUrl("/admin/index.html");
		}
		req.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/admin/teacherTeam/message.jsp").forward(req, resp);
	}
	private void delTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Message message = new Message();
		int teacherId = Integer.parseInt(req.getParameter("id"));
		if(teacherService.delTeacher(teacherId)==1) {
			message.setMessage("删除成功！");
			message.setRedirectUrl("/admin/index.html");
		}else {
			message.setMessage("删除失败失败！");
			message.setRedirectUrl("/admin/index.html");
		}
		req.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/admin/teacherTeam/message.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void editCourseManagerMessage(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		CourseManager courseManager = new CourseManager();
		Message message = new Message();
		courseManager.setId(Integer.parseInt(req.getParameter("id")));
		courseManager.setMessage(req.getParameter("content"));
		courseManager.setName(req.getParameter("name"));
		if(teacherService.editCourseManager(courseManager)==1) {
			message.setMessage("修改课程负责人信息成功！");
			message.setRedirectUrl("/admin/index.html");
		}else {
			message.setMessage("修改课程负责人信息失败！");
			message.setRedirectUrl("/admin/index.html");
		}
		req.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/admin/teacherTeam/message.jsp").forward(req, resp);
		
	}
	
	private void editTeacher(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		Teacher teacher = new Teacher();
		Message message = new Message();
		teacher.setId(Integer.parseInt(req.getParameter("id")));
		teacher.setTeacher_name(req.getParameter("name"));
		teacher.setTeacher_message(req.getParameter("content"));
		if(teacherService.editTeacher(teacher)==1) {
			message.setMessage("修改信息成功！");
			message.setRedirectUrl("/admin/index.html");
		}else {
			message.setMessage("修改信息失败！");
			message.setRedirectUrl("/admin/index.html");
		}
		req.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/admin/teacherTeam/message.jsp").forward(req, resp);
	}



	
	private void editTrainingPlan(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		TrainingPlan trainingPlan = new TrainingPlan();
		Message message = new Message();
		trainingPlan.setMessage(req.getParameter("content"));
		if(teacherService.editTrainingPlan(trainingPlan)==1) {
			message.setMessage("修改青年教师培养信息成功！");
			message.setRedirectUrl("/admin/index.html");
		}else {
			message.setMessage("修改青年教师培养信息失败！");
			message.setRedirectUrl("/admin/index.html");
		}
		req.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/admin/teacherTeam/message.jsp").forward(req, resp);
	}

}
