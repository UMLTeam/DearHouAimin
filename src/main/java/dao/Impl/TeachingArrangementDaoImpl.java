package dao.Impl;

import dao.DatabaseDao;
import dao.TeachingArrangementDao;
import domain.LeaveMsg;
import domain.TeachingGeneral;
import domain.TeachingPlan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @authoor linzerong
 * @create 2018-12-23 12:18
 */
public class TeachingArrangementDaoImpl implements TeachingArrangementDao {
    public TeachingPlan getCurPlan() throws SQLException, ClassNotFoundException {
        String sql = "select * from uml_teaching_plan where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        TeachingPlan plan = new TeachingPlan();
        dao.query(sql);
        ResultSet resultSet = dao.getRs();
        while (resultSet.next()) {
            //    System.out.println("!!!!!!!");
            plan.setPlanId(resultSet.getInt("planId"));
            plan.setPlanName(resultSet.getString("planName"));
            plan.setPlanURL(resultSet.getString("planURL"));
            plan.setEnable(resultSet.getString("enable"));
            plan.setTime(resultSet.getString("time"));
        }
        dao.close();
        return plan;
    }

    public List<TeachingPlan> showAllPlans() throws SQLException, ClassNotFoundException {
        List<TeachingPlan> plans = new ArrayList<>();
        DatabaseDao dao = new DatabaseDao();
        String sql = "select * from uml_teaching_plan";
        dao.query(sql);
        ResultSet rs = dao.getRs();
        while (rs.next()) {
            TeachingPlan plan = new TeachingPlan();
            plan.setPlanId(rs.getInt("planId"));
            plan.setPlanName(rs.getString("planName"));
            plan.setPlanURL(rs.getString("planURL"));
            plan.setEnable(rs.getString("enable"));
            plan.setTime(rs.getString("time"));
            plans.add(plan);
        }
        dao.close();
        return plans;
    }

    public int usePlan(int planId) throws SQLException, ClassNotFoundException {
        String sql = "update uml_teaching_plan set enable = \"false\" where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        dao.update(sql);
        sql = "update uml_teaching_plan set `enable` = \"true\" where planId = " + planId;
        return dao.update(sql);
    }

    public int delPlan(int planId) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        String sql = "delete from uml_teaching_plan where planId = " + planId;
        return dao.update(sql);
    }

    public void addPlan(TeachingPlan plan) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        if ("true".equals(plan.getEnable())) {
            String sql = "update uml_teaching_plan set enable = \"false\" where enable = \"true\"";
            dao.update(sql);
        }
        String sql = "insert into uml_teaching_plan(planName,planURL,enable) values(\"" + plan.getPlanName() + "\",\"" +
                plan.getPlanURL() + "\",\"" + plan.getEnable() + "\")";
        dao.update(sql);
    }

    public void addleaveMsg(String leaveMsgContent) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        String sql = "insert into leave_msg(leaveMsgContent) values ('" + leaveMsgContent + "')";
        dao.update(sql);
        dao.close();
    }

    public List<LeaveMsg> showAllLeaveMsgs() throws SQLException, ClassNotFoundException {
        List<LeaveMsg> leaveMsgs = new ArrayList<>();
        DatabaseDao dao = new DatabaseDao();
        String sql = "select * from leave_msg";
        dao.query(sql);
        ResultSet rs = dao.getRs();
        while (rs.next()) {
            LeaveMsg leaveMsg = new LeaveMsg();
            leaveMsg.setLeaveMsgId(rs.getInt("leaveMsgId"));
            leaveMsg.setLeaveMsgContent(rs.getString("leaveMsgContent"));
            leaveMsg.setPublishedTime(rs.getString("publishedTime"));
            leaveMsg.setUserId(rs.getInt("userId"));
            leaveMsgs.add(leaveMsg);
        }
        dao.close();
        return leaveMsgs;
    }

    public int delLeaveMsg(int leaveMsgId) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        String sql = "delete from leave_msg where leaveMsgId = " + leaveMsgId;
        return dao.update(sql);
    }

    // ****************************
    public TeachingGeneral getCurGeneral() throws SQLException, ClassNotFoundException{
        String sql = "select * from uml_teaching_general where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        TeachingGeneral general = new TeachingGeneral();
        dao.query(sql);
        ResultSet resultSet = dao.getRs();

        while (resultSet.next()){
            //    System.out.println("!!!!!!!");
//            genreal.getGeneralId(resultSet.getInt("generalId"));
            general.setGeneralId(resultSet.getInt("generalId"));
            general.setGeneralName(resultSet.getString("generalName"));
            general.setGeneralURL(resultSet.getString("generalURL"));
            general.setEnable(resultSet.getString("enable"));
            general.setTime(resultSet.getString("time"));
        }
        dao.close();
        return general;
    }

    public List<TeachingGeneral> showAllGenerals() throws SQLException, ClassNotFoundException{
        List<TeachingGeneral> generals = new ArrayList<>();
        DatabaseDao dao = new DatabaseDao();
        String sql = "select * from uml_teaching_general";
        dao.query(sql);
        ResultSet rs = dao.getRs();

        while (rs.next()){
            TeachingGeneral general = new TeachingGeneral();
            general.setGeneralId(rs.getInt("generalId"));
            general.setGeneralName(rs.getString("generalName"));
            general.setGeneralURL(rs.getString("generalURL"));
            general.setEnable(rs.getString("enable"));
            general.setTime(rs.getString("time"));
            generals.add(general);
        }
        dao.close();
        return generals;
    }

    public int useGeneral(int generalId) throws SQLException, ClassNotFoundException{
        String sql = "update uml_teaching_general set enable = \"false\" where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        dao.update(sql);
        sql = "update uml_teaching_general set `enable` = \"true\" where generalId = "+generalId;
        return dao.update(sql);
    }

    public int delGeneral(int generalId) throws SQLException, ClassNotFoundException{
        DatabaseDao dao = new DatabaseDao();
        String sql = "delete from uml_teaching_general where generalId = "+generalId;
        return dao.update(sql);
    }

    public void  addGeneral(TeachingGeneral general) throws SQLException, ClassNotFoundException{
        DatabaseDao dao = new DatabaseDao();
        if("true".equals(general.getEnable())){
            String sql = "update uml_teaching_general set enable = \"false\" where enable = \"true\"";
            dao.update(sql);
        }
        String sql = "insert into uml_teaching_general(generalName,generalURL,enable) values(\""+general.getGeneralName()+"\",\""+
                general.getGeneralURL()+"\",\""+general.getEnable()+"\")";
        dao.update(sql);
    }
}
