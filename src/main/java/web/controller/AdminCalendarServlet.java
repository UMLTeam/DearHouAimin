package web.controller;

import domain.Calendar;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.Impl.CalendarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminCalendarServlet", urlPatterns = "/servlet/AdminCalendarServlet")
public class AdminCalendarServlet extends HttpServlet {
    private CalendarService calendarService = new CalendarService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method.equals("showAll")) {

            showAll(request,response);

        } else if (method.equals("delete")) {

            Integer cid = Integer.parseInt(request.getParameter("cid"));
            List<Calendar> list = null;
            calendarService.deleteByCid(cid);
            list = calendarService.findAll();
            request.setAttribute("calendars", list);
            request.getRequestDispatcher("../admin/educationalDetail/calendarManage.jsp").forward(request, response);

        } else if (method.equals("stop")) {

            Integer cid = Integer.parseInt(request.getParameter("cid"));
            List<Calendar> list = null;
            calendarService.stop(cid);
            list = calendarService.findAll();
            request.setAttribute("calendars", list);
            request.getRequestDispatcher("../admin/educationalDetail/calendarManage.jsp").forward(request, response);
        } else if( method.equals("use")){
            Integer cid = Integer.parseInt(request.getParameter("cid"));
            List<Calendar> list = null;
            calendarService.use(cid);
            list = calendarService.findAll();
            request.setAttribute("calendars", list);
            request.getRequestDispatcher("../admin/educationalDetail/calendarManage.jsp").forward(request, response);
        } else if(method.equals("add")) {
            CalendarService calendarService = new CalendarService();
            Calendar calendar = new Calendar();
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
                calendar.setCname(params.get(0));
                calendar.setUsed(Integer.parseInt(params.get(1)));
                calendar.setPdfUrl("resource/"+params.get(2));
                calendarService.add(calendar);
            }catch (Exception e){
                e.printStackTrace();
            }
            showAll(request,response);
        }
    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Calendar> list = null;
        list = calendarService.findAll();
        request.setAttribute("calendars", list);
        request.getRequestDispatcher("../admin/educationalDetail/calendarManage.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
