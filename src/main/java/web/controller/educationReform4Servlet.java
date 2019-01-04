package web.controller;



import dao.Impl.educationReformDetail4Dao;
import domain.educationReformDetail4Bean;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "educationReform4Servlet",urlPatterns = "/educationReform4Servlet")
public class educationReform4Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        educationReformDetail4Dao dgutReform4Dao = new educationReformDetail4Dao();
        List<educationReformDetail4Bean> dgutRewardArticles = new ArrayList<educationReformDetail4Bean>();
        try {
            dgutRewardArticles = dgutReform4Dao.getAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int pageSize = 5;//每页显示5条信息
        JSONArray array = new JSONArray();
        List<educationReformDetail4Bean> temp;
        int yushu = dgutRewardArticles.size() % pageSize;
        int pageNum;
        if (yushu == 0) {
            pageNum = dgutRewardArticles.size() / pageSize;
        } else {
            pageNum = dgutRewardArticles.size() / pageSize + 1;
        }
        if (pageNum == 1 && yushu != 0) {//不足一页的情况
            temp = new ArrayList<educationReformDetail4Bean>();
            temp = dgutRewardArticles.subList(0, yushu);
            array.put(temp);
        } else if (pageNum == 1 && yushu == 0) {//刚好只有一页的情况
            temp = new ArrayList<educationReformDetail4Bean>();
            temp = dgutRewardArticles.subList(0, pageSize);
            array.put(temp);
        } else {
            int i = 0;
            for (; i < pageNum - 1; i++) {
                temp = new ArrayList<educationReformDetail4Bean>();
                temp = dgutRewardArticles.subList(i * pageSize, i * pageSize + pageSize);
                array.put(temp);
            }

            //处理最后一页的情况
            if (dgutRewardArticles.size() % pageSize == 0) {
                temp = new ArrayList<educationReformDetail4Bean>();
                temp = dgutRewardArticles.subList(i * pageSize, i * pageSize + pageSize);
                array.put(temp);
            } else {
                temp = new ArrayList<educationReformDetail4Bean>();
                temp = dgutRewardArticles.subList(i * pageSize, i * pageSize + yushu);
                array.put(temp);
            }
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(array);
    }
}
