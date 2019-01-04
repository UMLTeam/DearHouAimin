package dao.Impl;

import dao.CalendarDao;
import dao.DatabaseDao;
import domain.Calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalendarDaoImpl implements CalendarDao {
    public Calendar findCalendar() {
        String sql = "select * from t_calendar where used = 1";
        Calendar calendar = new Calendar();
        try {
            DatabaseDao databaseDao = new DatabaseDao();

            databaseDao.query(sql);
            ResultSet resultSet = databaseDao.getRs();

            while (resultSet.next()) {
                calendar.setCid(resultSet.getInt("cid"));
                calendar.setCname(resultSet.getString("cname"));
                calendar.setPdfUrl(resultSet.getString("pdfUrl"));
                calendar.setCreatetime(resultSet.getTime("createtime"));
                calendar.setUsed(resultSet.getInt("used"));
            }
            databaseDao.close();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return calendar;
    }

    public List<Calendar> findAll() {
        List<Calendar> calendars = new ArrayList<>();
        String sql = "select * from t_calendar";
        try {
            DatabaseDao databaseDao = new DatabaseDao();
            databaseDao.query(sql);
            ResultSet resultSet = databaseDao.getRs();

            while (resultSet.next()) {
                Calendar calendar = new Calendar();
                calendar.setCid(resultSet.getInt("cid"));
                calendar.setCname(resultSet.getString("cname"));
                calendar.setPdfUrl(resultSet.getString("pdfUrl"));
                calendar.setCreatetime(resultSet.getTime("createtime"));
                calendar.setUsed(resultSet.getInt("used"));
                calendars.add(calendar);
            }
            databaseDao.close();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return calendars;
    }

    public void deleteByCid(Integer cid) {
        String sql = "delete from t_calendar where cid = " + cid;
        try {
            DatabaseDao databaseDao = new DatabaseDao();
            databaseDao.update(sql);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    public void stop(Integer cid) {
        String sql = "update t_calendar set used = 0 where cid = " + cid;
        try {
            DatabaseDao databaseDao = new DatabaseDao();
            databaseDao.update(sql);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void use(Integer cid) {
        String sql = "update t_calendar set used = 1 where cid = " + cid;
        try {
            DatabaseDao databaseDao = new DatabaseDao();
            databaseDao.update(sql);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void add(Calendar calendar) {
        DatabaseDao databaseDao = null;
        try {
            databaseDao = new DatabaseDao();
            if(calendar.getUsed() == 1){
                String sql = "update t_calendar set used = 0 where used = 1";
                databaseDao.update(sql);
            }
            String sql = "insert into t_calendar(cname,pdfUrl,used) values(\""+calendar.getCname()+"\",\""+
                    calendar.getPdfUrl()+"\",\""+calendar.getUsed()+"\")";
            databaseDao.update(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
