package dao;

import domain.TeachingContent;

import java.sql.SQLException;
import java.util.List;

public interface TeachingContentDao {
    public TeachingContent getCurContent() throws SQLException, ClassNotFoundException;

    public List<TeachingContent> showAllContent() throws SQLException, ClassNotFoundException;

    public int useContent(int contentId) throws SQLException, ClassNotFoundException;

    public int delContent(int contentId) throws SQLException, ClassNotFoundException;

    public void addContent(TeachingContent content) throws SQLException, ClassNotFoundException;
}
