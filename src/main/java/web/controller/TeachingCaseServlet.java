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
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TeachingCaseServlet")
public class TeachingCaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
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
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        List<Resource> resourceList = resourceManageService.find();
        for (Resource resource : resourceList) {
            logger.info(resource.toString());
        }
        logger.info("end\n");
    }
}
