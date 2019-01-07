package web.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.SimpleDateFormat;

import dao.Impl.Erd2Delete;
import dao.Impl.Erd2Uploads;
import dao.Impl.educationReformDetail2Dao;
import domain.educationReformDetail2Bean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;



/**
 * Servlet implementation class Erd2
 */
@WebServlet("/Erd2servlet")
public class Erd2servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Erd2servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("type");
		System.out.println(type);
		if("all".equals(type)){
			educationReformDetail2Dao eRDD = new educationReformDetail2Dao();
			List<educationReformDetail2Bean> dgutEdus = new ArrayList<educationReformDetail2Bean>();
			List<educationReformDetail2Bean> dgutEdus1 = new ArrayList<educationReformDetail2Bean>();
			List<educationReformDetail2Bean> dgutEdus2 = new ArrayList<educationReformDetail2Bean>();
			try {
				dgutEdus = eRDD.getAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int pageSize = 5;//每页显示5条信息
			JSONArray array = new JSONArray();
			List<educationReformDetail2Bean> temp;
			int yushu = dgutEdus.size()%pageSize;
			int pageNum;
			if(yushu == 0) {
				pageNum = dgutEdus.size()/pageSize;
			}else {
				pageNum = dgutEdus.size()/pageSize+1;
			}
			if(pageNum == 1 && yushu!=0) {//不足一页的情况
				temp = new ArrayList<educationReformDetail2Bean>();
				temp = dgutEdus.subList(0, yushu);
				array.put(temp);
			}else if(pageNum == 1 && yushu==0) {//刚好只有一页的情况
				temp = new ArrayList<educationReformDetail2Bean>();
				temp = dgutEdus.subList(0, pageSize);
				array.put(temp);
			}
			else {
				int i=0;
				for(;i<pageNum-1;i++) {
					temp = new ArrayList<educationReformDetail2Bean>();
					temp = dgutEdus.subList(i*pageSize, i*pageSize+pageSize);
					array.put(temp);
				}

				//处理最后一页的情况
				if(dgutEdus.size()%pageSize == 0) {
					temp = new ArrayList<educationReformDetail2Bean>();
					temp = dgutEdus.subList(i*pageSize, i*pageSize+pageSize);
					array.put(temp);
				}else {
					temp = new ArrayList<educationReformDetail2Bean>();
					temp = dgutEdus.subList(i*pageSize, i*pageSize+yushu);
					array.put(temp);
				}
			}
			response.setContentType("text/html;charset=utf-8");
//		PrintWriter writer = response.getWriter();
//		writer.println(array);

//		JSONArray array = new JSONArray();
//			educationReformDetail2Bean education;
//			for(int i=0;i<5;i++) {
//				education=new educationReformDetail2Bean();
//				education.setAddress(String.valueOf(i));
//				education.setTime(String.valueOf(i));
//				education.setTitle(String.valueOf(i));
//				dgutEdus2.add(education);
//			}
//			array.put(dgutEdus2);
//			for(int i=5;i<10;i++) {
//				education=new educationReformDetail2Bean();
//				education.setAddress(String.valueOf(i));
//				education.setTime(String.valueOf(i));
//				education.setTitle(String.valueOf(i));
//				dgutEdus1.add(education);
//			}
//			array.put(dgutEdus1);
			System.out.println(array);
			PrintWriter writer = response.getWriter();
			writer.println(array);
//		//System.out.println(array);
//		System.out.println(dgutEdus.get(0).getAddress());
//		JsonArray jsonList = new JsonArray();
//		for(int i=0; i<dgutEdus.size(); i++) {
//			JsonObject json = new JsonObject();
//			json.addProperty("address", dgutEdus.get(i).getAddress());
//			json.addProperty("title", dgutEdus.get(i).getTitle());
//			json.addProperty("time", dgutEdus.get(i).getTime());
//			jsonList.add(json);
//		}
//		PrintWriter writer = response.getWriter();
//		writer.write(jsonList.toString());
//
		}else if("upload".equals(type)){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");//设置日期格式
			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
			 String address="\\upload\\20141128";//存放文件位置
			 String time=df.format(new Date());//获取日期时间
			String  time1=df1.format(new Date());
             String title="";
 			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			//解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			factory.setSizeThreshold(1024 * 5000);//设置内存的临界值为500K
			File temp = new File(address);//当超过500K的时候，存到一个临时文件夹中
			factory.setRepository(temp);
			upload.setSizeMax(1024 * 1024 * 50);//设置上传的文件总的大小不能超过500M
			try {
				// 1. 得到 FileItem 的集合 items
				List<FileItem> /* FileItem */items = upload.parseRequest(request);

				// 2. 遍历 items:
				// 若是一个一般的表单域, 打印信息
				for (FileItem item : items)
					if (item.isFormField()) {
						title = item.getString("utf-8");
					} else {
						String fileName = item.getName();

						long sizeInBytes = item.getSize();

						//String fileType = item.getContentType();
						String fileType = fileName.substring(fileName.lastIndexOf("."));
						;
						System.out.println(fileType);
						System.out.println(fileName);
						System.out.println(sizeInBytes);

						InputStream in = item.getInputStream();
						byte[] buffer = new byte[1024];
						int len = 0;
						System.out.println(time1);
						address = address + "\\" + time1 + fileType;//文件最终上传的位置
						String fullAdress = request.getSession().getServletContext().getRealPath(address);//获取上传文件绝对路径，防止不同系统中文件路径不一致
						System.out.println("文件的绝对路径：" + fullAdress);
						System.out.println("文件标题: " + title);
						System.out.println("文件上传时间:  " + time);
						FileOutputStream out = new FileOutputStream(fullAdress);
						Erd2Uploads erd2Uploads = new Erd2Uploads();
						erd2Uploads.insertToDB(address, title, time);

						while ((len = in.read(buffer)) != -1) {
							out.write(buffer, 0, len);
						}

						out.close();
						in.close();
						System.out.println("上传完成");
						response.setCharacterEncoding("UTF-8");
						PrintWriter printWriter = response.getWriter();
						printWriter.println("上传成功！！！");
					}

			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("delete".equals(type)) {
			String decId = request.getParameter("id");
			Erd2Delete erd2Delete = new Erd2Delete();
			try {
				erd2Delete.deleteFromDB(decId);
				System.out.println("删除  ："+request.getParameter("id"));
				System.out.println("删除  ："+request.getParameter("address"));
				System.out.println("删除  ："+request.getSession().getServletContext().getRealPath(request.getParameter("address")));//获取上传文件绝对路径，防止不同系统中文件路径不一致);
			    String address=request.getParameter("address");
			    address=address.substring(2,address.length());
			    String  realAddress=request.getSession().getServletContext().getRealPath(address);
			    System.out.println(realAddress);
				File file=new File(realAddress);
				if(file.exists()){
					file.delete();
					System.out.println("删除成功！！");
				}else {
					System.out.println("该文件不存在！！！");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("adminAll".equals(type)){
			educationReformDetail2Dao eRDD = new educationReformDetail2Dao();
			List<educationReformDetail2Bean> dgutEdus = new ArrayList<educationReformDetail2Bean>();
			List<educationReformDetail2Bean> dgutEdus1 = new ArrayList<educationReformDetail2Bean>();
			List<educationReformDetail2Bean> dgutEdus2 = new ArrayList<educationReformDetail2Bean>();
			try {
				dgutEdus = eRDD.getAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/html;charset=utf-8");
			JSONArray array = new JSONArray();
		    array.put(dgutEdus);
			System.out.println(array);
			PrintWriter writer = response.getWriter();
			writer.println(array);

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
