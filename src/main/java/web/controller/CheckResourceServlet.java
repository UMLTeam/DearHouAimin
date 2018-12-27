package web.controller;

import domian.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.Impl.ResourceManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 浏览资源统一接口
 *
 * @Author: wt
 * @Date: 2018/12/27 22:36
 */
@WebServlet(name = "CheckResourceServlet", value = "/html/CheckResourceServlet.do")
public class CheckResourceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 资源查询接口
         * http://localhost:8080/html/CheckResourceServlet.do?type=[资源种类编号]
         */
        Logger logger = LogManager.getLogger(CheckResourceServlet.class);
        String type = request.getParameter("type");
        String[] path = new String[]{"teachResDetail-1.jsp", "teachResDetail-2.jsp", "teachResDetail-3.jsp", "teachResDetail-4.jsp", "teachResDetail-5.jsp"};
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        List<Resource> resourceList = resourceManageService.findByType(type);
        HttpSession session = request.getSession();
        logger.info(resourceList.toString());
        session.setAttribute("resourceList", resourceList);
        request.getRequestDispatcher(path[Integer.parseInt(type)-1]).forward(request, response);
    }
}
