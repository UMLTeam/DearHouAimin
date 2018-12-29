package service.Impl;

import domian.Resource;
import org.junit.Before;
import org.junit.Test;
import sun.util.calendar.BaseCalendar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ResourceManageServiceImplTest {
    ResourceManageServiceImpl resourceManageService;
    @Before
    public void before() {
        resourceManageService = new ResourceManageServiceImpl();
    }
    
    @Test
    public void findAll() {
        System.out.println(resourceManageService.findAll());
    }
    
    @Test
    public void findByType() {
        System.out.println(resourceManageService.findByType("习题库"));
    }
    
    @Test
    public void findByDate() {
//        BaseCalendar.Date date1 = new BaseCalendar.Date("2018-12-26");
//
//        System.out.println(resourceManageService.findByDate());
    }
    
    @Test
    public void findByPuzzyName() {
        System.out.println(resourceManageService.findByPuzzyName("he","习题库"));
    }
    
    @Test
    public void getOnePage() {
    
    }
    
    @Test
    public void change() {
    
    }
    
    @Test
    public void changeCheck() {
        Resource resource = new Resource();
        resource.setIsCheck("0");
        resource.setId(1);
        System.out.println(resourceManageService.changeCheck(resource));
    }
    
    @Test
    public void removeById() {
        System.out.println(resourceManageService.removeById(1));
    }
    
    @Test
    public void removeMultiple() {
        List list = new ArrayList();
        list.add(4);
        list.add(3);
        System.out.println(resourceManageService.removeMultiple(list));
    }
    
    @Test
    public void create() {
        Resource resource = new Resource();
        resource.setId(2);
        resource.setResName("test");
        resource.setResType("案例库");
        resource.setResPath("/");
        resource.setIsCheck("1");
        System.out.println(resourceManageService.create(resource));
    }
}