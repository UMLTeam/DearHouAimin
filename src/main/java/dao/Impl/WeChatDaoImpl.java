package dao.Impl;

import dao.DatabaseDao;
import dao.WeChatDao;
import domain.WeChat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WeChatDaoImpl implements WeChatDao {
    public void addPhoto(WeChat wechat) throws SQLException, ClassNotFoundException{
        DatabaseDao dao = new DatabaseDao();
        String sql = "insert into uml_teaching_WeChat(date,imageUrl) values('" + new SimpleDateFormat("yyyy-MM-dd").format(wechat.getPublish_time()) + "','" + wechat.getSrc() + "')";
        dao.update(sql);
    }

    public List<WeChat> showAllPhoto() throws SQLException, ClassNotFoundException {
        List<WeChat> weChatList = new ArrayList<>();
        DatabaseDao dao = new DatabaseDao();
        String sql = "select * from uml_teaching_WeChat";
        dao.query(sql);
        ResultSet rs = dao.getRs();
        while (rs.next()){
            WeChat photo = new WeChat();
            photo.setId(rs.getInt("Id"));
            photo.setSrc(rs.getString("imageUrl"));
            photo.setPublish_time(rs.getTimestamp("date"));
            weChatList.add(photo);
        }
        dao.close();
        return weChatList;
    }
    public void deletePhoto(int id) throws SQLException, ClassNotFoundException{
        DatabaseDao dao = new DatabaseDao();
        String sql = "delete from uml_teaching_WeChat where Id = "+id;
        dao.update(sql);
    }
}
