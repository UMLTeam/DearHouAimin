package service;

import domian.Resource;

import java.util.List;

/**
 * @Author: wt
 * @Date: 2018/12/24 22:41
 */
public interface IResourceManageService {
    /**
     * 查找所有的资源信息
     * @return List<Resource>
     */
    List<Resource> find();

    /**
     * 删除资源信息
     * @return
     */
    boolean delete(Resource resource);

    /**
     * 添加资源信息
     * @param resource
     * @return
     */
    boolean insert(Resource resource);

    /**
     * 更新资源信息
     * @param resource
     * @return
     */
    boolean update(Resource resource);
}
