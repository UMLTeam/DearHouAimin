package dao.Impl;

import dao.DatabaseDao;
import dao.QQGroupDao;
import domain.QQGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QQGroupDaoImpl implements QQGroupDao {

    public QQGroup getGroupByGroupId(String id) throws SQLException, ClassNotFoundException {
        String sql = "select * from qqgroup where groupId = '" + id +"'";
        DatabaseDao dao = new DatabaseDao();
        dao.query(sql);
        ResultSet resultSet = dao.getRs();
        QQGroup qqGroup = new QQGroup();
        qqGroup.setGroupid(resultSet.getString("groupid"));
        qqGroup.setGroupName(resultSet.getString("groupName"));
        qqGroup.setIdkey(resultSet.getString("idkey"));
        qqGroup.setQRcode(resultSet.getString("QRcode"));
        qqGroup.setEnable(resultSet.getString("enable"));
        dao.close();
        return qqGroup;
    }

    public QQGroup getGroupByGroupName(String name) throws SQLException, ClassNotFoundException {
        String sql = "select * from qqgroup where groupId = '" + name +"'";
        DatabaseDao dao = new DatabaseDao();
        dao.query(sql);
        ResultSet resultSet = dao.getRs();
        QQGroup qqGroup = new QQGroup();
        qqGroup.setGroupid(resultSet.getString("groupid"));
        qqGroup.setGroupName(resultSet.getString("groupName"));
        qqGroup.setIdkey(resultSet.getString("idkey"));
        qqGroup.setQRcode(resultSet.getString("QRcode"));
        qqGroup.setEnable(resultSet.getString("enable"));
        dao.close();
        return qqGroup;
    }

    public QQGroup getQQGroupByUse() throws SQLException, ClassNotFoundException {
        String sql =  "select * from qqgroup where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        dao.query(sql);
        ResultSet resultSet = dao.getRs();
        QQGroup qqGroup = new QQGroup();
        while (resultSet.next()){
            qqGroup.setGroupid(resultSet.getString("groupid"));
            qqGroup.setGroupName(resultSet.getString("groupName"));
            qqGroup.setIdkey(resultSet.getString("idkey"));
            qqGroup.setQRcode(resultSet.getString("QRcode"));
            qqGroup.setEnable(resultSet.getString("enable"));
        }
        dao.close();
        return qqGroup;
    }

    public ArrayList getQQGroups() throws SQLException, ClassNotFoundException {
        String sql = "select * from qqgroup";
        DatabaseDao dao = new DatabaseDao();
        dao.query(sql);
        ResultSet resultSet = dao.getRs();
        ArrayList<QQGroup> qqGroups = new ArrayList<>();
        while (resultSet.next()) {
            QQGroup qqGroup = new QQGroup();
            qqGroup.setGroupid(resultSet.getString("groupid"));
            qqGroup.setGroupName(resultSet.getString("groupName"));
            qqGroup.setIdkey(resultSet.getString("idkey"));
            qqGroup.setQRcode(resultSet.getString("QRcode"));
            qqGroup.setEnable(resultSet.getString("enable"));
            qqGroups.add(qqGroup);
        }
        dao.close();
        return  qqGroups;
    }

    public void addQQGroup(QQGroup qqGroup) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        if("true".equals(qqGroup.getEnable())){
            String sql = "update qqgroup set enable = \"false\" where enable = \"true\"";
            dao.update(sql);
        }
        String sql = "insert into qqgroup(QRcode,idkey,groupid,groupName,enable) values('"
                +qqGroup.getQRcode().replace("\\","\\\\")+"','"
                +qqGroup.getIdkey().replace("\"","\\\"")+"','"
                +qqGroup.getGroupid()+"','"
                +qqGroup.getGroupName()+"','"
                +qqGroup.getEnable()+"')";
        dao.update(sql);
        dao.close();
    }

    public void useQQGroup(String id) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        String sql = "update qqgroup set enable = \"false\" where enable = \"true\" ";
        dao.update(sql);
        sql = "update qqgroup set enable = \"true\" where groupid = \""+id +"\"";
        dao.update(sql);
        //dao.close();
    }

    public void deleteQQGroup(String id) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        String sql = "delete from qqgroup where groupid = \""+id +"\"";
        dao.delete(sql);
        //dao.close();
    }
}
