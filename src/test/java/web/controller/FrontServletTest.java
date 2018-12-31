package web.controller;

import dao.Impl.ResourceManageDaoImpl;
import dao.ResourceManageDao;
import domian.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.Impl.ResourceManageServiceImpl;
import tools.PageInformation;
import tools.Tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.List;

/**
 * @Author: wt
 * @Date: 2018/12/31 0:25
 */
public class FrontServletTest {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(FrontServlet.class);
        ResourceManageServiceImpl resourceManageService = new ResourceManageServiceImpl();
        String operationType = "show";

        //前台展示资源
        if ("show".equals(operationType)) {
            PageInformation pageInformation = new PageInformation();
            pageInformation.setPage(1);
            pageInformation.setTableName("resource");
            pageInformation.setPageSize(10);
            pageInformation.setTotalPageCount(null);
            pageInformation.setAllRecordCount(null);
            pageInformation.setOrderField("");
            pageInformation.setOrder("id");
            pageInformation.setIds(null);
            pageInformation.setSearchSql(null);

            //获取某页的资源信息
            List<Resource> resourceList = resourceManageService.getOnePage(pageInformation);
            logger.info(resourceList.toString());
        }
    }
}
