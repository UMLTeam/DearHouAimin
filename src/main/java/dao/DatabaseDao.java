package dao;

import java.sql.*;

/**
 * @authoor linzerong
 * @create 2018-12-22 21:04
 */
public class DatabaseDao {
    private static String DRV = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://niracler.com:3307/uml_open_course_db?characterEncoding=utf-8";
    private static String USR = "root";
    private static String PWD = "dgutdev#uml";
    private Connection connect;
    private Statement stmt;
    private ResultSet rs;

    public DatabaseDao() throws ClassNotFoundException, SQLException {
        Class.forName(DRV);
        connect = DriverManager.getConnection(URL,USR,PWD);
        stmt = connect.createStatement();
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

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

    public void query(String sql) throws SQLException {
        rs = stmt.executeQuery(sql);
    }
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
        connect.close();
    }
}
