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

@WebServlet(name = "educationReform4ArticleServlet", urlPatterns = "/educationReform4ArticleServlet")
public class educationReform4ArticleServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        educationReformDetail4Dao dgutReform4Dao = new educationReformDetail4Dao();
        List<educationReformDetail4Bean> dgutRewardArticle = new ArrayList<educationReformDetail4Bean>();
        try {
            String id=request.getParameter("address");
            System.out.println(id);
            dgutRewardArticle = dgutReform4Dao.getById(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONArray array = new JSONArray();
        array.put(dgutRewardArticle);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(array);
    }
}
