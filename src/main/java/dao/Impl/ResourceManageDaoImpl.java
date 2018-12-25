package dao.Impl;

import dao.IResourceManageDao;
import domian.ErrorMessageException;
import domian.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private ResultSet resultSet;

    @Override
    public List<Resource> findAllResource() {
        List<Resource> list = new ArrayList<>();
        Resource resource = new Resource();
        DataBaseConnectionImpl dataBaseConnection = new DataBaseConnectionImpl();
        connection = dataBaseConnection.getConnection();
        String sql = "select * from resource";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
}
