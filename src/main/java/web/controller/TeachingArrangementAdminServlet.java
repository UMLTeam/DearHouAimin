package web.controller;

import domain.LeaveMsg;
import domain.TeachingGeneral;
import domain.TeachingPlan;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.Impl.TeachingArrangementService;

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

@WebServlet(name = "TeachingArrangementAdminServlet", urlPatterns = "/servlet/TeachingArrangementAdminServlet")
public class TeachingArrangementAdminServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if ("plan".equals(type)) {
            try {
                showAllPlan(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if ("addPlan".equals(type)) {
            try {
                addPlan(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if ("usePlan".equals(type)) {
            try {
                usePlan(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if ("delPlan".equals(type)) {
            try {
                delPlan(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if ("showLeaveMsg".equals(type)) {
            try {
                showLeaveMsg(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("delLeaveMsg".equals(type)){
            try {
                delLeaveMsg(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if ("general".equals(type)){
            try {
                showAllGeneral(request, response);
            }catch (SQLException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }else if ("addGeneral".equals(type)){
            try {
                addGeneral(request, response);
            }catch (SQLException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }else if ("useGeneral".equals(type)){
            try {
                useGeneral(request, response);
            }catch (SQLException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }else if("delGeneral".equals(type)){
            try {
                delGeneral(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void showAllPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingArrangementService TAS = new TeachingArrangementService();
        List<TeachingPlan> plans = TAS.showAllPlans();
        request.setAttribute("plans", plans);
        request.getRequestDispatcher("../admin/educationalDetail/educationalDetailAdmin-4.jsp").forward(request, response);
    }

    private void addPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingArrangementService TAS = new TeachingArrangementService();
        //授课计划实体
        TeachingPlan plan = new TeachingPlan();
        //保存实体的属性值
        List<String> params = new ArrayList<>();
        String path = this.getServletContext().getRealPath("resource");
        File file = new File(path);
        //判断目录是否存在
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
            for (FileItem item : list) {
                //普通表单项
                if (item.isFormField()) {
                    String value = item.getString("utf-8");
                    params.add(value);
                } else {
                    String filename = item.getName();
                    if (filename == null || filename.trim().equals("")) {
                        continue;
                    }
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    StringBuilder sb = new StringBuilder(filename);
                    //生成后缀防止重复覆盖
                    sb.insert(filename.indexOf("."), ((int) (Math.random() * 100)));
                    filename = sb.toString();
                    params.add(filename);
                    //上传
                    item.write(new File(path, filename));
                }
            }
            if (params.size() == 2) {
                params.add(1, "false");
            }
            plan.setPlanName(params.get(0));
            plan.setEnable(params.get(1));
            plan.setPlanURL("resource/" + params.get(2));
            TAS.addPlan(plan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        showAllPlan(request, response);
    }

    private void usePlan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingArrangementService tas = new TeachingArrangementService();
        int planId = Integer.parseInt(request.getParameter("planId"));
        tas.usePlan(planId);
        showAllPlan(request, response);
    }

    private void delPlan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingArrangementService tas = new TeachingArrangementService();
        int planId = Integer.parseInt(request.getParameter("planId"));
        tas.delPlan(planId);
        showAllPlan(request, response);
    }

    private void showLeaveMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        // 添加留言
        // 在下个版本需要获取用户Id
        TeachingArrangementService TAS = new TeachingArrangementService();
        List<LeaveMsg> leaveMsgs = TAS.showAllLeaveMsgs();
        request.setAttribute("leaveMsgs", leaveMsgs);
        request.getRequestDispatcher("../admin/teachingInteraction/leaveMsgAdmin.jsp").forward(request, response);
    }

    private void delLeaveMsg(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingArrangementService tas = new TeachingArrangementService();
        int leaveMsgId = Integer.parseInt(request.getParameter("leaveMsgId"));
        tas.delLeaveMsg(leaveMsgId);
        showLeaveMsg(request, response);
    }

    // ************************
    private void showAllGeneral(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingArrangementService TAS = new TeachingArrangementService();
        List<TeachingGeneral> generals = TAS.showAllGenerals() ;
        request.setAttribute("generals",generals);
        request.getRequestDispatcher("../admin/educationalDetail/educationalDetailAdmin-1.jsp").forward(request,response);
    }

    private void addGeneral(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingArrangementService TAS = new TeachingArrangementService();
        //教学大纲实体
        TeachingGeneral general = new TeachingGeneral();
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
            general.setGeneralName(params.get(0));
            general.setEnable(params.get(1));
            general.setGeneralURL("resource/"+params.get(2));
            TAS.addGeneral(general);
        }catch (Exception e){
            e.printStackTrace();
        }
        showAllGeneral(request,response);
    }

    private void useGeneral(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingArrangementService tas = new TeachingArrangementService();
        int generalId = Integer.parseInt(request.getParameter("generalId"));
        tas.useGeneral(generalId);
        showAllGeneral(request,response);
    }

    private void delGeneral(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingArrangementService tas = new TeachingArrangementService();
        int generalId = Integer.parseInt(request.getParameter("generalId"));
        tas.delGeneral(generalId);
        showAllGeneral(request,response);
    }
}
