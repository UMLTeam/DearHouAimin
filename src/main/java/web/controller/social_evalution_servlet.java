package web.controller;


import domain.social_evalution;
import service.Impl.social_evalutionService;
import utils.BaseServlet;
import utils.PageQuery;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/social_evalution_servlet")
public class social_evalution_servlet extends BaseServlet {

    protected social_evalutionService evalutionService = new social_evalutionService();

    public String addEvalution(HttpServletRequest request, HttpServletResponse response){

        String evalutionTitle = request.getParameter("evalutionTitle");
        String teacherName=request.getParameter("teacherName");
        String content=request.getParameter("content");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String evalutionTime = df.format(new Date());

        social_evalution evalution = new social_evalution();
        evalution.setEvalutionTitle(evalutionTitle);
        evalution.setContent(content);
        evalution.setEvalutionTime(evalutionTime);

        evalutionService.addEvalution(evalution);

        return "r:/admin/social_evalution.jsp";
    }


    public String deleteEvalution(HttpServletRequest request, HttpServletResponse response){
        String evalator_id=request.getParameter("evalatorId")+"";
        evalutionService.deleteEvalator(evalator_id);


        return "r:/admin/social_evalution.jsp";
    }

    public String LoadSocialEvalator(HttpServletRequest request, HttpServletResponse response){

        PageQuery<social_evalution> EvalatorpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("EvalatorpageQuery");
        EvalatorpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个评论的位置
        EvalatorpageQuery.setCurrentfirst((EvalatorpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        EvalatorpageQuery.setItems(evalutionService.getEvalatorList(EvalatorpageQuery.getCurrentfirst()));
        EvalatorpageQuery.setTotalRows(evalutionService.getEvalatorTotal());
        request.getSession().setAttribute("EvalatorpageQuery",EvalatorpageQuery);

        System.out.println(EvalatorpageQuery);
        return "r:/html/teachEffectDetail-5.jsp";
    }




    public String Admin_LoadSocialEvalator(HttpServletRequest request, HttpServletResponse response){

        PageQuery<social_evalution> EvalatorpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("EvalatorpageQuery");
        System.out.println(qp);
        EvalatorpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个评价的位置
        EvalatorpageQuery.setCurrentfirst((EvalatorpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        EvalatorpageQuery.setItems(evalutionService.getEvalatorList(EvalatorpageQuery.getCurrentfirst()));
        EvalatorpageQuery.setTotalRows(evalutionService.getEvalatorTotal());
        System.out.println(EvalatorpageQuery);
        request.getSession().setAttribute("EvalatorpageQuery",EvalatorpageQuery);
        return "r:/admin/social_evalution.jsp";
    }

    public String editStatus(HttpServletRequest request, HttpServletResponse response){
        String sta = request.getParameter("status");
        String id = request.getParameter("evalutionId");
        int status = Integer.parseInt(sta);
        int evalutionId = Integer.parseInt(id);
        evalutionService.editStatus(evalutionId,status);
        return "r:/admin/social_evalution.jsp";
    }



}
