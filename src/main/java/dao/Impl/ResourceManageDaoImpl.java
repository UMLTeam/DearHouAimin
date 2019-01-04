package dao.Impl;

import dao.ResourceManageDao;
import domain.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: team
 * @Date: 2018/12/24 23:50
 */
public class ResourceManageDaoImpl implements ResourceManageDao {
	Logger logger = LogManager.getLogger(ResourceManageDaoImpl.class);
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private static DataBaseConnectionImpl dataBaseConnection;

	public ResourceManageDaoImpl() {
		dataBaseConnection = new DataBaseConnectionImpl();
		connection = dataBaseConnection.getConnection();
	}

	@Override
	protected void finalize() {
		dataBaseConnection.free(connection, preparedStatement, resultSet);
	}

	@Override
	public List<Resource> selectAll() {
		List<Resource> resources = new ArrayList<Resource>();
		Resource resource;
		String sql = "select id, resName, resTime, resPath, resType, isCheck from resource";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
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
			dataBaseConnection.free(null, preparedStatement, resultSet);
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
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	@Override
	public List<Resource> selectByDate(Timestamp date1, Timestamp date2, String resType) {
		List<Resource> resources = new ArrayList<Resource>();
		Resource resource;
		String sql = "select id,resName,resTime,resPath,resType,isCheck from resource where resType='" + resType
				+ "' and resTime between date1 and date2";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
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
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}

	@Override
	public List<Resource> selectByFuzzyName(String name, String resType) {
		List<Resource> resources = new ArrayList<>();
		Resource resource;
		String sql = "select * from resource where resType='" + resType + "' and resName like '%" + name + "%'";
		try {
			preparedStatement = connection.prepareStatement(sql);
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
			dataBaseConnection.free(null, preparedStatement, resultSet);
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
			dataBaseConnection.free(null, preparedStatement, null);
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
			dataBaseConnection.free(null, preparedStatement, null);
		}
	}

	@Override
	public int insert(Resource resource) {
		String sql = "INSERT INTO resource(resName, resPath, resType, isCheck) VALUES(?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, resource.getResName());
			preparedStatement.setString(2, resource.getResPath());
			preparedStatement.setString(3, resource.getResType());
			preparedStatement.setString(4, resource.getIsCheck());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		} finally {
			dataBaseConnection.free(null, preparedStatement, null);
		}
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from resource where id = '" + id + "'";
		try {
			preparedStatement = connection.prepareStatement(sql);
			return preparedStatement.executeUpdate(sql);
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		} finally {
			dataBaseConnection.free(null, preparedStatement, null);
		}
	}

	@Override
	public int getCount(String sql) {
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				return resultSet.getInt("count1");
			}
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		} finally {
			dataBaseConnection.free(null, preparedStatement, null);
		}
		return 0;
	}

	@Override
	public List<Resource> showResource(String type) {
		List<Resource> resources = new ArrayList<>();
		Resource resource;
		String sql = "select * from resource where resType like ? and isCheck like ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, type);
			preparedStatement.setString(2, "1");
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
			dataBaseConnection.free(null, preparedStatement, resultSet);
		}
	}
}
