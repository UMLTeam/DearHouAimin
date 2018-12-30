package dao;

import domian.Resource;
import tools.PageInformation;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: team
 * @Date: 2018/12/24 23:48
 */
public interface ResourceManageDao {
    /**
     * 从数据库中查找所有资源的信息
     * @return List<Resource>
     */
    List<Resource> selectAll();
    
    /**
     * 通过Type值进行查询
     * @param type
     * @return List<Resource>
     */
    List<Resource> selectByType(String type);
    
    /**
     * 通过时间范围查询  在某个栏目下的
     * @param date1
     * @param date2
     * @return
     * @throws SQLException
     */
    List<Resource> selectByDate(Timestamp date1, Timestamp date2, String resType);
    
    /**
     * 按文件名模糊搜索 在某个栏目下
     * @param name
     * @return
     */
    List<Resource> selectByFuzzyName(String name,String resType);
    /**
     * 更新数据库的资源信息
     * @param resource
     * @return boolean
     */
    int update(Resource resource);
    
    /**
     * 更新isCheck状态
     * @param resource
     */
    int updateCheck(Resource resource);

    /**
     * 插入资源信息到数据库中
     * @param resource
     * @return
     */
    int insert(Resource resource);

    /**
     * 删除资源
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 查询符合条件的记录的数目
     * @return
     */
    int getCount(String sql);

    /**
     * 从数据库中查找所有资源的信息
     * @return List<Resource>
     */
    List<Resource> getOnePage(PageInformation pageInformation);
}
