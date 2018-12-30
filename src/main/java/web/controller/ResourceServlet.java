package web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 后台资源统一接口
 *
 * @Author: niracler
 * @Date: 2018/12/27 22:36
 */
public class ResourceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String type = request.getParameter("type");
//        Logger logger = LogManager.getLogger(ExerciseServlet.class);
//        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
//
//        switch (type) {
//            case "insert": {
//                break;
//            }
//            case "update": {
//                break;
//            }
//            case "updateCheck": {
//                break;
//            }
//            case "delete": {
//                break;
//            }
//            case "deleteMuti":
//                break;
//        }
//
//        logger.info("end\n");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 资源查询接口
         * http://localhost:8080/html/CheckResourceServlet.do?type=[资源种类编号]
         */
    }
}
