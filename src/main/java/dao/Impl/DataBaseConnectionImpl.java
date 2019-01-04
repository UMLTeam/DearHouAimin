package dao.Impl;

import java.sql.*;

import dao.DataBaseConnectionDao;
/**
 * Demo class
 *
 * @Author wt
 * @date 2018/12/24
 */
public class DataBaseConnectionImpl implements DataBaseConnectionDao {

    private final static String URL = "jdbc:mysql://niracler.com:3307/uml_open_course_db?useUnicode=true&characterEncoding=UTF8";
    private final static String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
    private final static String USER = "root";
    private final static String PASSWORD = "dgutdev#uml";
    private Connection connection=null;
    
    public DataBaseConnectionImpl(){
        try {
            Class.forName(DRIVERNAME);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
   
    @Override
    public Connection getConnection() {
        return this.connection;
    }

	/**
	 * 关闭JDBC对象
	 */
	@Override
	public void free(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
