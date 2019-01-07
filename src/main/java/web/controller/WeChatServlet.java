package web.controller;

import domain.WeChat;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.Impl.WeChatService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "WeChatServlet", urlPatterns = "/servlet/WeChatServlet")
public class WeChatServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type.equals("addPhoto")) {
            WeChat Photo = new WeChat();
            WeChatService service = new WeChatService();
            //确保名字不重复
            List<String> params = new ArrayList<>();
            String path = this.getServletContext().getRealPath("images/interaction/");
            File file = new File(path);
            if (!file.exists() && !file.isDirectory()) {
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
                Photo.setSrc("images/interaction/" + params.get(0));
                Photo.setPublish_time(new Date());
                service.addPhoto(Photo);
                showAllPhotos(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type.equals("show")) {
            try {
                showAllPhotos(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (type.equals("normalShow")){
            WeChatService service = new WeChatService();
            try {
                List<WeChat> photos = service.showAllPhotos();
                request.setAttribute("photos", photos);
                request.getRequestDispatcher("/html/WeChat.jsp").forward(request, response);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (type.equals("delete")) {
            int photo_Id = Integer.parseInt(request.getParameter("photoId"));
            WeChatService service = new WeChatService();
            try {
                service.deletePhoto(photo_Id);
                showAllPhotos(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showAllPhotos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        WeChatService service = new WeChatService();
        List<WeChat> photos = service.showAllPhotos();
        request.setAttribute("photos", photos);
        request.getRequestDispatcher("/admin/teachingInteraction/WeChat.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
