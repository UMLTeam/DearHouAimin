<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,
javax.servlet.ServletConfig,
javax.servlet.ServletException,
javax.servlet.http.HttpServlet,
javax.servlet.annotation.WebServlet,
javax.servlet.http.HttpServletRequest,
javax.servlet.http.HttpServletResponse,
java.util.LinkedHashMap,
java.sql.Timestamp,
java.text.SimpleDateFormat,
com.fasterxml.jackson.core.type.TypeReference,
com.fasterxml.jackson.databind.ObjectMapper"%>

<%!
private class Dao{
	private Connection connection;
	private Statement statement;
	private LinkedHashMap<Long,Bean> beanMap=new LinkedHashMap<Long,Bean>();
	private final String url="jdbc:mysql://niracler.com:3307/uml_open_course_db?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
	private final String user="root";
	private final String password="dgutdev#uml";
	private long id;
	private String detail;
	private String date;
	private int num;
	private boolean connect(){
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	this.connection=DriverManager.getConnection(url,user,password);
	    	this.statement=connection.createStatement();
	    	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    return false;
	}
	private void close(){
		try {
			if(null!=this.connection) {
				this.connection.close();
			}
			if(null!=this.statement){
				this.statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int count(){
		this.num=0;
		if(connect()){
			try{
				if(null!=statement) {
					ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM history;");//基本ResultSet只能读一次，不能来回滚	
					while(rs.next()){
						this.num=rs.getInt("COUNT(*)");
						break;
					}
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return this.num;
	}
	
	public LinkedHashMap<Long,Bean> gets(int page){
		beanMap.clear();
		if(connect()){
			try{
				if(null!=statement) {
					ResultSet rs = statement.executeQuery("SELECT * FROM history LIMIT "+10*(page-1)+",10;");//基本ResultSet只能读一次，不能来回滚	
					while(rs.next()){
						id=rs.getLong("id");
						detail=rs.getString("detail");
						date=rs.getString("date");
						beanMap.put(id, new Bean(id,detail,date));
					}
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return beanMap;
	}
	public LinkedHashMap<Long,Bean> search(String key){
		beanMap.clear();
		if(connect()&&null!=key){
			try{
				if(null!=statement) {
					ResultSet rs = statement.executeQuery("SELECT * FROM history WHERE detail LIKE '%"+key+"%';");//基本ResultSet只能读一次，不能来回滚	
					while(rs.next()){
						id=rs.getLong("id");
						detail=rs.getString("detail");
						date=rs.getString("date");
						beanMap.put(id, new Bean(id,detail,date));
					}
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return beanMap;
	}
	public int searchCount(String key){
		this.num=0;
		if(connect()&&null!=key){
			try{
				if(null!=statement) {
					ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM history WHERE detail LIKE '%"+key+"%';");//基本ResultSet只能读一次，不能来回滚	
					while(rs.next()){
						this.num=rs.getInt("COUNT(*)");
						break;
					}
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return this.num;
	}
	public boolean insert(Bean bean){
		boolean flg=false;
		if(connect()&&null!=bean){
			try{
				detail=bean.getDetail();
				SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
				Timestamp currentTime = new Timestamp(System.currentTimeMillis());
				date=sdf.format(currentTime);
				statement.executeUpdate("INSERT INTO history(id,detail,date)VALUE(null,'"+detail+"','"+date+"' );");
				flg=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return flg;
	}
	public boolean setDetatil(long id,String detail){
		boolean flg=false;
		if(connect()&&null!=detail&&id>0){
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
				Timestamp currentTime = new Timestamp(System.currentTimeMillis());
				date=sdf.format(currentTime);
				statement.executeUpdate("UPDATE history SET detail='"+detail+"',date='"+date+"' WHERE id="+id+";");
				flg=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return flg;
	}
	public boolean delete(String ids){
		boolean flg=false;
		if(connect()&&id>0){
			try{
				statement.executeUpdate("delete from history where id in("+ids+");");
				flg=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return flg;
	} 
}

private class Bean{
	private long id;
	private String detail;
	private String date;
	public Bean(long id,String detail,String date){
		this.id=id;
		this.detail=detail;
		this.date=date;
	}
	public long getId(){
		return this.id;
	}
	public void setId(long id){
		this.id=id;
	}
	public String getDetail(){
		return detail;
	}
	public void setDetail(String detail){
		this.detail=detail;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date=date;
	}
}
%>
<%!
private ObjectMapper m_jackson=new ObjectMapper();
private String m_strRequestType;
private LinkedHashMap<Long,Bean> m_beanMap;
private Dao dao=new Dao();
private String jsonStr;
private String temp;
private int total=0;
private String strId="";
private long lId=0;
private int page2;
%>
<%
response.setCharacterEncoding("UTF-8");
request.setCharacterEncoding("UTF-8");
%>
<%
//1请求成功并返回结果，0请求失败/操作失败，-1获取用户信息失败，-2错误请求,-3用户不存在,-4密码错误,-5用户已停用,-6 email不存在,-7手机号不存在,-8此id的新闻不存在
m_strRequestType=request.getParameter("type");
if("get".equals(m_strRequestType)){
	page2=Integer.parseInt(request.getParameter("page"));
	total=dao.count();
	if(page2<1){
		response.getWriter().write("{\"resultCode\":\"upover\"}");
		return;
	}
	else if(page2>(0==total%10?total/10:total/10+1)){
		response.getWriter().write("{\"resultCode\":\"lastover\"}");
		return;
	}
	m_beanMap=dao.gets(page2);
	jsonStr = m_jackson.writeValueAsString(m_beanMap);//转换为json格式
	jsonStr="{\"resultCode\":\"1\",\"total\":"+total+",\"jsonData\":"+jsonStr+"}";
	response.getWriter().write(jsonStr);
	return;
}
else if("add".equals(m_strRequestType)){
	String content=request.getParameter("content");
	if(null!=content){
		Bean b=new Bean(0,content,"");
		if(dao.insert(b)){
			
			response.getWriter().write("{\"resultCode\":\"1\"}");
			return;
		}
	}
	response.getWriter().write("{\"resultCode\":\"-1\"}");
	return;
}
else if("edit".equals(m_strRequestType)){
	String content=request.getParameter("content");
	strId=request.getParameter("id");
	if(null!=content&&null!=strId){
		try{
		lId=Long.parseLong(strId);
		}catch (NumberFormatException e) {
	        response.getWriter().write("{\"resultCode\":\"-1\"}");
	    	return;
	    }
		if(dao.setDetatil(lId, content)){
			response.getWriter().write("{\"resultCode\":\"1\"}");
			return;
		}
	}
	response.getWriter().write("{\"resultCode\":\"-1\"}");
	return;
}
else if("del".equals(m_strRequestType)){
	strId=request.getParameter("id");
	if(null!=strId){
		if(dao.delete(strId)){
			response.getWriter().write("{\"resultCode\":\"1\"}");
			return;
		}
	}
	response.getWriter().write("{\"resultCode\":\"-1\"}");
	return;
}
else if("search".equals(m_strRequestType)){
	String key=request.getParameter("key");
	if(null!=key){
		m_beanMap=dao.search(key);
		total=dao.searchCount(key);
		jsonStr = m_jackson.writeValueAsString(m_beanMap);//转换为json格式
		jsonStr="{\"resultCode\":\"1\",\"total\":"+total+",\"jsonData\":"+jsonStr+"}";
		response.getWriter().write(jsonStr);
		return;
	}
	response.getWriter().write("{\"resultCode\":\"-1\"}");
	return;
}
else{
	response.getWriter().write("{\"resultCode\":\"-1\"}");
}
%>
