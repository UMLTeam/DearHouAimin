package web.controller;

import domain.TeachingContent;
import service.Impl.TeachingContentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TeachingContentServlet",urlPatterns = "/servlet/TeachingContentServlet")
public class TeachingContentServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if("content".equals(type)){
            try {
                teachingContent(request,response);
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

    private void teachingContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingContentService TAS = new TeachingContentService();
        TeachingContent content = TAS.getCurContent();
        request.setAttribute("content",content);
        request.getRequestDispatcher("../html/educationalDetail-3.jsp").forward(request,response);
    }
}

