package web.controller;

import domain.Expert_Evaluation;
import service.Impl.Expert_EvaluationService;
import utils.BaseServlet;
import utils.PageQuery;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet("/Expert_EvaluationServlet")
public class Expert_EvaluationServlet extends BaseServlet {
    Expert_EvaluationService expert_evaluation = new Expert_EvaluationService();

    public String addContent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Expert_Evaluation evaluation = new Expert_Evaluation();
        String qp = (String) request.getSession().getAttribute("CurrentPage");
        String type = (String) request.getSession().getAttribute("type");
        evaluation.setTitle(request.getParameter("articletitle"));
        evaluation.setType(request.getParameter("articlecolumn"));
        evaluation.setContent(request.getParameter("content"));
        //设置时间
        java.util.Date date = new java.util.Date();          // 获取一个Date对象
        Timestamp timeStamp = new Timestamp(date.getTime());     //   将日期时间转换为数据库中的timestamp类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:MM");
        String time = simpleDateFormat.format(timeStamp);
        evaluation.setTime(time);
        evaluation.setEvaluation_id(java.util.UUID.randomUUID().toString());
        expert_evaluation.addContent(evaluation);
        return "/Expert_EvaluationServlet?method=LoadExpert_Evaluation&EvaluationpageQuery=" + qp + "&type=" + type;
    }

    public String deleteContent(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String qp = (String) request.getSession().getAttribute("CurrentPage");
        String type = (String) request.getSession().getAttribute("type");
        expert_evaluation.deleteContent(id);
        return "/Expert_EvaluationServlet?method=LoadExpert_Evaluation&EvaluationpageQuery=" + qp + "&type=" + type;
    }

    public String getContentById(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Expert_Evaluation evaluation = expert_evaluation.getContentById(id);
        request.getSession().setAttribute("editContent", evaluation);
        return null;
    }

    public String editContentById(HttpServletRequest request, HttpServletResponse response) {
        getContentById(request, response);
        return "r:/admin/Expert_Evaluation_edit.jsp";
    }

    public String showContentById(HttpServletRequest request, HttpServletResponse response) {
        getContentById(request, response);
        return "r:/admin/Expert_Evaluation_show.jsp";
    }

    public String editContent(HttpServletRequest request, HttpServletResponse response) {
        Expert_Evaluation evaluation = (Expert_Evaluation) request.getSession().getAttribute("editContent");
        String qp = (String) request.getSession().getAttribute("CurrentPage");
        String type = (String) request.getSession().getAttribute("type");
        evaluation.setTitle(request.getParameter("articletitle"));
        evaluation.setType(request.getParameter("articlecolumn"));
        evaluation.setContent(request.getParameter("content"));
        //设置时间
        java.util.Date date = new java.util.Date();          // 获取一个Date对象
        Timestamp timeStamp = new Timestamp(date.getTime());     //   将日期时间转换为数据库中的timestamp类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:MM");
        String time = simpleDateFormat.format(timeStamp);
        evaluation.setTime(time);
        expert_evaluation.editContent(evaluation);
        return "/Expert_EvaluationServlet?method=LoadExpert_Evaluation&EvaluationpageQuery=" + qp + "&type=" + type;
    }

    public String LoadExpert_Evaluation(HttpServletRequest request, HttpServletResponse response) {
        String type = request.getParameter("type");
        PageQuery<Expert_Evaluation> EvaluationpageQuery = new PageQuery<>();
        //想要查询的页数
        String qp = request.getParameter("EvaluationpageQuery");
        EvaluationpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个评论的位置
        EvaluationpageQuery.setCurrentfirst((EvaluationpageQuery.getCurrentPage() - 1) * PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        EvaluationpageQuery.setItems(expert_evaluation.getEvaluationList(EvaluationpageQuery.getCurrentfirst(), type));
        EvaluationpageQuery.setTotalRows(expert_evaluation.getEvaluationTotal(type));
        request.getSession().setAttribute("EvaluationpageQuery", EvaluationpageQuery);
        request.getSession().setAttribute("CurrentPage", String.valueOf(EvaluationpageQuery.getCurrentPage()));
        request.getSession().setAttribute("type", type);

        return "r:/admin/Expert_Evaluation.jsp";
    }

    public String getOneContent(HttpServletRequest request, HttpServletResponse response) {
        Expert_Evaluation evaluation = new Expert_Evaluation();
        String n = request.getParameter("n");
        String number = request.getParameter("number");
        String type = request.getParameter("type");
        String total = String.valueOf(expert_evaluation.getEvaluationTotal(type));
        evaluation = expert_evaluation.getOneEvaluation(Integer.parseInt(number), type);
        request.getSession().setAttribute("evaluation", evaluation);
        request.getSession().setAttribute("number", number);
        request.getSession().setAttribute("total", total);
        return "r:/html/teachEffectDetail-" + n + ".jsp";
    }
}
