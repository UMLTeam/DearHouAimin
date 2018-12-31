package service.Impl;

import dao.Impl.ResourceManageDaoImpl;
import domian.Resource;
import service.ResourceManageService;
import tools.PageInformation;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: team
 * @Date: 2018/12/24 22:41
 */
public class ResourceManageServiceImpl implements ResourceManageService {
    private ResourceManageDaoImpl resourceManageDao;
    
    public ResourceManageServiceImpl(){
        this.resourceManageDao = new ResourceManageDaoImpl();
    }

    @Override
    public List<Resource> findAll()  {
        return resourceManageDao.selectAll();
    }

    @Override
    public List<Resource> findByType(String type) {
        return resourceManageDao.selectByType(type);
    }
    
    @Override
    public List<Resource> findByDate(Timestamp date1, Timestamp date2, String resType) {
        return resourceManageDao.selectByDate(date1,date2,resType);
    }
    
    @Override
    public List<Resource> findByPuzzyName(String name,String resType) {
        return resourceManageDao.selectByFuzzyName(name,resType);
    }
    
    @Override
    public List<Resource> getOnePage(PageInformation pageInformation) {
        List<Resource> resources;
        resources = resourceManageDao.getOnePage(pageInformation);
        return resources;
    }
    
    @Override
    public boolean change(Resource resource) {
        return resourceManageDao.update(resource) > 0;
    }
    
    @Override
    public boolean changeCheck(Resource resource){
        return resourceManageDao.updateCheck(resource) > 0;
    }
    
    @Override
    public boolean removeById(int id) {
        return resourceManageDao.deleteById(id) > 0;
    }
    
    @Override
    public boolean removeMultiple(List list) {
        int flag=0;
        for (Object o : list) {
            if (removeById((int) o)){
                flag++;
            }
        }
        return flag == list.size();
    }

    @Override
    public boolean create(Resource resource) {
        return resourceManageDao.insert(resource) > 0;
    }
}
