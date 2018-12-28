package service.Impl;

import dao.Impl.DataBaseConnectionImpl;
import dao.Impl.ResourceManageDaoImpl;
import domian.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.IResourceManageService;
import tools.PageInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wt
 * @Date: 2018/12/24 22:41
 */
public class ResourceManageServiceImpl implements IResourceManageService {
    Logger logger = LogManager.getLogger(ResourceManageServiceImpl.class);

    @Override
    public List<Resource> find() {
        ResourceManageDaoImpl resourceManageDao = new ResourceManageDaoImpl();
        return resourceManageDao.findAllResource();
    }

    @Override
    public List<Resource> findByType(String type) {
        ResourceManageDaoImpl resourceManageDao = new ResourceManageDaoImpl();
        return resourceManageDao.findResourceByType(type);
    }
  
    @Override
    public List<Resource> getOnePage(PageInformation pageInformation){
        DataBaseConnectionImpl databaseDao=new DataBaseConnectionImpl();
        ResourceManageDaoImpl resourceManageDao = new ResourceManageDaoImpl();
        List<Resource> resources = resourceManageDao.getOnePage(pageInformation, databaseDao);
        return resources;
    }


    @Override
    public boolean update(Resource resource) {
        ResourceManageDaoImpl resourceManageDao = new ResourceManageDaoImpl();
        return resourceManageDao.updateResource(resource);
    }

    @Override
    public boolean delete(Resource resource) {
        ResourceManageDaoImpl resourceManageDao = new ResourceManageDaoImpl();
        return resourceManageDao.deleteResource(resource);
    }

    @Override
    public boolean insert(Resource resource) {
        ResourceManageDaoImpl resourceManageDao = new ResourceManageDaoImpl();
        return resourceManageDao.insertResource(resource);
    }
}
