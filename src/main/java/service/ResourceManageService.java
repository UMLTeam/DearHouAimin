package service;

import domian.Resource;
import org.apache.commons.fileupload.FileItem;
import tools.PageInformation;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: wt
 * @Date: 2018/12/24 22:41
 */
public interface ResourceManageService {
    /**
     * 查询所有的资源
     * @return List<Resource>
     */
    List<Resource> findAll() throws SQLException;

    /**
     * 根据资源类型来查询
     */
    List<Resource> findByType(String type);
    
    /**
     * 根据时间范围来查询
     * @param date1
     * @param date2
     * @param resType
     * @return List<Resource>
     */
    List<Resource> findByDate(Timestamp date1, Timestamp date2, String resType) throws SQLException;
    
    /**
     * 根据文件名模糊查询
     */
    List<Resource> findByPuzzyName(String name,String resType);

    /**
     * 得到一页资源信息
     *  @return List<Resource>
     */
    List<Resource> getOnePage(PageInformation pageInformation);

    /**
     * 删除资源信息
     * @return
     */
    boolean removeById(int id);
    
    /**
     * 批量删除
     * @param list
     * @return
     */
    boolean removeMultiple(List list);
    
    /**
     * 添加资源信息
     * @param resource
     * @return
     */
    boolean create(Resource resource);

    /**
     * 更新资源信息
     * @param resource
     * @return
     */
    boolean change(Resource resource);

    /**
     *
     * @param resource
     * @return
     */
    boolean changeCheck(Resource resource);

    /**
     *
     * @param formItems
     * @param path 项目路径
     * @param resource
     * @return 文件保存路径
     */
    String saveFile(List<FileItem> formItems, String path, Resource resource);

    /**
     * 前台展示资源查询
     * @param type
     * @return
     */
    List<Resource> showResource(String type);
}
