package service.Impl;

import dao.Impl.ResourceManageDaoImpl;
import domain.Resource;
import org.apache.commons.fileupload.FileItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ResourceManageService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: team
 * @Date: 2018/12/24 22:41
 */
public class ResourceManageServiceImpl implements ResourceManageService {
    private ResourceManageDaoImpl resourceManageDao;

    private Logger logger = LogManager.getLogger(ResourceManageServiceImpl.class);

    public ResourceManageServiceImpl() {
        this.resourceManageDao = new ResourceManageDaoImpl();
    }

    @Override
    public List<Resource> findAll() {
        return resourceManageDao.selectAll();
    }

    @Override
    public List<Resource> findByType(String type) {
        return resourceManageDao.selectByType(type);
    }

    @Override
    public List<Resource> findByDate(Timestamp date1, Timestamp date2, String resType) {
        return resourceManageDao.selectByDate(date1, date2, resType);
    }

    @Override
    public List<Resource> findByPuzzyName(String name, String resType) {
        return resourceManageDao.selectByFuzzyName(name, resType);
    }



    @Override
    public boolean change(Resource resource) {
        return resourceManageDao.update(resource) > 0;
    }

    @Override
    public boolean changeCheck(Resource resource) {
        return resourceManageDao.updateCheck(resource) > 0;
    }

    @Override
    public boolean removeById(int id) {
        return resourceManageDao.deleteById(id) > 0;
    }

    @Override
    public boolean removeMultiple(List list) {
        int flag = 0;
        for (Object o : list) {
            if (removeById((int) o)) {
                flag++;
            }
        }
        return flag == list.size();
    }

    @Override
    public boolean create(Resource resource) {
        return resourceManageDao.insert(resource) > 0;
    }

    @Override
    public String saveFile(List<FileItem> formItems, String path, Resource resource) {
        String title = null;
        String name = null;
        String fileName = null;
        String type = null;
        String prefix = null;
        Path savePath = null;
        InputStream inputStream = null;

        try {
            // 解析请求的内容提取文件数据
            for (FileItem item : formItems) {
                if (item.isFormField()) {
                    name = item.getFieldName();
                    if ("title".equals(name)) {
                        title = item.getString("UTF-8");
                    } else {
                        type = item.getString("UTF-8");
                    }
                }
                if (!item.isFormField()) {
                    logger.info("文件上传！");
                    if (fileName == null) {
                        fileName = item.getName();
                    }
                    if (fileName.isEmpty()) {
                        continue;
                    }
                    logger.info("上传的文件名：" + fileName);
                    // 获取文件名后缀, 返回 "."在文件名最后出现的索引, 就是文件后缀名
                    prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    // 获取文件输入流
                    inputStream = item.getInputStream();
                }
            }
            if (title != null) {
                title += "." + prefix;
                fileName = title;
            }
            File file = new File((Paths.get(path, type)).toString());
            System.out.println((Paths.get(path, type)).toString());
            if (!file.exists()) {
                // 如果不存在则创建此路径的目录
                if (!file.mkdir()) {
                    logger.error("目录创建失败");
                    return null;
                }
            }
            //保存文件的相关信息
            savePath = Paths.get(path, type, fileName); // 组合路径
            resource.setResName(fileName);
            resource.setResType(type);
            resource.setResPath("/resource/" + type + "/" + fileName);
            //resource.setResPath("C:/Users/HuChuanfuOffice/Desktop/upload/" + type + "/" + fileName);
            // 创建文件输出流，用于向指定文件名的文件写入数据
            FileOutputStream fileOutputStream = new FileOutputStream(savePath.toString());
            int index = 0;

            // 从输入流读取数据的下一个字节，到末尾时返回 -1
            while ((index = inputStream.read()) != -1) {
                fileOutputStream.write(index); // 将指定字节写入此文件输出流
            }

            // 关闭流
            inputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public List<Resource> showResource(String type) {
        return resourceManageDao.showResource(type);
    }

    @Override
    public List<Resource> selectByName(String type, String name) {
        return resourceManageDao.selectByFuzzyName(name, type);
    }
}
