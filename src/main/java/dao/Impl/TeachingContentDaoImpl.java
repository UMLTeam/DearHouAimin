package dao.Impl;

import dao.DatabaseDao;
import dao.TeachingContentDao;
import domain.TeachingContent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @authoor linzerong
 * @create 2018-12-23 12:18
 */
public class TeachingContentDaoImpl implements TeachingContentDao {
    public TeachingContent getCurContent() throws SQLException, ClassNotFoundException {
        String sql = "select * from uml_teaching_content where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        TeachingContent content = new TeachingContent();
        dao.query(sql);
        ResultSet resultSet = dao.getRs();
        while (resultSet.next()){
            //    System.out.println("!!!!!!!");
            content.setContentId(resultSet.getInt("contentId"));
            content.setContentName(resultSet.getString("contentName"));
            content.setContentURL(resultSet.getString("contentURL"));
            content.setEnable(resultSet.getString("enable"));
            content.setTime(resultSet.getString("time"));
        }
        dao.close();
        return content;
    }

    public List<TeachingContent> showAllContent() throws SQLException, ClassNotFoundException {
        List<TeachingContent> contents = new ArrayList<>();
        DatabaseDao dao = new DatabaseDao();
        String sql = "select * from uml_teaching_content";
        dao.query(sql);
        ResultSet rs = dao.getRs();
        while (rs.next()){
            TeachingContent content = new TeachingContent();
            content.setContentId(rs.getInt("contentId"));
            content.setContentName(rs.getString("contentName"));
            content.setContentURL(rs.getString("contentURL"));
            content.setEnable(rs.getString("enable"));
            content.setTime(rs.getString("time"));
            contents.add(content);
        }
        dao.close();
        return contents;
    }

    public int useContent(int contentId) throws SQLException, ClassNotFoundException {
        String sql = "update uml_teaching_content set enable = \"false\" where enable = \"true\"";
        DatabaseDao dao = new DatabaseDao();
        dao.update(sql);
        sql = "update uml_teaching_content set `enable` = \"true\" where contentId = "+contentId;
        return dao.update(sql);
    }

    public int delContent(int contentId) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        String sql = "delete from uml_teaching_content where contentId = "+contentId;
        return dao.update(sql);
    }

    public void addContent(TeachingContent content) throws SQLException, ClassNotFoundException {
        DatabaseDao dao = new DatabaseDao();
        if("true".equals(content.getEnable())){
            String sql = "update uml_teaching_content set enable = \"false\" where enable = \"true\"";
            dao.update(sql);
        }
        String sql = "insert into uml_teaching_content(contentName,contentURL,enable) values(\""+content.getContentName()+"\",\""+
                content.getContentURL()+"\",\""+content.getEnable()+"\")";
        dao.update(sql);
    }
}