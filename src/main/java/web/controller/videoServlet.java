package web.controller;

import domian.Message;
import domian.Resource;
import service.Impl.ResourceManageServiceImpl;
import tools.PageInformation;
import tools.Tool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/videoServlet")
public class videoServlet extends HttpServlet {
	
    public videoServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String type = request.getParameter("type");		 
		 ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
		 
		 if ("show".equals(type)){ //搜所教学录像 
			 PageInformation pageInformation=new PageInformation(); 	
			 Tool.getPageInformation("resource", request, pageInformation);
			 
			 pageInformation.setSearchSql("resType='教学录像'");
			 
		     //获取某页的资源信息
	         List<Resource> resourceList = resourceManageService.getOnePage(pageInformation);

	         //更新页面数据
	         request.setAttribute("pageInformation", pageInformation);
	         request.setAttribute("resources", resourceList);

	         //跳转显示教学课件页面
	         getServletContext().getRequestDispatcher("/html/teachResDetail-2.jsp").forward(request,response);
		 } else if ("searchRes".equals(type)){
			  PageInformation pageInformation = new PageInformation();
	          Tool.getPageInformation("resource",request,pageInformation);
	          
	          String searchSql="resName like '%"+request.getParameter("search")+"%' and resType='教学录像'";
			  pageInformation.setSearchSql(searchSql);
			  
			  //获取某页的资源信息
		      List<Resource> resourceList = resourceManageService.getOnePage(pageInformation);
			 
			  //更新页面数据
	          request.setAttribute("pageInformation", pageInformation);
	          request.setAttribute("resources", resourceList);

	          //跳转显示教学课件页面
	          getServletContext().getRequestDispatcher("/html/teachResDetail-2.jsp").forward(request,response);
		 }
	}

}
