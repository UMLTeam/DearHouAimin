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
        ResourceManageServiceImplTest test = new ResourceManageServiceImplTest();

        test.testFind();
        test.testInsert();
        test.testUpdate();
        test.testDelete();
    }

    Logger logger = LogManager.getLogger(ResourceManageServiceImpl.class);

    public void testFind() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("测试ResourceManageServiceImpl查询");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        List<Resource> resourceList = resourceManageService.find();
        for (Resource resource : resourceList) {
            logger.info(resource.toString());
        }
        logger.info("end\n");
    }

    public void testUpdate() {
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

    public void testDelete() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("测试ResourceManageServiceImpl删除");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        Resource resource = new Resource();
        resource.setId(3);
        logger.info(resource.toString());
        resourceManageService.delete(resource);
        logger.info("end\n");
    }

    public void testInsert() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("测试ResourceManageServiceImpl插入");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        //logger.info("查询成功");
        Resource resource = new Resource();
        Date date = new Date();
        resource.setId(6);
        resource.setResTime(new Timestamp(date.getTime()));
        resource.setResPath("test2");
        resource.setResName("test5");
        resource.setResType("test");
        resource.setIsCheck("test");
        logger.info(resource.toString());
        resourceManageService.insert(resource);
        logger.info("end\n");
    }
}
