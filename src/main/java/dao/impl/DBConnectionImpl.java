package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IDBConnectionDao;

public class DBConnectionImpl implements IDBConnectionDao {

    //private static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=BaiduFace;integratedSecurity=true;characterEncoding=utf-8;";
    //private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:mysql://niracler.com:3307/uml_open_course_db?user=root&password=dgutdev#uml&useUnicode=true&characterEncoding=UTF8";
    private static String driverName = "com.mysql.jdbc.Driver";

    static {
        try {
            Class.forName(driverName);  //加载JDBC驱动程序
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(url); //创建数据库连接
            return con;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //关闭JDBC对象
    public static void free(Connection con , PreparedStatement ps , ResultSet rs) {
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
