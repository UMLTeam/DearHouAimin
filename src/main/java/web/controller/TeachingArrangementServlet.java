package web.controller;

import domain.LeaveMsg;
import domain.TeachingGeneral;
import domain.TeachingPlan;
import service.Impl.TeachingArrangementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TeachingArrangementServlet", urlPatterns = "/servlet/TeachingArrangementServlet")
public class TeachingArrangementServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        if ("plan".equals(type)) {
            try {
                teachingPlan(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if ("addLeaveMsg".equals(type)) {
            try {
                addLeaveMsg(request, response);
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
        } else if ("general".equals(type)){
            try {
                teachingGeneral(request, response);
            }catch (SQLException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void teachingPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        TeachingArrangementService TAS = new TeachingArrangementService();
        TeachingPlan plan = TAS.getCurPlan();
        request.setAttribute("plan", plan);
        request.getRequestDispatcher("../html/educationalDetail-4.jsp").forward(request, response);
    }

    private void addLeaveMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        // 添加留言
        // 在下个版本需要获取用户Id
        TeachingArrangementService TAS = new TeachingArrangementService();
        String leaveMsgContent = request.getParameter("leaveMsgContent");
        TAS.addLeaveMsg(leaveMsgContent);
        request.getRequestDispatcher("../servlet/TeachingArrangementServlet?type=showLeaveMsg").forward(request, response);
    }

    private void showLeaveMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        // 添加留言
        // 在下个版本需要获取用户Id
        TeachingArrangementService TAS = new TeachingArrangementService();
        List<LeaveMsg> leaveMsgs = TAS.showAllLeaveMsgs();
        request.setAttribute("leaveMsgs", leaveMsgs);
        request.getRequestDispatcher("../html/leavenote.jsp").forward(request, response);
    }

    private void teachingGeneral(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException{
        TeachingArrangementService TAS = new TeachingArrangementService();
        TeachingGeneral general = TAS.getCurGeneral();
        request.setAttribute("general",general);
        request.getRequestDispatcher("../html/educationalDetail-1.jsp").forward(request,response);
    }
}
