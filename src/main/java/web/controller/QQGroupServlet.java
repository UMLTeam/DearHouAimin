package web.controller;

import domain.QQGroup;
import service.Impl.QQGroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "QQGroupServlet", urlPatterns = "/servlet/QQGroupServlet")
public class QQGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");

        if ("change".equals(type)){
            //有错，暂不管
            try {
                changeQQgroup(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if ("show".equals(type)){
            showQQgroup(request,response);
        }else if ("add".equals(type)){
            addQQgroup(request,response);
        }else if ("use".equals(type)){
            try {
                useQQgroup(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("delete".equals(type)){
            try {
                deleteQQgroup(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public  void deleteQQgroup(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String id = request.getParameter("id");
        QQGroupService qqGroupService = new QQGroupService();
        qqGroupService.deleteQQGroup(id);
        showQQgroup(request,response);
    }
    public void changeQQgroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String name = request.getParameter("name");
        QQGroupService qqGroupService = new QQGroupService();
        /*
        QQGroup qqGroup = null;
        try {
            qqGroup = qqGroupService.getQQGroupByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("qqGroup",qqGroup);
        request.getRequestDispatcher("../jsp/qqGroup.jsp").forward(request,response);
        */
        qqGroupService.getQQGroupByName(name);
    }

    public void addQQgroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QQGroup qqGroup = new QQGroup();

        qqGroup.setEnable("false");
        QQGroupService qqGroupService = new QQGroupService();
        //添加新的QQ群信息，困了，先睡觉
        try {
            qqGroupService.addQQGroup(qqGroup, request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        showQQgroup(request,response);
    }

    public void useQQgroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String id = request.getParameter("id");
        QQGroupService qqGroupService = new QQGroupService();
        qqGroupService.useQQGroup(id);
        showQQgroup(request, response);
    }

    public void showQQgroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QQGroupService qqGroupService = new QQGroupService();
        ArrayList<QQGroup> qqGroups = null;
        try {
            qqGroups = qqGroupService.getQQGroups();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("qqGroups",qqGroups);
        request.getRequestDispatcher("../admin/teachingInteraction/qqGroup.jsp").forward(request,response);
    }
}

