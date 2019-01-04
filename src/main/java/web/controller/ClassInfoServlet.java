package web.controller;

import domain.ClassInfo;
import service.Impl.ClassInfoService;
import service.Impl.EvalatorService;
import utils.BaseServlet;
import utils.PageQuery;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClassInfoServlet")
public class ClassInfoServlet extends BaseServlet {
    ClassInfoService classInfoService = new ClassInfoService();
    EvalatorService evalatorService = new EvalatorService();
    public String LoadClassInfo(HttpServletRequest request, HttpServletResponse response){
        PageQuery<ClassInfo> classInfoPageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("classInfoPageQuery");
        classInfoPageQuery.setCurrentPage(Integer.parseInt(qp));
        classInfoPageQuery.setCurrentfirst((classInfoPageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        classInfoPageQuery.setItems(classInfoService.getClassInfoList(classInfoPageQuery.getCurrentfirst()));
        classInfoPageQuery.setTotalRows(classInfoService.getClassInfoTotal());
        request.getSession().setAttribute("classInfoQuery",classInfoPageQuery);
        return "r:/html/eduManageDetail-2.jsp";
    }

    public String Admin_LoadClassInfo(HttpServletRequest request, HttpServletResponse response){
        PageQuery<ClassInfo> classInfoQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("classInfoPageQuery");
        if(qp==null){
            qp = "1";
        }
        classInfoQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个评论的位置
        classInfoQuery.setCurrentfirst((classInfoQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
        //获取查询页的全部评论
        classInfoQuery.setItems(classInfoService.getClassInfoList(classInfoQuery.getCurrentfirst()));
        classInfoQuery.setTotalRows(classInfoService.getClassInfoTotal());
        request.getSession().setAttribute("classInfoQuery",classInfoQuery);
        return "r:/admin/admin-classInfo.jsp";
    }
    public String Add_ClassInfo(HttpServletRequest request, HttpServletResponse response){

        String class_name = request.getParameter("class_name");
        String specialty = request.getParameter("specialty");
        String course_name = request.getParameter("course_name");
        ClassInfo classInfo=new ClassInfo();
        classInfo.setCourse_name(course_name);
        classInfo.setClass_name(class_name);
        classInfo.setSpecialty(specialty);
        classInfoService.addClassInfo(classInfo);
        Admin_LoadClassInfo(request,response);
        return "r:/admin/admin-classInfo.jsp";
    }

    public String Delete_ClassInfo(HttpServletRequest request, HttpServletResponse response){
        String class_name=request.getParameter("class_name")+"";
        classInfoService.deleteClassInfo(class_name);
        Admin_LoadClassInfo(request,response);
        return "r:/admin/admin-classInfo.jsp";
    }
}
