package dao;

import domain.QQGroup;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QQGroupDao {
    public QQGroup getGroupByGroupId(String id) throws SQLException, ClassNotFoundException;

    public QQGroup getGroupByGroupName(String name) throws SQLException, ClassNotFoundException;

    public QQGroup getQQGroupByUse() throws SQLException, ClassNotFoundException;

    public ArrayList getQQGroups() throws SQLException, ClassNotFoundException;

    public void addQQGroup(QQGroup qqGroup) throws SQLException, ClassNotFoundException;

    public void useQQGroup(String id) throws SQLException, ClassNotFoundException;

    public void deleteQQGroup(String id) throws SQLException, ClassNotFoundException;
}
