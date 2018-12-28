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

@WebServlet("/courseWareServlet")
public class courseWareServlet extends HttpServlet {

    public courseWareServlet(){
        super();
    }

    public void destroy(){
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operationType = request.getParameter("type");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
//        Message message = new Message();

        //前台展示资源
        if ("show".equals(operationType)){
            PageInformation pageInformation=new PageInformation();
            Tool.getPageInformation("resource", request, pageInformation);

            //获取某页的资源信息
            List<Resource> resourceList = resourceManageService.getOnePage(pageInformation);

            //更新页面数据
            request.setAttribute("pageInformation", pageInformation);
            request.setAttribute("resources", resourceList);

            //跳转显示教学课件页面
            getServletContext().getRequestDispatcher("/html/teachResDetail-1.jsp").forward(request,response);
        }
        //文件搜索
        else if ("searchRes".equals(operationType)){
            PageInformation pageInformation = new PageInformation();
            Tool.getPageInformation("resource",request,pageInformation);

            //获取某页的资源信息
            List<Resource> resourceList = resourceManageService.getOnePage(pageInformation);
            List<Resource> resultList = new ArrayList<Resource>();

            String keyWord = request.getParameter("search");
            for(Resource resource : resourceList) {
                if (-1!=resource.getResName().indexOf(keyWord) || -1!=resource.getResType().indexOf(keyWord)){
                    resultList.add(resource);
                }
            }
            request.setAttribute("resources",resultList);
            getServletContext().getRequestDispatcher("/html/teachResDetail-2.jsp").forward(request,response);
        }
        //后台展示资源
        else if ("adminShow".equals(operationType)){
            PageInformation pageInformation=new PageInformation();
            Tool.getPageInformation("resource", request, pageInformation);

            //获取某页的资源信息
            List<Resource> resourceList = resourceManageService.getOnePage(pageInformation);

            //更新页面数据
            request.setAttribute("pageInformation", pageInformation);
            request.setAttribute("resources", resourceList);

            //跳转显示教学课件页面
            getServletContext().getRequestDispatcher("/admin/courseWare/courseWare-list.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
