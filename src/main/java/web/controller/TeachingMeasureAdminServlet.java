package web.controller;

import domain.TeachingMeasure;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.Impl.TeachingMeasureService;

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

@WebServlet(name = "TeachingMeasureAdminServlet", urlPatterns = "/servlet/TeachingMeasureAdminServlet")
public class TeachingMeasureAdminServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if("measure".equals(type)){
            try {
                showAllMeasure(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("addMeasure".equals(type)){
            try {
                addMeasure(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("useMeasure".equals(type)){
            try {
                useMeasure(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("delMeasure".equals(type)){
            try {
                delMeasure(request,response);
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
    private void showAllMeasure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingMeasureService TAS = new TeachingMeasureService();
        List<TeachingMeasure> measures = TAS.showAllMeasures();
        request.setAttribute("measures",measures);
        request.getRequestDispatcher("../admin/educationalDetail/educationalDetailAdmin-6.jsp").forward(request,response);
    }

    private void addMeasure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingMeasureService TAS = new TeachingMeasureService();
        TeachingMeasure measure = new TeachingMeasure();
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
            measure.setMeasureName(params.get(0));
            measure.setEnable(params.get(1));
            measure.setMeasureURL("resource/"+params.get(2));
            TAS.addMeasure(measure);
        }catch (Exception e){
            e.printStackTrace();
        }
        showAllMeasure(request,response);
    }

    private void useMeasure(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingMeasureService tas = new TeachingMeasureService();
        int measureId = Integer.parseInt(request.getParameter("measureId"));
        tas.useMeasure(measureId);
        showAllMeasure(request,response);
    }

    private void delMeasure(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingMeasureService tas = new TeachingMeasureService();
        int measureId = Integer.parseInt(request.getParameter("measureId"));
        tas.delMeasure(measureId);
        showAllMeasure(request,response);
    }
}