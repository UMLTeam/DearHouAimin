package web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.CourseManager;
import domain.Teacher;
import domain.TrainingPlan;
import service.Impl.TeacherTeamService;


@WebServlet("/teacherTeam")
public class TeacherTeamAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TeacherTeamService teacherService = new TeacherTeamService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String action =req.getParameter("type");
		switch (action) {

		case "courseManager": {
			getCourseManagerMessage(req, resp,0);
			break;
		}
		case "courseManager-edit": {
			getCourseManagerMessage(req, resp,1);
			break;
		}
		case "courseManager-edits": {
			getCourseManagerMessage(req, resp,2);
			break;
		}
		case "teacherDetail": {
			getTeacherDetail(req,resp);
			break;
		}
		case "teacherTeam": {
			getTeacherTeam(req, resp,0);
			break;
		}
		case "teacherTeam-edit": {
			getTeacherTeam(req, resp,1);
			break;
		}
		case "teacherTeam-edits": {
			getTeacherTeam(req, resp,2);
			break;
		}
		case "lecturer": {
			getTeacherLecturer(req, resp,0);
			break;
		}
		case "lecturer-edit": {
			getTeacherLecturer(req, resp,1);
			break;
		}
		case "lecturer-edits": {
			getTeacherLecturer(req, resp,2);
			break;
		}
		case "trainingPlan": {
			getTrainingPlan(req, resp,0);
			break;
		}
		case "trainingPlan-edit": {
			getTrainingPlan(req, resp,1);
			break;
		}
		case "trainingPlan-edits": {
			getTrainingPlan(req, resp,2);
			break;
		}
		default: {
			break;
		}
		}
	}



	private void getTeacherDetail(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
			int teacherID = Integer.parseInt(req.getParameter("id"));
			Teacher teacher = teacherService.getTeacherDetailById(teacherID);
			if(teacher!=null) {
				HttpSession session = req.getSession();
				session.setAttribute("teacher", teacher);
				try {
					req.getRequestDispatcher("/html/teacherTeamDetail-5.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}



	private void getTeacherLecturer(HttpServletRequest req, HttpServletResponse resp,int mode) {
		// TODO Auto-generated method stub
		List<Teacher> allTeacher = teacherService.getTeacherList();
		List<Teacher> LecturerList = new ArrayList<Teacher>();
		List<Teacher> NotLecturerList =new ArrayList<Teacher>();
		if (allTeacher != null) {
			for(int i=0;i<allTeacher.size();i++)
				if(allTeacher.get(i).getIsLecturer()==1)
					LecturerList.add(allTeacher.get(i));
				else
					NotLecturerList.add(allTeacher.get(i));
			HttpSession session = req.getSession();
			session.setAttribute("LecturerList", LecturerList);
			session.setAttribute("NotLecturerList", NotLecturerList);
			try {
				if(mode==0)
					req.getRequestDispatcher("/html/teacherTeamDetail-3.jsp").forward(req, resp);
				if(mode==1)
					req.getRequestDispatcher("/admin/teacherTeam/teacherLecturerList.jsp").forward(req, resp);
				if(mode==2)
					req.getRequestDispatcher("/admin/teacherTeam/teacherLecturerEdit.jsp").forward(req,resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void getTeacherTeam(HttpServletRequest req, HttpServletResponse resp,int mode) {
		// TODO Auto-generated method stub
		List<Teacher> teacherList = teacherService.getTeacherList();
		if (teacherList != null) {
			HttpSession session = req.getSession();
			session.setAttribute("teacherTeam", teacherList);
			try {
				if(mode==0)
					req.getRequestDispatcher("/html/teacherTeamDetail-2.jsp").forward(req, resp);
				if(mode==1)
					req.getRequestDispatcher("/admin/teacherTeam/teacherTeamList.jsp").forward(req, resp);
				if(mode==2) {
					int teacherId = Integer.parseInt(req.getParameter("id"));
					for(int i=0;i<teacherList.size();i++) {
						if(teacherId==teacherList.get(i).getId()) {
							session.setAttribute("teacherTeam", teacherList.get(i));
							break;
						}
					}
					req.getRequestDispatcher("/admin/teacherTeam/teacherTeamEdit.jsp").forward(req,resp);
				}
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void getCourseManagerMessage(HttpServletRequest req, HttpServletResponse resp,int mode) {
		CourseManager courseManager = teacherService.getCourseManagerMessage();
		if (courseManager != null) {
			HttpSession session = req.getSession();
			session.setAttribute("courseManager", courseManager);
			try {
				if(mode==0)
					req.getRequestDispatcher("/html/teacherTeamDetail-1.jsp").forward(req, resp);
				if(mode==1)
					req.getRequestDispatcher("/admin/teacherTeam/courseManagerList.jsp").forward(req,resp);
				if(mode==2)
					req.getRequestDispatcher("/admin/teacherTeam/courseManagerEdit.jsp").forward(req,resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void getTrainingPlan(HttpServletRequest req, HttpServletResponse resp,int mode) {
		TrainingPlan trainingPlan = teacherService.getTrainingPlan();
		if (trainingPlan != null) {
			HttpSession session = req.getSession();
			session.setAttribute("trainingPlan", trainingPlan);
			try {
				if(mode==0)
					req.getRequestDispatcher("/html/teacherTeamDetail-4.jsp").forward(req, resp);
				if(mode==1)
					req.getRequestDispatcher("/admin/teacherTeam/trainingPlanList.jsp").forward(req, resp);
				if(mode==2)
					req.getRequestDispatcher("/admin/teacherTeam/trainingPlanEdit.jsp").forward(req,resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
