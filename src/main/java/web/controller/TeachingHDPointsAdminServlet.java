package web.controller;

import domain.TeachingPoints;
import service.Impl.TeachingHDPointsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TeachingHDPointsAdminServlet", urlPatterns = "/servlet/TeachingHDPointsAdminServlet")
public class TeachingHDPointsAdminServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if("points".equals(type)){
            try {
                showAllPoints(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("addPoint".equals(type)){
            try {
                addPoint(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("usePoint".equals(type)){
            try {
                usePoint(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if("delPoint".equals(type)){
            try {
                delPoint(request,response);
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
    private void showAllPoints(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingHDPointsService TPS = new TeachingHDPointsService();
        List<TeachingPoints> points = TPS.showAllPoints();
        request.setAttribute("points",points);
        request.getRequestDispatcher("../admin/educationalDetail/educationalDetailAdmin-5.jsp").forward(request,response);
    }

    private void addPoint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingHDPointsService TPS = new TeachingHDPointsService();
        //教学重难点实体
        TeachingPoints point = new TeachingPoints();

        try {
            String theoryInfo =  request.getParameter("theoryInfo");
            String experimentInfo =  request.getParameter("experimentInfo");
            String enable =  request.getParameter("enable");
            point.setTheoryInfo(theoryInfo);
            point.setExperimentInfo(experimentInfo);
            point.setEnable(enable);
            TPS.addPoint(point);
        }catch (Exception e){
            e.printStackTrace();
        }
        showAllPoints(request,response);
    }

    private void usePoint(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingHDPointsService tps = new TeachingHDPointsService();
        int pointId = Integer.parseInt(request.getParameter("pointId"));
        tps.usePoint(pointId);
        showAllPoints(request,response);
    }

    private void delPoint(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        TeachingHDPointsService tps = new TeachingHDPointsService();
        int pointId = Integer.parseInt(request.getParameter("pointId"));
        tps.delPoint(pointId);
        showAllPoints(request,response);
    }
}
