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
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("测试ResourceManageServiceImpl查询");
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        //logger.info("查询成功");
        Resource resource = new Resource();
        Date date = new Date();
        resource.setId(2);
        resource.setResTime(new Timestamp(date.getTime()));
        resource.setResPath("test2");
        resource.setResName("test");
        resource.setResType("test");
        resource.setResTag("test");
        resource.setIsCheck("test");
       // resourceManageService.insert(resource);
        logger.info(resource.toString());
        resourceManageService.update(resource);
        logger.info("end");
    }
}
