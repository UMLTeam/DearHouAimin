package dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IDataBaseConnectionDao;
/**
 * Demo class
 *
 * @author wt
 * @date 2018/12/24
 */
public class DataBaseConnectionImpl implements IDataBaseConnectionDao {

    private final static String URL = "jdbc:mysql://niracler.com:3307/uml_open_course_db?useUnicode=true&characterEncoding=UTF8";
    private final static String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
    private final static String USER = "root";
    private final static String PASSWORD = "dgutdev#uml";

    static {
        try {
            //加载JDBC驱动程序
            Class.forName(DRIVERNAME);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Connection getConnection() {
        try {
            //创建数据库连接
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *     关闭JDBC对象
     */
    @Override
    public void free(Connection con , PreparedStatement ps , ResultSet rs) {
        try {
            if(con != null) {
                con.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(rs != null) {
                        rs.close();
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
