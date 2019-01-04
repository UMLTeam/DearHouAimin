package service.Impl;

import dao.Impl.TeachingArrangementDaoImpl;
import dao.TeachingArrangementDao;
import domain.LeaveMsg;
import domain.TeachingGeneral;
import domain.TeachingPlan;

import java.sql.SQLException;
import java.util.List;

/**
 * @authoor linzerong
 * @create 2018-12-23 12:14
 */
public class TeachingArrangementService {
    public TeachingPlan getCurPlan() throws SQLException, ClassNotFoundException {
        TeachingArrangementDao TADao = new TeachingArrangementDaoImpl();
        TeachingPlan plan = TADao.getCurPlan();
        return plan;
    }

    public List<TeachingPlan> showAllPlans() throws SQLException, ClassNotFoundException {
        TeachingArrangementDao TAD = new TeachingArrangementDaoImpl();
        return TAD.showAllPlans();
    }

    public int usePlan(int planId) throws SQLException, ClassNotFoundException {
        TeachingArrangementDao tad = new TeachingArrangementDaoImpl();
        return tad.usePlan(planId);
    }

    public int delPlan(int planId) throws SQLException, ClassNotFoundException {
        TeachingArrangementDao tad = new TeachingArrangementDaoImpl();
        return tad.delPlan(planId);
    }
    public void addPlan(TeachingPlan plan) throws SQLException, ClassNotFoundException {
        TeachingArrangementDao TAD = new TeachingArrangementDaoImpl();
        TAD.addPlan(plan);
        return;
    }

    public void addLeaveMsg(String leaveMsgContent) throws SQLException, ClassNotFoundException {
        TeachingArrangementDao TAD = new TeachingArrangementDaoImpl();
        TAD.addleaveMsg(leaveMsgContent);
    }

    public List<LeaveMsg> showAllLeaveMsgs() throws SQLException, ClassNotFoundException {
        TeachingArrangementDao TAD = new TeachingArrangementDaoImpl();
        return TAD.showAllLeaveMsgs();
    }

    public int delLeaveMsg(int planId) throws SQLException, ClassNotFoundException {
        TeachingArrangementDao tad = new TeachingArrangementDaoImpl();
        return tad.delLeaveMsg(planId);
    }

    // ***************************************
    public TeachingGeneral getCurGeneral() throws  SQLException, ClassNotFoundException{
        TeachingArrangementDao TADao = new TeachingArrangementDaoImpl();
        TeachingGeneral general = TADao.getCurGeneral();
        return general;
    }

    public List<TeachingGeneral> showAllGenerals() throws SQLException, ClassNotFoundException {
        TeachingArrangementDao TAD = new TeachingArrangementDaoImpl();
        return TAD.showAllGenerals();
    }

    public int useGeneral(int generalId) throws SQLException, ClassNotFoundException {
        TeachingArrangementDao tad = new TeachingArrangementDaoImpl();
        return tad.useGeneral(generalId);
    }

    public int delGeneral(int generalId) throws SQLException, ClassNotFoundException {
        TeachingArrangementDao tad = new TeachingArrangementDaoImpl();
        return tad.delGeneral(generalId);
    }

    public void addGeneral(TeachingGeneral general) throws SQLException, ClassNotFoundException {
        TeachingArrangementDao TAD = new TeachingArrangementDaoImpl();
        TAD.addGeneral(general);
        return;
    }
}
