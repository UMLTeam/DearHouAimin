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
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * POST请求都要返回Boolean已提示是否操作成功  以便后续工作的进行
 */
@WebServlet(value = "/ExerciseServlet.do")
public class ExerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        Logger logger = LogManager.getLogger(ExerciseServlet.class);
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();

        switch (type) {
            case "insert": {
                Date date = new Date();
                Resource resource = new Resource(1, "hello2", new Timestamp(date.getTime()), "/", "习题库", "0");
                logger.info(resource.toString());
                resourceManageService.update(resource);
                break;
            }
            case "update": {
                Date date = new Date();
                Resource resource = new Resource(1, "hello1", new Timestamp(date.getTime()), "/", "习题库", "0");
                logger.info(resource.toString());
                resourceManageService.update(resource);

                break;
            }
            case "updateCheck": {
                Date date = new Date();
                Resource resource = new Resource(1, "hello1", new Timestamp(date.getTime()), "/", "习题库", "1");
                logger.info(resource.toString());
                resourceManageService.update(resource);

                break;
            }
            case "delete": {
                Resource resource = new Resource();
                resource.setId(3);
                resourceManageService.delete(resource);

                break;
            }
            case "deleteMuti":

                break;
        }

        logger.info("end\n");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = LogManager.getLogger(ExerciseServlet.class);
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        List<Resource> resourceList = resourceManageService.findByType("习题库");
        HttpSession session = request.getSession();

        if(resourceList == null) {
            session.setAttribute("message", "没有找到相关信息!");
        } else {
            session.setAttribute("resourceList", resourceList);
        }

        if(!request.getParameter("type").equals("admin-list")){
            request.getRequestDispatcher("/html/teachResDetail-3.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/admin/exercise/exercise-list.jsp").forward(request, response);
        }
    }
}
