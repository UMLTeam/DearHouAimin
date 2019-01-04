package web.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domian.*;
import service.Impl.*;

/**
 * Servlet implementation class textServlet
 */
@WebServlet("/textServlet")
public class textServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public textServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=request.getParameter("method");
		if (method.equals("getAll")) {
			textbookService service=new textbookService();
			List<textbook>textbooks=service.getAll();
			request.getSession().setAttribute("books", textbooks);
			request.getRequestDispatcher("/admin/courseDetail/backcourseDetail-3.jsp").forward(request, response);
		}else if(method.equals("add")){
			textbookService service=new textbookService();
			textbook book=service.doupLoad(request);
			if(service.addBook(book)){
				service=new textbookService();
				List<textbook>textbooks=service.getAll();
				request.getSession().setAttribute("books", textbooks);
				request.getRequestDispatcher("/admin/courseDetail/backcourseDetail-3.jsp").forward(request, response);
			}
		}else if(method.equals("beforeUpdate")){
			int id=Integer.valueOf(request.getParameter("id"));
			textbookService service=new textbookService();
			textbook book=service.queryByid(id);
			request.getSession().setAttribute("book", book);
			Writer out=response.getWriter();
			out.write("{\"result\":"+1+"}");
			out.flush();
		}else if(method.equals("del")){
			int result=0;
			int id=Integer.valueOf(request.getParameter("id"));
			textbookService textbookService=new textbookService();
			if(textbookService.del(id)>0){
				result=1;
			}
			Writer out=response.getWriter();
			out.write("{\"result\":"+result+"}");
			out.flush();
		}else if(method.equals("update")){
			int id=Integer.valueOf(request.getParameter("id"));
			textbookService service=new textbookService();
			textbook book=service.queryByid(id);
			String temp=book.getDownloadlink();
			book=service.doupLoad(request);
			book.setDownloadlink(temp);
			book.setId(id);
			if(service.updateBook(book)){
				service=new textbookService();
				List<textbook>textbooks=service.getAll();
				request.getSession().setAttribute("books", textbooks);
				request.getRequestDispatcher("/admin/courseDetail/backcourseDetail-3.jsp").forward(request, response);
			}
		}else if(method.equals("getAll2")){
			textbookService service=new textbookService();
			List<textbook>textbooks=service.getAll();
			request.getSession().setAttribute("books", textbooks);
			request.getRequestDispatcher("/html/courseDetail/courseDetail-3.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
