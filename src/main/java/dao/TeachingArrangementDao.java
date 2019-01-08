package dao;

import domain.LeaveMsg;
import domain.TeachingGeneral;
import domain.TeachingPlan;

import java.sql.SQLException;
import java.util.List;

public interface TeachingArrangementDao {
    public TeachingPlan getCurPlan() throws SQLException, ClassNotFoundException;

    public List<TeachingPlan> showAllPlans() throws SQLException, ClassNotFoundException;

    public int usePlan(int planId) throws SQLException, ClassNotFoundException;

    public int delPlan(int planId) throws SQLException, ClassNotFoundException;

    public void addPlan(TeachingPlan plan) throws SQLException, ClassNotFoundException;

    public void addleaveMsg(String leaveMsgContent) throws SQLException, ClassNotFoundException;

    public List<LeaveMsg> showAllLeaveMsgs() throws SQLException, ClassNotFoundException;

    public int delLeaveMsg(int leaveMsgId) throws SQLException, ClassNotFoundException;

    public TeachingGeneral getCurGeneral() throws SQLException, ClassNotFoundException;

    public List<TeachingGeneral> showAllGenerals() throws SQLException, ClassNotFoundException;

    public int useGeneral(int generalId) throws SQLException, ClassNotFoundException;

    public int delGeneral(int generalId) throws SQLException, ClassNotFoundException;

    public void addGeneral(TeachingGeneral general) throws SQLException, ClassNotFoundException;


}
