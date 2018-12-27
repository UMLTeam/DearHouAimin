package dao.Impl;

import dao.IResourceManageDao;
import domian.ErrorMessageException;
import domian.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tools.PageInformation;
import tools.Tool;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wt
 * @Date: 2018/12/24 23:50
 */
public class ResourceManageDaoImpl implements IResourceManageDao {
    Logger logger = LogManager.getLogger(ResourceManageDaoImpl.class);
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement stmt;
    private ResultSet resultSet;

    @Override
    public List<Resource> findAllResource() {
        return findResourceByType("%%");
    }

    @Override
    public boolean updateResource(Resource resource) {
        DataBaseConnectionImpl dataBaseConnection = new DataBaseConnectionImpl();
        connection = dataBaseConnection.getConnection();
        String sql = "update resource set id = ?, resName = ?, resTime = ?, resPath = ?, resType = ?, isCheck = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, resource.getId());
            preparedStatement.setString(2, resource.getResName());
            preparedStatement.setTimestamp(3, resource.getResTime());
            preparedStatement.setString(4, resource.getResPath());
            preparedStatement.setString(5, resource.getResType());
            //preparedStatement.setString(6, resource.getResTag());
            preparedStatement.setString(6, resource.getIsCheck());
            preparedStatement.setInt(7, resource.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            return false;
        } finally {
            dataBaseConnection.free(connection, preparedStatement, null);
        }
    }

    @Override
    public boolean insertResource(Resource resource) {
        DataBaseConnectionImpl dataBaseConnection = new DataBaseConnectionImpl();
        connection = dataBaseConnection.getConnection();
        String sql = "INSERT INTO resource VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, resource.getId());
            preparedStatement.setString(2, resource.getResName());
            preparedStatement.setTimestamp(3, resource.getResTime());
            preparedStatement.setString(4, resource.getResPath());
            preparedStatement.setString(5, resource.getResType());
//            preparedStatement.setString(6, resource.getResTag());
            preparedStatement.setString(6, resource.getIsCheck());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            return false;
        } finally {
            dataBaseConnection.free(connection, preparedStatement, null);
        }
    }

    @Override
    public boolean deleteResource(Resource resource){
        DataBaseConnectionImpl dataBaseConnection = new DataBaseConnectionImpl();
        connection = dataBaseConnection.getConnection();
        String sql = "delete from resource where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, resource.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            return false;
        } finally {
            dataBaseConnection.free(connection, preparedStatement, null);
        }
    }

    //得到符合条件的资源总数
    @Override
    public int getCount(String sql){
        DataBaseConnectionImpl dataBaseConnection = new DataBaseConnectionImpl();
        connection = dataBaseConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt("count1");
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
    public List<Resource> getOnePage(PageInformation pageInformation, DataBaseConnectionImpl databaseDao)  {
        List<Resource> resources=new ArrayList<Resource>();
        String sqlCount= Tool.getSql(pageInformation,"count");
        Integer allRecordCount=this.getCount(sqlCount);//符合条件的总记录数
        Tool.setPageInformation(allRecordCount, pageInformation);//更新pageInformation的总页数等

        String sqlSelect=Tool.getSql(pageInformation,"select");

        try {
            connection = databaseDao.getConnection();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sqlSelect);
            while (resultSet.next()) {
                Resource resource=new Resource();
                resource.setId(resultSet.getInt("id"));
                resource.setResName(resultSet.getString("resName"));
                resource.setResTime(resultSet.getTimestamp("resTime"));
                resource.setResPath(resultSet.getString("resPath"));
                resource.setResType(resultSet.getString("resType"));
//                resource.setResTag(resultSet.getString("resTag"));
                resource.setIsCheck(resultSet.getString("isCheck"));
                resources.add(resource);
            }
            return resources;
        } catch (Exception e) {
            logger.error(e.toString());
        } finally {
            databaseDao.free(connection, preparedStatement, resultSet);
        }
        return null;

    }

    @Override
    public List<Resource> findResourceByType(String type) {
        List<Resource> list = new ArrayList<>();
        Resource resource;
        DataBaseConnectionImpl dataBaseConnection = new DataBaseConnectionImpl();
        connection = dataBaseConnection.getConnection();
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
//                resource.setResTag(resultSet.getString("resTag"));
                resource.setIsCheck(resultSet.getString("isCheck"));
                list.add(resource);
            }
            return list;
        } catch (Exception e) {
            logger.error(e.toString());
        } finally {
            dataBaseConnection.free(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
