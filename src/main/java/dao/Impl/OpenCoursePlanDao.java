package dao.Impl;

import domain.OpenCoursePlan;
import utils.JDBCutils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OpenCoursePlanDao {
    private JDBCutils jdbcutil = new JDBCutils();

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        jdbcutil.releaseConn();
    }

    /*
        获取单个开课计划
     */
    private OpenCoursePlan getPlan(String sql, int arg){
        List<Object> params = new ArrayList<>();
        params.add(arg);
        try{
            Map<String, Object> map= jdbcutil.findSimpleResult(sql, params);
            if(map.isEmpty()) return null;
            OpenCoursePlan openCoursePlan = new OpenCoursePlan();
            openCoursePlan.setId((int)map.get("id"));
            openCoursePlan.setTerm((int)map.get("term"));
            openCoursePlan.setFilePath((String)map.get("filePath"));
            //OpenCoursePlan openCoursePlan = (OpenCoursePlan)BeanUtil.convertMap(OpenCoursePlan.class, map);
            return openCoursePlan;
        }catch (Exception e){
            return null;
        }
    }
    // 通过id关键字获取一个开课计划
    public OpenCoursePlan getPlan(int id){
        String sql = "select * from open_course_plan  where id = ?";
        return getPlan(sql, id);
    }
    // 通过term关键字获取一个开课计划
    public OpenCoursePlan getOpenCoursePlanByTerm(int term){
        String sql = "select * from open_course_plan  where term= ?";
        return getPlan(sql, term);
    }

    /*
        获取一页开课计划
     */
    public List<OpenCoursePlan> getPlanByPage(int page, int size){
        List<OpenCoursePlan> ans = new ArrayList<OpenCoursePlan>();
        String sql = "select * from open_course_plan ORDER BY term DESC limit ?, ?";
        List<Object> params=new ArrayList<>();
        params.add(page*size);
        // 查找size+1个，方便判断是否存在下一页
        params.add(size+1);
        try {
            List<Map<String, Object>> list = jdbcutil.findModeResult(sql, params);
            for (int i=0;i<list.size();++i){
                OpenCoursePlan openCoursePlan = new OpenCoursePlan();
                Map<String,Object> map = list.get(i);
                openCoursePlan.setId((int)map.get("id"));
                openCoursePlan.setTerm((int)map.get("term"));
                openCoursePlan.setFilePath((String)map.get("filePath"));
                //OpenCoursePlan openCoursePlan = (OpenCoursePlan)BeanUtil.convertMap(OpenCoursePlan.class, list.get(i));
                ans.add(openCoursePlan);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return ans;
    }


    /*
        删除开课计划

     */
    public boolean delete(int id){
        String sql = "delete from open_course_plan where id = ?";
        List<Object> params=new ArrayList<>();
        params.add(id);
        try {
            return jdbcutil.updateByPreparedStatement(sql, params);
        }catch (SQLException e) {
            return false;
        }
    }


    /*
        添加开课计划

     */
    public String add(OpenCoursePlan openCoursePlan){
        // 先检查是否存在记录
        OpenCoursePlan isExsit = getOpenCoursePlanByTerm(openCoursePlan.getTerm());
        if(isExsit == null){
            String sql = "insert into open_course_plan values(null,?,?)";
            List<Object> params=new ArrayList<>();
            params.add(openCoursePlan.getTerm());
            params.add(openCoursePlan.getFilePath());
            try{
                jdbcutil.updateByPreparedStatement(sql, params);
                return "添加成功";
            }catch (Exception e){
                return "添加到数据库时出错";
            }
        }else{
            return "添加失败，记录已存在";
        }
    }
}
