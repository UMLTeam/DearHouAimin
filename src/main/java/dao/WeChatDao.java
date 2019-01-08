package dao;

import domain.WeChat;

import java.sql.SQLException;
import java.util.List;

public interface WeChatDao {
    public void addPhoto(WeChat wechat) throws SQLException, ClassNotFoundException;

    public List<WeChat> showAllPhoto() throws SQLException, ClassNotFoundException;

    public void deletePhoto(int id) throws SQLException, ClassNotFoundException;

}
