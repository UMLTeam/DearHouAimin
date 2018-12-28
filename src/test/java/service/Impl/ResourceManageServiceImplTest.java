package service.Impl;

import org.junit.Test;

import static org.junit.Assert.*;

import domian.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.Impl.ResourceManageServiceImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * @Author: wt
 * @Date: 2018/12/24 23:10
 */
public class ResourceManageServiceImplTest {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(ResourceManageServiceImplTest.class);
        ResourceManageServiceImplTest test = new ResourceManageServiceImplTest();

        test.testFind();
        //test.testInsert();
//        test.testUpdate();
//        test.testDelete();
//        test.testFindByType();
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        List<Resource> list = resourceManageService.findByType("4");
        logger.info(list.toString());
    }

    private void testFindByType() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("测试ResourceManageServiceImpl根据类型查询");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        List<Resource> resourceList = resourceManageService.findByType("习题库");
        for (Resource resource : resourceList) {
            logger.info(resource.toString());
        }
        logger.info("end\n");
    }

    private void testFind() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("测试ResourceManageServiceImpl查询");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        List<Resource> resourceList = resourceManageService.find();
        for (Resource resource : resourceList) {
            logger.info(resource.toString());
        }
        logger.info("end\n");
    }

    private void testUpdate() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("测试ResourceManageServiceImpl更新");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        Resource resource = new Resource();
        Date date = new Date();
        resource.setId(1);
        resource.setResTime(new Timestamp(date.getTime()));
        resource.setResPath("test2");
        resource.setResName("测试更新");
        resource.setResType("test");
        resource.setIsCheck("test");
        logger.info(resource.toString());
        resourceManageService.update(resource);
        logger.info("end\n");
    }

    private void testDelete() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("测试ResourceManageServiceImpl删除");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        Resource resource = new Resource();
        resource.setId(3);
        logger.info(resource.toString());
        resourceManageService.delete(resource);
        logger.info("end\n");
    }

    private void testInsert() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("测试ResourceManageServiceImpl插入");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        Resource resource = new Resource();
        Date date = new Date();
        resource.setId(9);
        resource.setResTime(new Timestamp(date.getTime()));
        resource.setResPath("/resource/《软件需求分析与设计》综合实践.pdf");
        resource.setResName("《软件需求分析与设计》综合实践.pdf");
        resource.setResType("习题库");
        resource.setIsCheck("1");
        logger.info(resource.toString());
        resourceManageService.insert(resource);
        logger.info("end\n");
    }
}
