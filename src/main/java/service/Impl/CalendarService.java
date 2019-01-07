package service.Impl;

import dao.CalendarDao;
import dao.Impl.CalendarDaoImpl;
import domain.Calendar;

import java.util.List;

public class CalendarService {
    private CalendarDao calendarDao = new CalendarDaoImpl();

    public Calendar findCalendar() {
        return calendarDao.findCalendar();
    }

    public List<Calendar> findAll() {
        return calendarDao.findAll();
    }

    public void deleteByCid(Integer cid) {
        calendarDao.deleteByCid(cid);
    }

    public void stop(Integer cid) {
        calendarDao.stop(cid);
    }

    public void use(Integer cid) {
        calendarDao.use(cid);
    }

    public void add(Calendar calendar) {
        calendarDao.add(calendar);
    }
}
