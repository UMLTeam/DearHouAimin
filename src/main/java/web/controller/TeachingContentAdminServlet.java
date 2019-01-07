package web.controller;

import domain.TeachingContent;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.Impl.TeachingContentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TeachingContentAdminServlet", urlPatterns = "/servlet/TeachingContentAdminServlet")
public class TeachingContentAdminServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if("content".equals(type)){
            try {
                showAllContent(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("addContent".equals(type)){
            try {
                addContent(request,response);
                System.out.println("进来了嘛~？？");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("useContent".equals(type)){
            try {
                useContent(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("delContent".equals(type)){
            try {
                delContent(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void showAllContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingContentService TAS = new TeachingContentService();
        List<TeachingContent> contents = TAS.showAllContents();
        request.setAttribute("contents",contents);
        request.getRequestDispatcher("../admin/educationalDetail/educationalDetailAdmin-3.jsp").forward(request,response);
    }

    private void addContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingContentService TAS = new TeachingContentService();
        TeachingContent content = new TeachingContent();
        //保存实体的属性值
        List<String> params = new ArrayList<>();
        String path = this.getServletContext().getRealPath("resource");
        File file = new File(path);
        //判断目录是否存在
        if(!file.exists() && !file.isDirectory()){
            file.mkdir();  //创建目录
        }
        try {//上传文件
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //缓冲区
            factory.setSizeThreshold(1024 * 1024 * 5);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("utf-8");
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                //普通表单项
                if(item.isFormField()){
                    String value = item.getString("utf-8");
                    params.add(value);
                }else {
                    String filename = item.getName();
                    if(filename == null || filename.trim().equals("")){
                        continue;
                    }
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    StringBuilder sb = new StringBuilder(filename);
                    //生成后缀防止重复覆盖
                    sb.insert(filename.indexOf("."),((int) (Math.random() * 100)));
                    filename = sb.toString();
                    params.add(filename);
                    //上传
                    item.write(new File(path,filename));
                }
            }
            if(params.size() == 2){
                params.add(1,"false");
            }
            content.setContentName(params.get(0));
            content.setEnable(params.get(1));
            content.setContentURL("resource/"+params.get(2));
            TAS.addContent(content);
        }catch (Exception e){
            e.printStackTrace();
        }
        showAllContent(request,response);
    }

    private void useContent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingContentService tas = new TeachingContentService();
        int contentId = Integer.parseInt(request.getParameter("contentId"));
        tas.useContent(contentId);
        showAllContent(request,response);
    }

    private void delContent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingContentService tas = new TeachingContentService();
        int contentId = Integer.parseInt(request.getParameter("contentId"));
        tas.delContent(contentId);
        showAllContent(request,response);
    }
}