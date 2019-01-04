package service.Impl;

import dao.Impl.QQGroupDaoImpl;
import dao.QQGroupDao;
import domain.QQGroup;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import tools.FileTool;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQGroupService {

    public QQGroup getQQGroupByName(String name) throws SQLException, ClassNotFoundException {
        QQGroupDao qqGroupDaoImpl = new QQGroupDaoImpl();
        return  qqGroupDaoImpl.getGroupByGroupName(name);
    }

    public ArrayList<QQGroup> getQQGroups() throws SQLException, ClassNotFoundException {
        QQGroupDao qqGroupDaoImpl = new QQGroupDaoImpl();
        return qqGroupDaoImpl.getQQGroups();
    }

    public QQGroup getQQGroupByGroupid(String id) throws SQLException, ClassNotFoundException {
        QQGroupDao qqGroupDaoImpl = new QQGroupDaoImpl();
        return qqGroupDaoImpl.getGroupByGroupId(id);
    }
    public QQGroup getQQGroupByUse() throws SQLException, ClassNotFoundException {
        QQGroupDao qqGroupDaoImpl = new QQGroupDaoImpl();
        return qqGroupDaoImpl.getQQGroupByUse();
    }
    public int addQQGroup(QQGroup qqGroup, HttpServletRequest request) throws Exception {
        QQGroupDao qqGroupDaoImpl = new QQGroupDaoImpl();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        String path = request.getServletContext().getRealPath("\\temp");        //获取临时文件夹
        File repository = new File(path);
        factory.setRepository(repository);

        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> fileItems = upload.parseRequest(request);
        Iterator<FileItem> itemIterator =   fileItems.iterator();
        /*
        for(FileItem item : fileItems){
        if(item.isformField){}
        }
        * */
        while (itemIterator.hasNext()){
            FileItem item = itemIterator.next();
            if (item.isFormField()) {//非上传文件表单元素
                if("groupid".equals(item.getFieldName()))//获取表单元素的name属性
                    qqGroup.setGroupid(item.getString("UTF-8"));//获取表单元素的值（一般是value属性）
                if("groupName".equals(item.getFieldName()))//获取表单元素的name属性
                    qqGroup.setGroupName(item.getString("UTF-8"));//获取表单元素的值（一般是value属性）
                if("idkey".equals(item.getFieldName()))//获取表单元素的name属性
                    qqGroup.setIdkey(item.getString("UTF-8"));//获取表单元素的值（一般是value属性）
            } else if(!item.isFormField()){//上传文件
                File uploadedFile = null;
                String randomFileName;
                do{
                    randomFileName= FileTool.getRandomFileNameByCurrentTime(item.getName());
                    String full=request.getServletContext().getRealPath("/images/interaction"+"/"+randomFileName);//uml_open_course/images/interaction/...
                    if(full==null)
                        break;
                    uploadedFile=new File(full);
                }while(uploadedFile.exists());//确保文件未存在
                if(uploadedFile==null)
                    continue;
                item.write(uploadedFile);//将临时文件转存为新文件保存
                item.delete();//删除临时文件
                qqGroup.setQRcode("../images/interaction/"+randomFileName);
            }
        }
        qqGroupDaoImpl.addQQGroup(qqGroup);
        return 1;
    }

    public void useQQGroup(String id) throws SQLException, ClassNotFoundException {
        QQGroupDao qqGroupDaoImpl = new QQGroupDaoImpl();
        qqGroupDaoImpl.useQQGroup(id);
    }

    public void deleteQQGroup(String id) throws SQLException, ClassNotFoundException {
        QQGroupDao qqGroupDaoImpl = new QQGroupDaoImpl();
        qqGroupDaoImpl.deleteQQGroup(id);
    }
}
