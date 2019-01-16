package web.controller;

import domain.OpenCoursePlan;
import domain.Term;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.Impl.OpenCoursePlanService;
import utils.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@WebServlet("/OpenCoursePlanServlet")
public class OpenCoursePlanServlet extends BaseServlet {
    // 获取 学期对象 数组，方便在前端渲染选项
    private List<Term> gettermArray(int beginYear){
        Calendar cal = Calendar.getInstance();
        int curYear =  cal.get(Calendar.YEAR);
        List<Term> termArray = new ArrayList<Term>((curYear-beginYear+1)*2);
        for (int y=curYear; y>=beginYear; --y){
            Term term = new Term(y*100000+(y+1)*10+2);
            termArray.add(term);
            term = new Term(y*100000+(y+1)*10+1);
            termArray.add(term);
        }
        return termArray;
    }


    /*
        获取开课计划列表
      */
    private void getPlanTable(HttpServletRequest request, HttpServletResponse response){
        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");
        int page;
        int size;
        if(pageStr == null) page = 0;
        else page = Integer.parseInt(pageStr);
        if(sizeStr == null) size = 4;
        else size = Integer.parseInt(sizeStr);

        // 每次查询size+1个记录，可以判断是否存在下一页
        List plans = OpenCoursePlanService.getPlanList(page, size);

        request.setAttribute("curPage", page);
        if(plans.size() == size+1){
            request.setAttribute("nextPage", true);
            plans.remove(size);
        }else{
            request.setAttribute("nextPage", false);
        }
        request.setAttribute("plans", plans);
    }
    // 显示前台页面
    public String showFront(HttpServletRequest request, HttpServletResponse response){
        getPlanTable(request, response);
        return "f:/html/eduManageDetail-1.jsp";
    }
    // 显示后台页面
    public String showBack(HttpServletRequest request, HttpServletResponse response){
        getPlanTable(request, response);
        request.setAttribute("termArray", gettermArray(2000));
        return "f:/admin/admin_open_course_plan.jsp";
    }


    /*
        显示开课计划的pdf文档 resource/open_course_plan_files/
     */
    private void showPDF(HttpServletRequest request, HttpServletResponse response){
        String path = request.getParameter("filePath");
        String term = request.getParameter("term");
        request.setAttribute("path", path);
        request.setAttribute("term", term);
    }
    public String showPDFAtFront(HttpServletRequest request, HttpServletResponse response){
        showPDF(request, response);
        return "f:/html/eduManageCoursePlan.jsp";
    }
    public String showPDFAtBack(HttpServletRequest request, HttpServletResponse response){
        showPDF(request, response);
        return "f:/admin/admin_show_open_course_plan.jsp";
    }


    /*
        删除开课计划
     */
    public String delete(HttpServletRequest request, HttpServletResponse response){
        String idStr = request.getParameter("id");
        if(idStr == null){
            request.setAttribute("message", "删除失败，缺少删除必要的参数");
        }else{
            int id = Integer.parseInt(idStr);
            // 获取项目文件根路径
            String contextRealPath = request.getSession().getServletContext().getRealPath("/");
            if(OpenCoursePlanService.delete(id, contextRealPath)){
                request.setAttribute("message", "删除成功");
            }
            else{
                request.setAttribute("message", "从数据库中删除出现错误");
            }
        }
        return "f:/admin/message.jsp";
    }


    /*
        添加开课计划
     */
    public String add(HttpServletRequest request, HttpServletResponse response){
        //文件上传的三部曲
        //创建工厂
        DiskFileItemFactory factory= new DiskFileItemFactory();
        //创建解析器
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //设置上传文件的大小
        sfu.setFileSizeMax(20*1024*1024);
        //解析request

        OpenCoursePlan openCoursePlan=new OpenCoursePlan();
        try {
            List<FileItem> list=sfu.parseRequest(request);
            String term=list.get(0).getString("utf-8");
            openCoursePlan.setTerm(Integer.parseInt(term));
            //System.out.println(term);

            //得到文件名称
            String fileName= list.get(1).getName();
            //校验格式
            if(!fileName.toLowerCase().endsWith("pdf")){
                System.out.println("文件格式不是pdf");
                request.setAttribute("message", "你上传的文件格式不是pdf格式");
                return "f:/admin/message.jsp";
            }

            //设置文件保存的目录
            String uploadPath = getServletContext().getRealPath("/") + "resource/open_course_plan_files/";
            // 构造文件名
            fileName = openCoursePlan.getTermName() + ".pdf";
            File f = new File(uploadPath, fileName);
            //保存文件
            list.get(1).write(f);
            // 保存文件存储路径
            openCoursePlan.setFilePath("resource/open_course_plan_files/" + fileName);

        } catch (FileUploadException e) {
            if(e instanceof FileUploadBase.FileSizeLimitExceededException){
                request.setAttribute("msg", "你的上传的文件大于15k");
                return "f:/admin/message.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String message = OpenCoursePlanService.add(openCoursePlan);
        request.setAttribute("message", message);
        return "f:/admin/message.jsp";
    }

}
