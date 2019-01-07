package service.Impl;

import dao.Impl.OpenCoursePlanDao;
import domain.OpenCoursePlan;

import java.io.File;
import java.util.List;

public class OpenCoursePlanService {
    /**
     * 删除单个文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    static private boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    /*
        获取一页开课计划
     */
    static public List<OpenCoursePlan> getPlanList(int start, int size){
        OpenCoursePlanDao openCoursePlanDao = new OpenCoursePlanDao();
        List<OpenCoursePlan> plans = openCoursePlanDao.getPlanByPage(start, size);
        return plans;
    }

    /*
        删除开课计划
     */
    static public boolean delete(int id, String contextRealPath){
        OpenCoursePlanDao openCoursePlanDao = new OpenCoursePlanDao();
        OpenCoursePlan openCoursePlan = openCoursePlanDao.getPlan(id);
        if(openCoursePlan == null){
            return false;
        }
        // 从数据库删除
        if(openCoursePlanDao.delete(id)){
            // 从本地磁盘删除文件
            String filePath = contextRealPath + openCoursePlan.getFilePath();
            deleteFile(filePath);
            return true;
        }
        return false;
    }

    /*
        添加开课计划
     */
    static public String add(OpenCoursePlan openCoursePlan){
        OpenCoursePlanDao openCoursePlanDao = new OpenCoursePlanDao();
        return openCoursePlanDao.add(openCoursePlan);
    }
}
