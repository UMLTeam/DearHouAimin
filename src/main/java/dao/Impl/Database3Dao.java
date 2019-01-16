package dao.Impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Database3Dao {
	// 得到数据库连接
	DataBaseConnectionImpl dataBaseConnection = new DataBaseConnectionImpl();
	Connection connection = dataBaseConnection.getConnection();
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	public Database3Dao(){
		try {
			stmt=connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void query(String sql) throws SQLException {
		rs = stmt.executeQuery(sql);
	}

	public Integer update(String sql) throws SQLException {
		return stmt.executeUpdate(sql);
	}

	public boolean next() throws SQLException {// rs的下一条记录是否存在
		return rs.next();
	}

	public String getString(String field) throws SQLException {// 获取字符串类型字段的值，字段值为null型的，按照空字符串处理
		return rs.getString(field);
	}

	public Integer getInt(String field) throws SQLException {// 获取整数类型字段的值
		return rs.getInt(field);
	}

	public Timestamp getTimestamp(String field) throws SQLException {// 获取整数类型字段的值
		return rs.getTimestamp(field);
	}

	public LocalDateTime getLocalDateTime(String field) throws SQLException {// 获取日期时间类型字段的值
		return rs.getTimestamp(field).toLocalDateTime();
	}

	public Float getFloat(String field) throws SQLException {// 获取实数类型字段的值
		return rs.getFloat(field);
	}

	public int close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			return -10000;
		}
		return 10000;
	}

}
