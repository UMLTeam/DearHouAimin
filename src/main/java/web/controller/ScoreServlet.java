package web.controller;

import domain.Student_Score;
import service.Impl.Student_ScoreService;
import utils.BaseServlet;
import utils.PageQuery;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ScoreServlet")
public class ScoreServlet extends BaseServlet {
    Student_ScoreService studentService=new Student_ScoreService();
    public String LoadStudentEvalator(HttpServletRequest request, HttpServletResponse response){

        PageQuery<Student_Score> StudentpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("StudentpageQuery");
        StudentpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个学生的位置
        StudentpageQuery.setCurrentfirst((StudentpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        StudentpageQuery.setItems(studentService.getEvalatorList(StudentpageQuery.getCurrentfirst()));
        StudentpageQuery.setTotalRows(studentService.getEvalatorTotal());
        request.getSession().setAttribute("StudentpageQuery",StudentpageQuery);
        request.getSession().setAttribute("info","");
        return "r:/html/eduManageDetail-3.jsp";
    }

    public String Admin_LoadStudentEvalator(HttpServletRequest request, HttpServletResponse response){

        PageQuery<Student_Score> EvalatorpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("EvalatorpageQuery");
        EvalatorpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个评论的位置
        EvalatorpageQuery.setCurrentfirst((EvalatorpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        EvalatorpageQuery.setItems(studentService.getEvalatorList(EvalatorpageQuery.getCurrentfirst()));
        EvalatorpageQuery.setTotalRows(studentService.getEvalatorTotal());
        request.getSession().setAttribute("EvalatorpageQuery",EvalatorpageQuery);
        request.getSession().setAttribute("info","");
        return "r:/admin/admin_student.jsp";
    }

    public String Delete_Evalator(HttpServletRequest request, HttpServletResponse response){
        String evalator_id=request.getParameter("evalator_id")+"";
        studentService.deleteEvalator(evalator_id);

        request.getSession().setAttribute("info","学号为"+evalator_id+"的学生成绩信息删除成功！");
        //return "r:/admin/admin_student.jsp";
        return "r:/ScoreServlet?method=Admin_LoadStudentEvalator&EvalatorpageQuery=1";
    }
    public String moddifyStudent(HttpServletRequest request, HttpServletResponse response){
        boolean flag;
        String studentNo=request.getParameter("studentNo");
        String grade=request.getParameter("grade");
        try{
            Double testGrade=Double.parseDouble(grade);
        }catch (Exception e){
            request.setAttribute("info","修改失败：分数必须是数字");
            return "/admin/admin_student.jsp";
        }
        Double newgrade=Double.parseDouble(grade);
        if(newgrade<0||newgrade>100){
            request.getSession().setAttribute("info","修改失败：分数必须介于0到100之间");
            return "r:/admin/admin_student.jsp";
        }
        flag=studentService.modifyStudent(studentNo,newgrade);
        if (flag){
            request.getSession().setAttribute("info","修改成功！");
        }else{
            request.getSession().setAttribute("info","修改失败，没有该学生！");
        }
        return "r:/ScoreServlet?method=Admin_LoadStudentEvalator&EvalatorpageQuery=1";
    }
    public String Add_Evalator(HttpServletRequest request, HttpServletResponse response){
        String studentName=request.getParameter("studentName");
        String studentNo=request.getParameter("studentNo");
        String major=request.getParameter("major");
        String course=request.getParameter("course");
        String className=request.getParameter("className");
        String grade=request.getParameter("grade");

        try{
            Double testGrade=Double.parseDouble(grade);
        }catch (Exception e){
            request.setAttribute("info","添加失败：分数必须是数字");
            return "/admin/admin_student.jsp";
        }
        Double newgrade=Double.parseDouble(grade);
        if(newgrade<0||newgrade>100){
            request.getSession().setAttribute("info","添加失败：分数必须介于0到100之间");
            return "r:/admin/admin_student.jsp";
        }
        Student_Score stu=new Student_Score();
        stu.setScore(newgrade);
        stu.setStudentNo(studentNo);
        stu.setStudentName(studentName);
        stu.setMajor(major);
        stu.setClassName(className);
        stu.setCourse(course);
        studentService.addEvalator(stu);
        request.setAttribute("info","添加成功！");
        request.getSession().setAttribute("info","添加成功！");
        return "r:/ScoreServlet?method=Admin_LoadStudentEvalator&EvalatorpageQuery=1";
    }

    public String selectStudent(HttpServletRequest request, HttpServletResponse response){

        PageQuery<Student_Score> StudentpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("StudentpageQuery");
        String studentNo=request.getParameter("studentNo");
        StudentpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个学生的位置
        StudentpageQuery.setCurrentfirst((StudentpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        StudentpageQuery.setItems(studentService.selectStudent(studentNo,StudentpageQuery.getCurrentfirst()));
        StudentpageQuery.setTotalRows(studentService.getOneStudentTotal(studentNo));
        request.getSession().setAttribute("StudentpageQuery",StudentpageQuery);
        return "r:/html/eduManageDetail-3.jsp";
    }

    public String selectAddminStudent(HttpServletRequest request, HttpServletResponse response){

        PageQuery<Student_Score> StudentpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("StudentpageQuery");
        String studentNo=request.getParameter("studentNo");
        StudentpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个学生的位置
        StudentpageQuery.setCurrentfirst((StudentpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        StudentpageQuery.setItems(studentService.selectStudent(studentNo,StudentpageQuery.getCurrentfirst()));
        StudentpageQuery.setTotalRows(studentService.getOneStudentTotal(studentNo));
        request.getSession().setAttribute("EvalatorpageQuery",StudentpageQuery);
        request.getSession().setAttribute("info","");
        return "r:/admin/admin_student.jsp";
    }
}
