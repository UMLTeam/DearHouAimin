package dao.Impl;

import dao.ResourceManageDao;
import domian.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.util.calendar.BaseCalendar;
import tools.PageInformation;
import tools.Tool;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2018/12/24 23:50
 */
public class ResourceManageDaoImpl implements ResourceManageDao {
    Logger logger = LogManager.getLogger(ResourceManageDaoImpl.class);
    private Connection connection=null;
    private PreparedStatement preparedStatement=null;
    private Statement stmt=null;
    private ResultSet resultSet=null;
    
    public static DataBaseConnectionImpl dataBaseConnection;

    public ResourceManageDaoImpl(){
        dataBaseConnection = new DataBaseConnectionImpl();
        connection = dataBaseConnection.getConnection();
    }
    
    @Override
    public List<Resource> selectAll(){
        List<Resource> resources = new ArrayList<Resource>();
        Resource resource;
        String sql = "select id, resName, resTime, resPath, resType, isCheck from resource";
        
        try{
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                resource = new Resource();
                resource.setId(resultSet.getInt("id"));
                resource.setResName(resultSet.getString("resName"));
                resource.setResTime(resultSet.getTimestamp("resTime"));
                resource.setResPath(resultSet.getString("resPath"));
                resource.setResType(resultSet.getString("resType"));
                resource.setIsCheck(resultSet.getString("isCheck"));
                resources.add(resource);
            }
            return resources;
        }catch(Exception e){
            logger.error(e.toString());
            return null;
        }finally {
            dataBaseConnection.free(connection,preparedStatement,resultSet);
        }
    }
    
    @Override
    public List<Resource> selectByType(String type) {
        List<Resource> resources = new ArrayList<Resource>();
        Resource resource;
        String sql = "select * from resource where resType like ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resource = new Resource();
                resource.setId(resultSet.getInt("id"));
                resource.setResName(resultSet.getString("resName"));
                resource.setResTime(resultSet.getTimestamp("resTime"));
                resource.setResPath(resultSet.getString("resPath"));
                resource.setResType(resultSet.getString("resType"));
                resource.setIsCheck(resultSet.getString("isCheck"));
                resources.add(resource);
            }
            return resources;
        } catch (Exception e) {
            logger.error(e.toString());
            return null;
        } finally {
            dataBaseConnection.free(connection, preparedStatement, resultSet);
        }
    }
    
    @Override
    public List<Resource> selectByDate(Timestamp date1, Timestamp date2,String resType) {
        List<Resource> resources = new ArrayList<Resource>();
        Resource resource;
        String sql = "select id,resName,resTime,resPath,resType,isCheck from resource where resType='"+resType+"' and resTime between date1 and date2";
        try{
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                resource = new Resource();
                resource.setId(resultSet.getInt("id"));
                resource.setResName(resultSet.getString("resName"));
                resource.setResTime(resultSet.getTimestamp("resTime"));
                resource.setResPath(resultSet.getString("resPath"));
                resource.setResType(resultSet.getString("resType"));
                resource.setIsCheck(resultSet.getString("isCheck"));
                resources.add(resource);
            }
            return resources;
        }catch(Exception e){
            logger.error(e.toString());
            return null;
        }finally {
            dataBaseConnection.free(connection, preparedStatement, resultSet);
        }
    }
    
    @Override
    public List<Resource> selectByFuzzyName(String name,String resType) {
        List<Resource> resources = new ArrayList<Resource>();
        Resource resource;
        String sql = "select * from resource where resType='"+resType+"' and resName like '%"+name+"%'";
        try{
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                resource = new Resource();
                resource.setId(resultSet.getInt("id"));
                resource.setResName(resultSet.getString("resName"));
                resource.setResTime(resultSet.getTimestamp("resTime"));
                resource.setResPath(resultSet.getString("resPath"));
                resource.setResType(resultSet.getString("resType"));
                resource.setIsCheck(resultSet.getString("isCheck"));
                resources.add(resource);
            }
            return resources;
        }catch(Exception e){
            logger.error(e.toString());
            return null;
        }finally {
            dataBaseConnection.free(connection, preparedStatement, resultSet);
        }
    }
    
    @Override
    public int update(Resource resource) {
        String sql = "update resource set resName = ?, resPath = ?, resType = ?, isCheck = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, resource.getResName());
            preparedStatement.setString(2, resource.getResPath());
            preparedStatement.setString(3, resource.getResType());
            preparedStatement.setString(4, resource.getIsCheck());
            preparedStatement.setInt(5, resource.getId());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.error(e.toString());
            return 0;
        } finally {
            dataBaseConnection.free(connection, preparedStatement, null);
        }
    }
    
    @Override
    public int updateCheck(Resource resource) {
        String sql = "update resource set isCheck = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, resource.getIsCheck());
            preparedStatement.setInt(2, resource.getId());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.error(e.toString());
            return 0;
        } finally {
            dataBaseConnection.free(connection, preparedStatement, null);
        }
    }
    
    @Override
    public int insert(Resource resource) {
        String sql = "INSERT INTO resource VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, resource.getId());
            preparedStatement.setString(2, resource.getResName());
            preparedStatement.setTimestamp(3, resource.getResTime());
            preparedStatement.setString(4, resource.getResPath());
            preparedStatement.setString(5, resource.getResType());
            preparedStatement.setString(6, resource.getIsCheck());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.error(e.toString());
            return 0;
        } finally {
            dataBaseConnection.free(connection, preparedStatement, null);
        }
    }

    @Override
    public int deleteById(int id){
        String sql = "delete from resource where id = '"+id+"'";
        try {
            stmt = connection.createStatement();
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            logger.error(e.toString());
            return 0;
        } finally {
            dataBaseConnection.free(connection, preparedStatement, null);
        }
    }
    
    @Override
    public int getCount(String sql){
        try {
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                return resultSet.getInt("count1");
            }
        } catch (Exception e) {
            logger.error(e.toString());
            return 0;
        } finally {
            dataBaseConnection.free(connection, preparedStatement, null);
        }
        return 0;
    }

    @Override
    public List<Resource> getOnePage(PageInformation pageInformation)  {
        List<Resource> resources=new ArrayList<Resource>();
        String sqlCount= Tool.getSql(pageInformation,"count");
        Integer allRecordCount=this.getCount(sqlCount);//符合条件的总记录数
        Tool.setPageInformation(allRecordCount, pageInformation);//更新pageInformation的总页数等
        String sqlSelect=Tool.getSql(pageInformation,"select");
        
        try {
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sqlSelect);
            while (resultSet.next()) {
                Resource resource=new Resource();
                resource.setId(resultSet.getInt("id"));
                resource.setResName(resultSet.getString("resName"));
                resource.setResTime(resultSet.getTimestamp("resTime"));
                resource.setResPath(resultSet.getString("resPath"));
                resource.setResType(resultSet.getString("resType"));
                resource.setIsCheck(resultSet.getString("isCheck"));
                resources.add(resource);
            }
            return resources;
        } catch (Exception e) {
            logger.error(e.toString());
            return null;
        } finally {
            dataBaseConnection.free(connection, preparedStatement, resultSet);
        }
    }
}
