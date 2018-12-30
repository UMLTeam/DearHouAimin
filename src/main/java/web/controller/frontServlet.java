package web.controller;

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

@WebServlet("/frontServlet.do")
public class frontServlet extends HttpServlet {

    private String[] path = new String[]{
            "/html/teachResDetail-1.jsp",
            "/html/teachResDetail-2.jsp",
            "/html/teachResDetail-3.jsp",
            "/html/teachResDetail-4.jsp",
            "/html/teachResDetail-5.jsp"
    };

    public frontServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operationType = request.getParameter("type");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();

        //前台展示资源
        if ("show".equals(operationType)){
            PageInformation pageInformation=new PageInformation();
            Tool.getPageInformation("resource", request, pageInformation);

            //选择对应资源类型的跳转页
            String resType = request.getParameter("resType");

            //获取某页的资源信息
            List<Resource> resourceList = resourceManageService.getOnePage(pageInformation);

            //更新页面数据
            request.setAttribute("pageInformation", pageInformation);
            request.setAttribute("resources", resourceList);

            //跳转显示教学课件页面
            getServletContext().getRequestDispatcher(path[Integer.parseInt(resType)-1]).forward(request,response);
        }
        //文件搜索
        else if ("searchRes".equals(operationType)){
            PageInformation pageInformation = new PageInformation();
            Tool.getPageInformation("resource",request,pageInformation);

            //获取某页的资源信息
            List<Resource> resourceList = resourceManageService.getOnePage(pageInformation);
            List<Resource> resultList = new ArrayList<Resource>();
            //选择对应资源类型的跳转页
            String resType = request.getParameter("resType");

            String keyWord = request.getParameter("search");
            for(Resource resource : resourceList) {
                if (-1!=resource.getResName().indexOf(keyWord) || -1!=resource.getResType().indexOf(keyWord)){
                    resultList.add(resource);
                }
            }
            request.setAttribute("resources",resultList);
            request.getRequestDispatcher(path[Integer.parseInt(resType)-1]).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
