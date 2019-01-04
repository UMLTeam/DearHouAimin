package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Achievement;
import org.json.JSONArray;
import service.Impl.educationReformDetail3Service;


@WebServlet("/educationReformDetail3Action")

public class educationReformDetail3Action extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String type = req.getParameter("type");

		educationReformDetail3Service service = new educationReformDetail3Service();

		System.out.println(type);

		if ("detail".equals(type)) {
			List<Achievement> achievements = null;
			try {
				achievements = service.getAllAchievements();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getSession().setAttribute("achievements", achievements);
			getServletContext().getRequestDispatcher("/html/educationReformDetail-3.jsp").forward(req, resp);
		} else if ("all".equals(type)) {
			List<Achievement> achievements = null;
			try {
				achievements = service.getAllAchievements();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int pageSize = 5;// 每页显示5条信息
			JSONArray array = new JSONArray();
			List<Achievement> temp;
			int yushu = achievements.size() % pageSize;
			int pageNum;
			if (yushu == 0) {
				pageNum = achievements.size() / pageSize;
			} else {
				pageNum = achievements.size() / pageSize + 1;
			}
			if (pageNum == 1 && yushu != 0) {// 不足一页的情况
				temp = new ArrayList<Achievement>();
				temp = achievements.subList(0, yushu);
				JSONArray onePage = new JSONArray(temp.toString());
				array.put(onePage);
			} else if (pageNum == 1 && yushu == 0) {// 刚好只有一页的情况
				temp = new ArrayList<Achievement>();
				temp = achievements.subList(0, pageSize);
				JSONArray onePage = new JSONArray(temp.toString());
				array.put(onePage);
			} else {
				int i = 0;
				for (; i < pageNum - 1; i++) {
					temp = new ArrayList<Achievement>();
					temp = achievements.subList(i * pageSize, i * pageSize + pageSize);
					JSONArray onePage = new JSONArray(temp.toString());
					array.put(onePage);
				}

				// 处理最后一页的情况
				if (achievements.size() % pageSize == 0) {
					temp = new ArrayList<Achievement>();
					temp = achievements.subList(i * pageSize, i * pageSize + pageSize);
					JSONArray onePage = new JSONArray(temp.toString());
					array.put(onePage);
				} else {
					temp = new ArrayList<Achievement>();
					temp = achievements.subList(i * pageSize, i * pageSize + yushu);
					JSONArray onePage = new JSONArray(temp.toString());
					array.put(onePage);
				}
			}
			resp.setContentType("text/html;charset=utf-8");
			System.out.println(array);
			PrintWriter writer = resp.getWriter();
			writer.println(array);
		} else if ("show".equals(type)) {
			List<Achievement> achievements = null;
			try {
				achievements = service.getAllAchievements();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getSession().setAttribute("achievements", achievements);
			for (Achievement a : achievements) {
				String id = req.getParameter("id");
				if (a.getAchievement_id() == Integer.parseInt(id)) {
					req.setAttribute("achievement", a);
					getServletContext()
							.getRequestDispatcher("/html/educationReformDetail3/educationReformDetail-3-content-1.jsp")
							.forward(req, resp);
					break;
				}
			}
		} else if ("delete".equals(type)) {
			String id = req.getParameter("id");
			try {
				service.deleteAchievement(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Achievement> achievements = null;
			try {
				achievements = service.getAllAchievements();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getSession().setAttribute("achievements", achievements);
			resp.sendRedirect("/admin/achievements-list.jsp");
		} else if ("queryAllForManager".equals(type)) {
			List<Achievement> achievements = null;
			try {
				achievements = service.getAllAchievements();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getSession().setAttribute("achievements", achievements);
			resp.sendRedirect("/admin/achievements-list.jsp");
		} else if ("getOneForEdit".equals(type)) {
			List<Achievement> achievements = null;
			try {
				achievements = service.getAllAchievements();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getSession().setAttribute("achievements", achievements);
			for (Achievement a : achievements) {
				String id = req.getParameter("id");
				if (a.getAchievement_id() == Integer.parseInt(id)) {
					req.setAttribute("achievement", a);
					getServletContext().getRequestDispatcher("/admin/achievements-edit.jsp").forward(req, resp);
					break;
				}
			}
		} else if ("editAchievement".equals(type)) {
			String id = req.getParameter("id");
			String title = req.getParameter("title");
			String publish_time = req.getParameter("publish_time");
			try {
				service.updateAchievement(Integer.parseInt(id), title, publish_time);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Achievement> achievements = null;
			try {
				achievements = service.getAllAchievements();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getSession().setAttribute("achievements", achievements);
			resp.sendRedirect("/admin/achievements-list.jsp");
		} else if ("addAchievement".equals(type)) {
			String title = req.getParameter("title");
			String publish_time = req.getParameter("publish_time");
			try {
				service.insertAchievement(title, publish_time);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Achievement> achievements = null;
			try {
				achievements = service.getAllAchievements();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getSession().setAttribute("achievements", achievements);
			resp.sendRedirect("/admin/achievements-list.jsp");
		} else if ("deleteItem".equals(type)) {
			String id = req.getParameter("id");
			String achievement_id = req.getParameter("achievement_id");
			try {
				service.deleteAchievementItem(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			resp.sendRedirect("/educationReformDetail3Action?type=getOneForEdit&id=" + achievement_id);
		} else if ("addItem".equals(type)) {
			String achievement_id = req.getParameter("achievement_id");
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String publish_time = req.getParameter("publish_time");
			String publication = req.getParameter("publication");
			try {
				service.insertAchievementItem(achievement_id, title, author, publish_time, publication);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			resp.sendRedirect("/educationReformDetail3Action?type=getOneForEdit&id=" + achievement_id);
		} else if ("editItem".equals(type)) {
			String achievement_id = req.getParameter("achievement_id");
			String id = req.getParameter("id");
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String publish_time = req.getParameter("publish_time");
			String publication = req.getParameter("publication");
			try {
				service.updateAchievementItem(id, title, author, publish_time, publication);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			resp.sendRedirect("/educationReformDetail3Action?type=getOneForEdit&id=" + achievement_id);
		} else if ("findByTitle".equals(type)) {
			String title = req.getParameter("title");
			List<Achievement> achievements = null;
			try {
				achievements = service.findAchievementByTitle(title);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getSession().setAttribute("achievements", achievements);
			resp.sendRedirect("/admin/achievements-list.jsp");
		} else {
			List<Achievement> achievements = null;
			try {
				achievements = service.getAllAchievements();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getSession().setAttribute("achievements", achievements);
			getServletContext().getRequestDispatcher("/html/educationReformDetail-3.jsp").forward(req, resp);
		}
	}

}
