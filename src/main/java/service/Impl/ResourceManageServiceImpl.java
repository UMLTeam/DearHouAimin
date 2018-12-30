package service.Impl;

import dao.Impl.DataBaseConnectionImpl;
import dao.Impl.ResourceManageDaoImpl;
import domian.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ResourceManageService;
import sun.util.calendar.BaseCalendar;
import tools.PageInformation;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wt
 * @Date: 2018/12/24 22:41
 */
public class ResourceManageServiceImpl implements ResourceManageService {
    ResourceManageDaoImpl resourceManageDao = null;
    
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
        List<Resource> resources = new ArrayList<Resource>();
        resources = resourceManageDao.getOnePage(pageInformation);
        return resources;
    }
    
    @Override
    public boolean change(Resource resource) {
        if(resourceManageDao.update(resource)>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public boolean changeCheck(Resource resource){
        if(resourceManageDao.updateCheck(resource)>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public boolean removeById(int id) {
        if(resourceManageDao.deleteById(id)>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public boolean removeMultiple(List list) {
        int flag=0;
        for(int i=0; i<list.size(); i++){
            if(removeById((int)list.get(i)))
                flag++;
        }
        if(flag==list.size()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean create(Resource resource) {
        if(resourceManageDao.insert(resource)>0){
            return true;
        }
        else{
            return false;
        }
    }
}
