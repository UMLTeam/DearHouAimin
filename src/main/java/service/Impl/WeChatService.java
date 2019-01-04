package service.Impl;

import dao.Impl.WeChatDaoImpl;
import dao.WeChatDao;
import domain.WeChat;

import java.sql.SQLException;
import java.util.List;

public class WeChatService {
    public void addPhoto(WeChat wechat) throws SQLException, ClassNotFoundException {
        WeChatDao Dao = new WeChatDaoImpl();
        Dao.addPhoto(wechat);
        return;
    }
    public List<WeChat> showAllPhotos() throws SQLException, ClassNotFoundException {
        WeChatDao Dao = new WeChatDaoImpl();
        return Dao.showAllPhoto();
    }
    public void deletePhoto(int id) throws SQLException, ClassNotFoundException {
        WeChatDao Dao = new WeChatDaoImpl();
        Dao.deletePhoto(id);
    }
}
