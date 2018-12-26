package web.controller;

import domian.Message;
import domian.Resource;
import service.Impl.ResourceManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "courseWareServlet")
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

        if ("show".equals(operationType)){
            List<Resource> resourceList = resourceManageService.find();
            request.setAttribute("resources",resourceList);
            getServletContext().getRequestDispatcher("/html/teachResDetail-1.jsp").forward(request,response);
        }
        //文件搜索
        else if ("searchRes".equals(operationType)){
            List<Resource> resourceList = resourceManageService.find();
            List<Resource> resultList = new ArrayList<Resource>();

            String keyWord = request.getParameter("search");
            for(Resource resource : resourceList) {
                if (-1!=resource.getResName().indexOf(keyWord) || -1!=resource.getResType().indexOf(keyWord)){
                    resultList.add(resource);
                }
            }
            request.setAttribute("resources",resultList);
            getServletContext().getRequestDispatcher("/html/teachResDetail-1.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
