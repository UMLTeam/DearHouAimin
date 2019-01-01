package web.controller;

import domian.Resource;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import java.io.PrintWriter;
import java.util.List;

/**
 * 前台资源展示统一接口
 *
 * @Author: wt
 * @Date: 2018/1/1 12:47
 */
@WebServlet(name = "ShowResourceServlet", value = "/ShowResourceServlet.do")
public class ShowResourceServlet extends HttpServlet {
    private static Logger logger = LogManager.getLogger(ShowResourceServlet.class);

    private final String[] PATH = new String[]{
            "/html/teachResDetail-1.jsp",
            "/html/teachResDetail-2.jsp",
            "/html/teachResDetail-3.jsp",
            "/html/teachResDetail-4.jsp",
            "/html/teachResDetail-5.jsp"
    };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 前端资源查询接口
         * http://localhost:8080/ShowResourceServlet.do?resType=[资源种类名称]
         */
        String resType = request.getParameter("resType");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        List<Resource> resourceList = resourceManageService.showResource(resType);
        HttpSession session = request.getSession();
        session.setAttribute("resources", resourceList);
        request.getRequestDispatcher(PATH[Integer.parseInt(resType)-1]).forward(request, response);
    }
}
