package web.controller;

import domain.Online_Evalator;
import service.Impl.EvalatorService;
import utils.BaseServlet;
import utils.PageQuery;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@WebServlet("/EvalatorServlet")
public class EvalatorServlet extends BaseServlet {
    EvalatorService evalatorService=new EvalatorService();
    public String LoadStudentEvalator(HttpServletRequest request, HttpServletResponse response){

        PageQuery<Online_Evalator> EvalatorpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("EvalatorpageQuery");
        EvalatorpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个评论的位置
        EvalatorpageQuery.setCurrentfirst((EvalatorpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        EvalatorpageQuery.setItems(evalatorService.getEvalatorList(EvalatorpageQuery.getCurrentfirst()));
        EvalatorpageQuery.setTotalRows(evalatorService.getEvalatorTotal());
        request.getSession().setAttribute("EvalatorpageQuery",EvalatorpageQuery);

        return "r:/html/teachEffectDetail-4.jsp";
    }

    public String Admin_LoadStudentEvalator(HttpServletRequest request, HttpServletResponse response){

        PageQuery<Online_Evalator> EvalatorpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("EvalatorpageQuery");
        EvalatorpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个评论的位置
        EvalatorpageQuery.setCurrentfirst((EvalatorpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        EvalatorpageQuery.setItems(evalatorService.getEvalatorList(EvalatorpageQuery.getCurrentfirst()));
        EvalatorpageQuery.setTotalRows(evalatorService.getEvalatorTotal());
        request.getSession().setAttribute("EvalatorpageQuery",EvalatorpageQuery);
        return "r:/admin/admin-evalator.jsp";
    }
    public String Add_Evalator(HttpServletRequest request, HttpServletResponse response){
        String evalator_id= UUID.randomUUID().toString().replaceAll("-","");
        String course_teacher_name=request.getParameter("course_teacher_name");
        String course_time=request.getParameter("course_time");
        String course_name=request.getParameter("course_name");
        String course_property=request.getParameter("course_property");
        String course_grade=request.getParameter("course_grade");
        String course_level;
        try{
            Double grade=Double.parseDouble(course_grade);
        }catch (Exception e){
            request.setAttribute("info","请输入正确格式的分数");
            return "/admin/admin-evalator.jsp";
        }
        Double grade=Double.parseDouble(course_grade);
        if(grade<0||grade>100){
            request.getSession().setAttribute("info","分数必须介于0到100之间");
        }
        if(grade<20)
            course_level="差";
        else if(grade<40)
            course_level="较差";
        else if(grade<60)
            course_level="一般";
        else if(grade<80)
            course_level="良";
        else
            course_level="优秀";
        Online_Evalator evalator=new Online_Evalator();
        evalator.setEvalator_id(evalator_id);
        evalator.setCourse_level(course_level);
        evalator.setCourse_property(course_property);
        evalator.setCourse_time(course_time);
        evalator.setCourse_teacher_name(course_teacher_name);
        evalator.setCourse_grade(grade);
        evalator.setCourse_name(course_name);
        evalatorService.addEvalator(evalator);

        PageQuery<Online_Evalator> EvalatorpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp="1";
        EvalatorpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个评论的位置
        EvalatorpageQuery.setCurrentfirst((EvalatorpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        EvalatorpageQuery.setItems(evalatorService.getEvalatorList(EvalatorpageQuery.getCurrentfirst()));
        EvalatorpageQuery.setTotalRows(evalatorService.getEvalatorTotal());
        request.getSession().setAttribute("EvalatorpageQuery",EvalatorpageQuery);

        return "r:/admin/admin-evalator.jsp";
    }

    public String Delete_Evalator(HttpServletRequest request, HttpServletResponse response){
        String evalator_id=request.getParameter("evalator_id")+"";
        evalatorService.deleteEvalator(evalator_id);

        PageQuery<Online_Evalator> EvalatorpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp="1";
        EvalatorpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个评论的位置
        EvalatorpageQuery.setCurrentfirst((EvalatorpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        EvalatorpageQuery.setItems(evalatorService.getEvalatorList(EvalatorpageQuery.getCurrentfirst()));
        EvalatorpageQuery.setTotalRows(evalatorService.getEvalatorTotal());
        request.getSession().setAttribute("EvalatorpageQuery",EvalatorpageQuery);

        return "r:/admin/admin-evalator.jsp";
    }
}
