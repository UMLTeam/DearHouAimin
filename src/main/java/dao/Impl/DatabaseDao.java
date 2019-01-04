package dao.Impl;

import java.sql.*;
import java.time.LocalDateTime;

public class DatabaseDao {
	public static String drv = "com.mysql.jdbc.Driver";//数据库类型
	//	public static String url ="jdbc:mysql://cdb-0f80y4kv.gz.tencentcdb.com:10075/UML_open_course_db?characterEncoding=UTF-8";
	public static String url ="jdbc:mysql://niracler.com:3307/uml_open_course_db?characterEncoding=UTF-8";
	public static String user = "root";//用户名
	//	public static String pwd = "hbd17817781227";//密码
	public static String pwd = "dgutdev#uml";//密码

	private Connection connection=null;
	private Statement statement=null;
	private ResultSet resultSet=null;
	private Statement stmt = null;
	private ResultSet rs = null;


	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	//statement不能通过get、set方法去获取使用，应通过构造方法去建立对象来连接数据库


	//构造函数，连接到数据库
	public DatabaseDao() throws Exception{
		Class.forName(drv);
		connection=DriverManager.getConnection(url,user,pwd);
		statement=connection.createStatement();
		System.out.println("数据库连接成功！");
	}

	//执行查询
	public void query(String sql)throws SQLException{
		resultSet=statement.executeQuery(sql);
	}

	public boolean insert(String sql)throws SQLException{
		return statement.execute(sql);
	}

	//判断resultSet的下一条记录是否存在
	public boolean next() throws SQLException{
		return resultSet.next();
	}

	//获取字符串类型字段的值
	public String getString(String field)throws SQLException{
		return resultSet.getString(field);
	}

	//获取整数类型字段的值
	public Integer getInteger(String field)throws SQLException{
		return resultSet.getInt(field);
	}

	//获取实数类型字段的值
	public Double getDouble(String field)throws SQLException{
		return resultSet.getDouble(field);
	}

	//查询是否存在此id的记录
	public boolean hasId(String tableName,Integer id)throws SQLException{
		tableName=tableName.toLowerCase();
		String sql="select * from "+tableName+"where" +tableName+"Id="+id.toString();
		query(sql);
		while(next()) {
			return true;
		}
		return false;
	}

	public Timestamp getTimestamp(String field) throws SQLException{//获取整数类型字段的值
		return resultSet.getTimestamp(field);
	}

	public LocalDateTime getLocalDateTime(String field) throws SQLException{//获取日期时间类型字段的值
		return resultSet.getTimestamp(field).toLocalDateTime();
	}

	//查询某个id的一行数据
	public void getById(String tableName,Integer id)throws SQLException{
		tableName=tableName.toLowerCase();
		String sql="select * from"+tableName+"where "+ tableName+"Id="+id.toString();
		query(sql);
	}

	/**
	 * @authoor linzerong
	 * @create 2018-12-22 21:04
	 */
	/*public class DatabaseDao {
		private static String DRV = "com.mysql.jdbc.Driver";
		private static String URL = "jdbc:mysql://118.89.151.135:3306/uml_open_course_db?characterEncoding=utf-8";
		private static String USR = "root";
		private static String PWD = "aa2527062";
		private Connection connect;
		private Statement stmt;
		private ResultSet rs;

		public DatabaseDao() throws ClassNotFoundException, SQLException {
			Class.forName(DRV);
			connect = DriverManager.getConnection(URL,USR,PWD);
			stmt = connect.createStatement();
		}*/

		/*public Connection getConnect() {
			return connect;
		}

		public void setConnect(Connection connect) {
			this.connect = connect;
		}*/

		public Statement getStmt() {
			return stmt;
		}

		public void setStmt(Statement stmt) {
			this.stmt = stmt;
		}

		public ResultSet getRs() {
			return rs;
		}

		public void setRs(ResultSet rs) {
			this.rs = rs;
		}

		/*public void query(String sql) throws SQLException {
			rs = stmt.executeQuery(sql);
		}*/
		public boolean delete(String sql) throws SQLException {
			return stmt.execute(sql);
		}

		public int update(String sql) throws SQLException {
			return stmt.executeUpdate(sql);
		}

		public void close() throws SQLException {
			if(rs != null){
				rs.close();
			}
			stmt.close();
			statement.close();
			resultSet.close();
			rs.close();
			connection.close();
		}
	}
