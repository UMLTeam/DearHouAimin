package web.controller;

import java.io.IOException;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domian.Resource;
import service.Impl.ResourceManageServiceImpl;

@WebServlet("/experimentalTaskServlet")
public class experimentalTaskServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String manage = request.getParameter("manage");
		ResourceManageServiceImpl service = new ResourceManageServiceImpl();
		if ("showPages".equals(type)) {
			// 找到所有实验资源
			List<Resource> resList = service.find();
			List<Resource> resTaskList = new ArrayList<Resource>();
			// 挑选实验任务资源
			for (Resource res : resList) {
				//if ("实验任务".equals(res.getResType())) {
					resTaskList.add(res);
				//}
			}
			resList = null;
			// 保存为全局
			request.setAttribute("resTaskList", resTaskList);
			// 重定向至实验任务浏览页面
			String url = "../html/teachResDetail-5.jsp";
			if (manage != null) {
				url = "../html/admin-list.html";
			}
			response.sendRedirect(url);
		} else if ("delete".equals(type)) {
			// 获取要操作资源的id
			String id = request.getParameter("ids");
			Resource res = new Resource();
			res.setId(Integer.parseInt(id));
			// 删除
			service.delete(res);
			// 重定向至实验任务浏览页面
			String url = "../experimentalTaskServlet?type=showPages&manage=1";
			response.sendRedirect(url);
		} else if ("update".equals(type)) {
			// 获取表单数据
			String resName = request.getParameter("resName");
			String resPath = request.getParameter("resPath");
			Resource res = new Resource();
			res.setResName(resName);
			res.setResPath(resPath);
			// 更新
			service.update(res);
			// 重定向至实验任务浏览页面
			String url = "../experimentalTaskServlet?type=showPages&manage=1";
			response.sendRedirect(url);
		} else if ("add".equals(type)) {
			// 获取表单数据
			String resName = request.getParameter("resName");
			String resPath = request.getParameter("resPath");
			String resType = "实验任务";
			Date date = new Date();
			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = dateformat.format(date);
			Timestamp resTime = Timestamp.valueOf(dateStr);
			Resource res = new Resource();
			res.setResName(resName);
			res.setResPath(resPath);
			res.setResType(resType);
			res.setResTime(resTime);
			// 插入
			service.insert(res);
			// 重定向至实验任务浏览页面
			String url = "../experimentalTaskServlet?type=showPages&manage=1";
			response.sendRedirect(url);
		}else if("search".equals(type)){
			
		}
	}

}
