package web.controller;

import domain.dguterd4;
import service.Impl.educationreformdetail4Service;
import utils.ToJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

//教学改革措施
@WebServlet(name = "educationReformDetail4Action", urlPatterns = "/educationReformDetail4Action")
public class educationReformDetail4Action extends HttpServlet {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("type");
        int count = educationreformdetail4Service.getCountEducationReformDetail4Service();
        session.setAttribute("count", count);
        switch (action) {
            case "comeInto": {
                List<dguterd4> erd4List = educationreformdetail4Service.getAlltitleOfErd4Service();
                session.setAttribute("erd4List", erd4List);
                response.sendRedirect("/admin/admin_educationReformDetail1/education_RecognitionAndReward.jsp");
                break;
            }
            case "getAll": {
                List<dguterd4> erd4List = educationreformdetail4Service.getAlltitleOfErd4Service();
                if(erd4List.size() != 0){
                	String result = ToJson.dguterd4ToJosn(erd4List);
                	response.getWriter().write(result);
                }else{
                	response.getWriter().write("0");
                }
                break;
            }
            case "getContent":{
                int idea = Integer.parseInt(request.getParameter("id"));
                dguterd4 md_erd4 = educationreformdetail4Service.findOneEducationReformDetail4Service(idea);
                if(md_erd4 != null){
                	String result = ToJson.dguterd4OneToJosn(md_erd4);
                	response.getWriter().write(result);
                }else{
                	response.getWriter().write("0");
                }
                break;
            }
            case "add": {
                String erd_title = request.getParameter("erd_title");
                String erd_type = request.getParameter("erd_type");
                Date erd_date = Date.valueOf(request.getParameter("erd_date"));
                String erd_content = request.getParameter("erd_content");
                dguterd4 erd4 = educationreformdetail4Service.getOneEducationReformDetail4Service(erd_title, erd_type, erd_date, erd_content);
                educationreformdetail4Service.insertOneEducationReformDetail4Service(erd4);
                List<dguterd4> erd4List = educationreformdetail4Service.getAlltitleOfErd4Service();
                session.setAttribute("erd4List", erd4List);
                count = educationreformdetail4Service.getCountEducationReformDetail4Service();
                session.setAttribute("count", count);
                response.sendRedirect("/admin/admin_educationReformDetail1/education_RecognitionAndReward.jsp");
                break;
            }
            case "delete": {
                Integer operator1 = Integer.parseInt(request.getParameter("operator1"));
                count = educationreformdetail4Service.getCountEducationReformDetail4Service();
                session.setAttribute("count", count);
                response.getWriter().print(educationreformdetail4Service.deleteOneEducationReformDetail4Service(operator1));
                break;
            }
            case "state": {
                Integer operator1 = Integer.parseInt(request.getParameter("operator1"));
                Integer operator2 = Integer.parseInt(request.getParameter("operator2"));
                if (educationreformdetail4Service.changeStateService(operator2, operator1)) {
                    response.getWriter().print("1");
                } else {
                    response.getWriter().print("0");
                }
                break;
            }
            case "getOneObject": {
                int idea = Integer.parseInt(request.getParameter("id"));
                dguterd4 md_erd4 = educationreformdetail4Service.findOneEducationReformDetail4Service(idea);
                session.setAttribute("md_erd4", md_erd4);
                response.sendRedirect("/admin/admin_educationReformDetail1/modify_education_RecognitionAndReward.jsp");
                break;
            }
            case "erd4-type": {
                String type = request.getParameter("erd4_type");
                List<dguterd4> erd4List = educationreformdetail4Service.getAllSameTypeEducationReformDetail4Service(type);
                session.setAttribute("erd4List", erd4List);
                response.sendRedirect("/admin/admin_educationReformDetail1/education_RecognitionAndReward.jsp");
                break;
            }
            case "findName": {
                String MeasuresName = request.getParameter("MeasuresName");
                List<dguterd4> erd = educationreformdetail4Service.findMeasuresNameService(MeasuresName);
                session.setAttribute("erd4List", erd);
                response.sendRedirect("/admin/admin_educationReformDetail1/education_RecognitionAndReward.jsp");
                break;
            }
            case "edit": {
                int id = Integer.parseInt(request.getParameter("eid"));
                String erd_title = request.getParameter("erd_title");
                String erd_type = request.getParameter("erd_type");
                Date erd_date = Date.valueOf(request.getParameter("erd_date"));
                String erd_content = request.getParameter("erd_content");
                dguterd4 erd4 = educationreformdetail4Service.getOneEducationReformDetail4Service(erd_title, erd_type, erd_date,  erd_content);
                educationreformdetail4Service.modifyOneEducationReformDetail4Service(erd4, id);
                List<dguterd4> erd4List = educationreformdetail4Service.getAlltitleOfErd4Service();
                session.setAttribute("erd4List", erd4List);
                response.sendRedirect("/admin/admin_educationReformDetail1/education_RecognitionAndReward.jsp");
                break;
            }
            case "see": {
                int idea = Integer.parseInt(request.getParameter("seeid"));
                dguterd4 md_erd4 = educationreformdetail4Service.findOneEducationReformDetail4Service(idea);
                session.setAttribute("md_erd4", md_erd4);
                response.sendRedirect("/admin/admin_educationReformDetail1/display_education_RecognitionAndReward.jsp");
                break;
            }
            default:{
                System.out.println("NO HERE");
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void init() throws ServletException {
    }

}
