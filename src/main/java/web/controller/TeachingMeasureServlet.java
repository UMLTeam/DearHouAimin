package web.controller;

import domain.TeachingMeasure;
import service.Impl.TeachingMeasureService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TeachingMeasureServlet",urlPatterns = "/servlet/TeachingMeasureServlet")
public class TeachingMeasureServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if("measure".equals(type)){
            try {
                teachingMeasure(request,response);
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

    private void teachingMeasure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingMeasureService TAS = new TeachingMeasureService();
        TeachingMeasure measure = TAS.getCurMeasure();
        request.setAttribute("measure",measure);
        request.getRequestDispatcher("../html/educationalDetail-6.jsp").forward(request,response);
    }
}

