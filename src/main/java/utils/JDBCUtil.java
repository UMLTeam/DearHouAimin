package utils;

import java.sql.*;

public class JDBCUtil {
    static Connection conn = null;
    static String driver = "com.mysql.jdbc.Driver";
    //    static String ip = "jdbc:mysql://cdb-0f80y4kv.gz.tencentcdb.com:10075/UML_open_course_db";
    public static String ip ="jdbc:mysql://niracler.com:3307/uml_open_course_db?characterEncoding=UTF-8&autoReconnect=true";
    public static String userName = "root";//用户名
    //	public static String password = "hbd17817781227";//密码
    public static String password = "dgutdev#uml";//密码

    public JDBCUtil() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 连接数据库方法,返回Connection对象
     */
    public static Connection getConnection() {
        System.out.println("driver:" + driver);
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(ip, userName, password);
            System.out.println("连接成功!");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库方法，无返回值
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("关闭成功!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}