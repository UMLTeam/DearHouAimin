package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IDataBaseConnectionDao {

    /**
     * 创建数据库的连接
     */
    Connection getConnection();

    /**
     * 释放数据库资源
     *
     * @param con
     * @param ps
     * @param rs
     */
    void free(Connection con, PreparedStatement ps, ResultSet rs);
}
