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
 * 后台资源统一接口
 *
 * @Author: niracler
 * @Date: 2018/12/27 22:36
 */
@WebServlet(name = "resourceServlet", value = "/resourceServlet.do")
public class resourceServlet extends HttpServlet {

    private String[] path = new String[]{
            "/admin/courseWare/courseWare-list.jsp",
            "/admin/video/teachingVideo-list.jsp",
            "/admin/exercise/exercise-list.jsp",
            "/admin/example/example-list.jsp",
            "/admin/experimentalTask/experimentalTask-list.jsp"
    };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();

        switch (type) {
            case "insert": {
                break;
            }
            case "update": {
                break;
            }
            case "updateCheck": {
                break;
            }
            case "delete": {
                break;
            }
            case "deleteMuti":
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 资源查询接口
         * http://localhost:8080/adminServlet.do?operationType=[操作类型]&resType=[资源种类名称]
         */

        //选择对应资源类型的跳转页
        String resType = request.getParameter("resType");


        //查询数据
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        List<Resource> resourceList = resourceManageService.findByType(resType);

        //送给jsp
        HttpSession session = request.getSession();
        session.setAttribute("resourceList", resourceList);
        request.getRequestDispatcher(path[Integer.parseInt(resType)-1]).forward(request, response);
    }
}
