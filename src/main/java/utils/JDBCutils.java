package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCutils {
    //数据库用户名
    private static final String USERNAME = "root";


    private static final String PASSWORD = "dgutdev#uml";


    //驱动信息
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //数据库地址
    private static final String URL = "jdbc:mysql://niracler.com:3307/uml_open_course_db?useUnicode=true&characterEncoding=utf8&autoReconnect=true";

    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    public JDBCutils() {
        // TODO Auto-generated constructor stub
        try{
            Class.forName(DRIVER);
        }catch(Exception e){

        }
    }
    public Connection getConnection(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public boolean updateByPreparedStatement(String sql, List<Object> params)throws SQLException{
        boolean flag = false;
        int result = -1;
        connection=this.getConnection();
        pstmt = connection.prepareStatement(sql);
        int index = 1;
        if(params != null && !params.isEmpty()){
            for(int i=0; i<params.size(); i++){
                pstmt.setObject(index++, params.get(i));
            }
        }
        result = pstmt.executeUpdate();
        flag = result > 0 ? true : false;
        pstmt.close();
        connection.close();
        return flag;
    }
    public Map<String, Object> findSimpleResult(String sql, List<Object> params) throws SQLException{
        Map<String, Object> map = new HashMap<String, Object>();
        int index  = 1;
        connection=this.getConnection();
        pstmt = connection.prepareStatement(sql);
        if(params != null && !params.isEmpty()){
            for(int i=0; i<params.size(); i++){
                pstmt.setObject(index++, params.get(i));
            }
        }
        resultSet = pstmt.executeQuery();//返回查询结果
        ResultSetMetaData metaData = resultSet.getMetaData();
        int col_len = metaData.getColumnCount();
        while(resultSet.next()){
            for(int i=0; i<col_len; i++ ){
                String cols_name = metaData.getColumnName(i+1);
                Object cols_value = resultSet.getObject(cols_name);
                if(cols_value == null){
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
        }
        pstmt.close();
        connection.close();
        return map;
    }
    public List<Map<String, Object>> findModeResult(String sql, List<Object> params) throws SQLException{
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int index = 1;
        connection=this.getConnection();
        pstmt = connection.prepareStatement(sql);
        if(params != null && !params.isEmpty()){
            for(int i = 0; i<params.size(); i++){
                pstmt.setObject(index++, params.get(i));
            }
        }
        resultSet = pstmt.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int cols_len = metaData.getColumnCount();
        while(resultSet.next()){
            Map<String, Object> map = new HashMap<String, Object>();
            for(int i=0; i<cols_len; i++){
                String cols_name = metaData.getColumnName(i+1);
                Object cols_value = resultSet.getObject(cols_name);
                if(cols_value == null){
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);
        }
        pstmt.close();
        connection.close();
        return list;
    }
    public void releaseConn(){
        if(resultSet != null){
            try{
                resultSet.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
