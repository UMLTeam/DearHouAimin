package web.controller;

import domain.dguterd1;
import service.Impl.educationreformdetail1Service;
import utils.ToJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
//教学改革措施
@WebServlet("/educationReformDetail1Action")
public class educationReformDetail1Action extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("type");
//        int count = educationreformdetail1Service.getCountEducationReformDetail1Service();
//        session.setAttribute("count", count);
        System.out.println("action: " + action);
        
        switch (action) {
            case "comeInto": {
                List<dguterd1> erd1List = educationreformdetail1Service.getAlltitleOfErd1Service();
                session.setAttribute("erd1List", erd1List);
                session.setAttribute("count", erd1List.size());
                response.sendRedirect("/admin/admin_educationReformDetail1/education_reform_measures_list.jsp");
                break;
            }
            case "getAll": {
            	ArrayList<dguterd1> erd1List = educationreformdetail1Service.getAlltitleOfErd1Service();
                if(erd1List != null){
                	String result = ToJson.dguterd1ToJosn(erd1List);
                	System.out.println(result);
                	response.getWriter().write(result);
                }else{
                	response.getWriter().write("0");
                }
                break;
            }
            case "getContent":{
                int idea = Integer.parseInt(request.getParameter("id"));
                dguterd1 md_erd1 = educationreformdetail1Service.findOneEducationReformDetail1Service(idea);
                if(md_erd1 != null){
                	String result = ToJson.dguterd1OneToJosn(md_erd1);
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
                String erd_origin = request.getParameter("erd_origin");
                String erd_content = request.getParameter("erd_content");
                dguterd1 erd1 = educationreformdetail1Service.getOneEducationReformDetail1Service(erd_title, erd_type, erd_date, erd_origin, erd_content);
                educationreformdetail1Service.insertOneEducationReformDetail1Service(erd1);
                List<dguterd1> erd1List = educationreformdetail1Service.getAlltitleOfErd1Service();
                session.setAttribute("erd1List", erd1List);
                session.setAttribute("count", erd1List.size());
                response.sendRedirect("/admin/admin_educationReformDetail1/education_reform_measures_list.jsp");
                break;
            }
            case "delete": {
                Integer operator1 = Integer.parseInt(request.getParameter("operator1"));
                int count = educationreformdetail1Service.getCountEducationReformDetail1Service();
                session.setAttribute("count", count);
                response.getWriter().print(educationreformdetail1Service.deleteOneEducationReformDetail1Service(operator1));
                break;
            }
            case "state": {
                Integer operator1 = Integer.parseInt(request.getParameter("operator1"));
                Integer operator2 = Integer.parseInt(request.getParameter("operator2"));
                if (educationreformdetail1Service.changeStateService(operator2, operator1)) {
                    response.getWriter().print("1");
                } else {
                    response.getWriter().print("0");
                }
                break;
            }
            case "getOneObject": {
                int idea = Integer.parseInt(request.getParameter("id"));
                dguterd1 md_erd1 = educationreformdetail1Service.findOneEducationReformDetail1Service(idea);
                session.setAttribute("md_erd1", md_erd1);
                session.setAttribute("count", 1);
                response.sendRedirect("/admin/admin_educationReformDetail1/modify_education_reform_measures.jsp");
                break;
            }
            case "erd1-type": {
                String type = request.getParameter("erd1_type");
                List<dguterd1> erd1List = educationreformdetail1Service.getAllSameTypeEducationReformDetail1Service(type);
                session.setAttribute("erd1List", erd1List);
                session.setAttribute("count", erd1List.size());
                response.sendRedirect("/admin/admin_educationReformDetail1/education_reform_measures_list.jsp");
                break;
            }
            case "findName": {
                String MeasuresName = request.getParameter("MeasuresName");
                List<dguterd1> erd = educationreformdetail1Service.findMeasuresNameService(MeasuresName);
                session.setAttribute("erd1List", erd);
                session.setAttribute("count", erd.size());
                response.sendRedirect("/admin/admin_educationReformDetail1/education_reform_measures_list.jsp");
                break;
            }
            case "edit": {
                int id = Integer.parseInt(request.getParameter("eid"));
                String erd_title = request.getParameter("erd_title");
                String erd_type = request.getParameter("erd_type");
                Date erd_date = Date.valueOf(request.getParameter("erd_date"));
                String erd_origin = request.getParameter("erd_origin");
                String erd_content = request.getParameter("erd_content");
                dguterd1 erd1 = educationreformdetail1Service.getOneEducationReformDetail1Service(erd_title, erd_type, erd_date, erd_origin, erd_content);
                educationreformdetail1Service.modifyOneEducationReformDetail1Service(erd1, id);
                List<dguterd1> erd1List = educationreformdetail1Service.getAlltitleOfErd1Service();
                session.setAttribute("erd1List", erd1List);
                session.setAttribute("count", erd1List.size());
                response.sendRedirect("/admin/admin_educationReformDetail1/education_reform_measures_list.jsp");
                break;
            }
            case "see": {
                int idea = Integer.parseInt(request.getParameter("seeid"));
                dguterd1 md_erd1 = educationreformdetail1Service.findOneEducationReformDetail1Service(idea);
                session.setAttribute("md_erd1", md_erd1);
                session.setAttribute("count", 1);
                response.sendRedirect("/admin/admin_educationReformDetail1/display_education_Reform_measures.jsp");
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
