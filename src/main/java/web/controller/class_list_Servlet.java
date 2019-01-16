package web.controller;

import domain.Class_List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;
import utils.BaseServlet;
import utils.FileUploadUtils;
import utils.PageQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/class_list_Servlet")
public class class_list_Servlet extends BaseServlet {
	service.Impl.class_list_Service class_list_Service=new service.Impl.class_list_Service();


	public String Add_LoadStudentClassList(HttpServletRequest request, HttpServletResponse response){
		PageQuery<Class_List> classListpageQuery=new PageQuery<>();
		//想要查询的页数
		classListpageQuery.setCurrentPage(1);
		//想要查询页数的第一个评论的位置
		classListpageQuery.setCurrentfirst((classListpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
		//获取查询页的全部评论
		classListpageQuery.setItems(class_list_Service.getClassLists(classListpageQuery.getCurrentfirst()));
		classListpageQuery.setTotalRows(class_list_Service.getClassListTotal());
		return "r:/admin/admin_class_list.jsp";//???
	}
	public String LoadStudentClassList(HttpServletRequest request, HttpServletResponse response){

		PageQuery<Class_List> classListpageQuery=new PageQuery<>();
		//想要查询的页数
		String qp=request.getParameter("classListpageQuery");//?
		classListpageQuery.setCurrentPage(Integer.parseInt(qp));
		//想要查询页数的第一个评论的位置
		classListpageQuery.setCurrentfirst((classListpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
		//获取查询页的全部评论
		classListpageQuery.setItems(class_list_Service.getClassLists(classListpageQuery.getCurrentfirst()));
		classListpageQuery.setTotalRows(class_list_Service.getClassListTotal());
		request.getSession().setAttribute("classListpageQuery",classListpageQuery);

		return "r:/html/eduManageDetail-4.jsp";//???
	}

	public String Admin_LoadClassList(HttpServletRequest request, HttpServletResponse response){
		PageQuery<Class_List> classListpageQuery=new PageQuery<>();
		String type=request.getParameter("type1");
		//想要查询的页数
		String qp=request.getParameter("classListpageQuery");//?
		classListpageQuery.setCurrentPage(Integer.parseInt(qp));
		//想要查询页数的第一个评论的位置
		classListpageQuery.setCurrentfirst((classListpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
		//获取查询页的全部评论
		classListpageQuery.setItems(class_list_Service.getClassLists(classListpageQuery.getCurrentfirst()));
		classListpageQuery.setTotalRows(class_list_Service.getClassListTotal());
		request.getSession().setAttribute("classListpageQuery",classListpageQuery);

		return "r:/admin/admin_class_list.jsp";


	}

	public String AddClassList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		Map<String, String[]> map = new HashMap<String,String[]>();
		//		1.创建一个DiskFileItemFactory
		DiskFileItemFactory factory = new DiskFileItemFactory();
//    	2.创建ServletFileUpload类
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
//    	3.解析所有上传数据
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem fileItem : items) {
				if(fileItem.isFormField()) {
					if("class_name".equals(fileItem.getFieldName())){
						map.put("class_name", new String[] {fileItem.getString("utf-8")});
					}
					else if("major".equals(fileItem.getFieldName())){
						map.put("major", new String[] {fileItem.getString("utf-8")});
					}
					else if("course".equals(fileItem.getFieldName())){
						map.put("course", new String[] {fileItem.getString("utf-8")});
					}
				}
				else {
					String filename = fileItem.getName();
					filename = FileUploadUtils.getRealName(filename);//获取文件的真实文件名
					map.put("class_file_name",new String[] { filename });

					String uuidname = FileUploadUtils.getUUIDFileName(filename);
					map.put("class_file_uuidname", new String[] { uuidname });//获取并封装随机文件名

					String randompath = FileUploadUtils.getRandomDirectory(filename);
					String uploadpath = request.getServletContext().getRealPath("/WEB-INF/upload");
					File parentFile = new File(uploadpath, randompath);
					if(!parentFile.exists())
						parentFile.mkdirs();//创建文件保存的目录
					map.put("class_file", new String[] {"WEB-INF/upload"+randompath});//封装上传文件的保存路径


					//上传文件
					IOUtils.copy(fileItem.getInputStream(), new FileOutputStream(new File(parentFile, uuidname)));
					fileItem.delete();
				}
			}
			Class_List class_List=new Class_List();
			BeanUtils.populate(class_List, map);
			class_list_Service.addClassList(class_List);
			PageQuery<Class_List> classListpageQuery=new PageQuery<>();
			//想要查询的页数
			classListpageQuery.setCurrentPage(1);
			//想要查询页数的第一个评论的位置
			classListpageQuery.setCurrentfirst((classListpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
			//获取查询页的全部评论
			classListpageQuery.setItems(class_list_Service.getClassLists(classListpageQuery.getCurrentfirst()));
			classListpageQuery.setTotalRows(class_list_Service.getClassListTotal());
			request.getSession().setAttribute("classListpageQuery",classListpageQuery);
			return "r:/admin/admin_class_list.jsp";
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "r:/admin/admin_class_list.jsp";

	}
	public String deleteClassList(HttpServletRequest request, HttpServletResponse response){
		String class_id=request.getParameter("class_id")+"";//why
		class_list_Service.deleteClassList(class_id);
//        Add_LoadStudentClassList(request, response);
		PageQuery<Class_List> classListpageQuery=new PageQuery<>();
		//想要查询的页数
		classListpageQuery.setCurrentPage(1);
		//想要查询页数的第一个评论的位置
		classListpageQuery.setCurrentfirst((classListpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
		//获取查询页的全部评论
		classListpageQuery.setItems(class_list_Service.getClassLists(classListpageQuery.getCurrentfirst()));
		classListpageQuery.setTotalRows(class_list_Service.getClassListTotal());
		request.getSession().setAttribute("classListpageQuery",classListpageQuery);
		return "r:/admin/admin_class_list.jsp";//
	}

	public String searchByName(HttpServletRequest request, HttpServletResponse response){
		PageQuery<Class_List> classListpageQuery=new PageQuery<>();
		String nameString=request.getParameter("searchName")+"";
		String addr=request.getParameter("addr");
		List <Class_List> class_Lists=new ArrayList<Class_List>();
		class_Lists=class_list_Service.searchByName(nameString);
		//永远设为第一页
		classListpageQuery.setCurrentPage(1);
		//想要查询页数的第一个评论的位置
		classListpageQuery.setCurrentfirst((classListpageQuery.getCurrentPage()-1)* PageQuery.getDefaultPageSize());
		//获取查询页的全部评论
		classListpageQuery.setItems(class_Lists);
		classListpageQuery.setTotalRows(class_Lists.size());
		request.getSession().setAttribute("classListpageQuery",classListpageQuery);
		if("html".equals(addr)){
			return "r:/html/eduManageDetail-4.jsp";
		}else{
			return "r:/admin/admin_class_list.jsp";
		}

	}

	public void Download_Class_File(HttpServletRequest request, HttpServletResponse response) throws IOException   {
		//获取id
		String class_id = request.getParameter("class_id")+"";
		//调用service，得到resource对象
		//HomeworkService service = new HomeworkService();
		try {
			System.out.println(class_id);
			Class_List class_List=class_list_Service.getById(class_id);
			String uploadpath = request.getServletContext().getRealPath(class_List.getClass_file());
			File file = new File(uploadpath, class_List.getClass_file_uuidname());
			if(file.exists()) {
				String filename = class_List.getClass_file_name();
				String mimeType = this.getServletContext().getMimeType(filename);
				response.setContentType(mimeType);//设置下载类型
				String agent = request.getHeader("user-agent");
				if (agent.contains("MSIE")) {
					// IE浏览器
					filename = URLEncoder.encode(filename, "utf-8");

				} else if (agent.contains("Firefox")) {
					// 火狐浏览器
					BASE64Encoder base64Encoder = new BASE64Encoder();
					filename = "=?utf-8?B?"
							+ base64Encoder.encode(filename.getBytes("utf-8"))
							+ "?=";
				} else {
					// 其它浏览器
					filename = URLEncoder.encode(filename, "utf-8");
				}
				//设置永远是下载而不直接打开
				response.setHeader("Content-Disposition", "attachment;filename=" + filename);
				byte[] bs =FileUtils.readFileToByteArray(file);
				response.getOutputStream().write(bs);
				return;
			}
			else {
				throw new RuntimeException("资源已过期");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}
