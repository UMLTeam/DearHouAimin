package web.controller;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import domain.Resource;
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
 * 后台资源统一接口
 *
 * @Author: niracler
 * @Date: 2018/12/27 22:36
 */
@WebServlet(name = "ResourceServlet", value = "/ResourceServlet.do")
public class ResourceServlet extends HttpServlet {
    private static Logger logger = LogManager.getLogger(ResourceServlet.class);

    private final String[] PATH = new String[]{
            "/admin/courseWare/courseWare-list.jsp",
            "/admin/video/teachingVideo-list.jsp",
            "/admin/exercise/exercise-list.jsp",
            "/admin/example/example-list.jsp",
            "/admin/experimentalTask/experimentalTask-list.jsp"
    };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String type = null;
        // 检测是否为多媒体上传
        if (ServletFileUpload.isMultipartContent(request)) {
            type = "insert";
        } else {
            type = request.getParameter("type");
        }
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        JSONObject jsonObject = new JSONObject();
        boolean data = false;
        switch (type) {
            case "insert": {
                try {
                    Resource resource = new Resource();
                    resource.setIsCheck("1");
                    DiskFileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    //获取目录所在的路径
                    String path = request.getServletContext().getRealPath("/") + "resource";
                    //String path = "C:\\Users\\HuChuanfuOffice\\Desktop\\upload";
                    logger.info("path " + path);
                    // 中文处理
                    upload.setHeaderEncoding("utf-8");
                    List<FileItem> formItems = upload.parseRequest(request);
                    resourceManageService.saveFile(formItems, path, resource);
                    data = resourceManageService.create(resource);
                    request.getRequestDispatcher(PATH[Integer.parseInt(resource.getResType()) - 1]).forward(request, response);
                } catch (Exception e) {
                    logger.error(e.toString());
                }
                break;
            }
            case "update": {
                Resource resource = new Resource();
                resource.setIsCheck("0");
                resource.setId(10);
                data = resourceManageService.change(resource);
                break;
            }
            case "updateCheck": {
                String id = request.getParameter("id");
                String status = request.getParameter("status");
                Resource resource = new Resource();
                resource.setIsCheck(status);
                resource.setId(Integer.parseInt(id));
                data = resourceManageService.changeCheck(resource);

                break;
            }
            case "delete": {
                String id = request.getParameter("id");
                data = resourceManageService.removeById(Integer.parseInt(id));
                break;
            }
            case "deleteMuti":
//                resourceManageService.removeMultiple();
                break;
            case "selectByName": {
                String search = request.getParameter("search");
                String resType = request.getParameter("resType");
                List<Resource> list = resourceManageService.selectByName(resType, search);
                request.getSession().setAttribute("resourceList", list);
                request.getRequestDispatcher(PATH[Integer.parseInt(resType) - 1]).forward(request, response);
                return;
            }
            default:
                break;
        }
        jsonObject.put("data", data);
        out.print(jsonObject);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 资源查询接口
         * http://localhost:8080/adminServlet.do?type=[操作类型]&resType=[资源种类名称]
         */

        //选择对应资源类型的跳转页
        String resType = request.getParameter("resType");


        //查询数据
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        List<Resource> resourceList = resourceManageService.findByType(resType);

        //送给jsp
        HttpSession session = request.getSession();
        session.setAttribute("resourceList", resourceList);
        request.getRequestDispatcher(PATH[Integer.parseInt(resType) - 1]).forward(request, response);
    }
}
