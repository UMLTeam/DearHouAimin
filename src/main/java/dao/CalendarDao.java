package dao;

import domain.Calendar;

import java.util.List;

public interface CalendarDao {
    public Calendar findCalendar();

    public List<Calendar> findAll();

    public void deleteByCid(Integer cid);

    public void stop(Integer cid);

    public void use(Integer cid);

    public void add(Calendar calendar);

}
