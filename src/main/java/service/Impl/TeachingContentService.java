package service.Impl;

import dao.Impl.TeachingContentDaoImpl;
import dao.TeachingContentDao;
import domain.TeachingContent;

import java.sql.SQLException;
import java.util.List;

public class TeachingContentService {
    public TeachingContent getCurContent() throws SQLException, ClassNotFoundException {
        TeachingContentDao TADao = new TeachingContentDaoImpl();
        TeachingContent content = TADao.getCurContent();
        return content;
    }

    public List<TeachingContent> showAllContents() throws SQLException, ClassNotFoundException {
        TeachingContentDao TAD = new TeachingContentDaoImpl();
        return TAD.showAllContent();
    }

    public int useContent(int contentId) throws SQLException, ClassNotFoundException {
        TeachingContentDao tad = new TeachingContentDaoImpl();
        return tad.useContent(contentId);
    }

    public int delContent(int contentId) throws SQLException, ClassNotFoundException {
        TeachingContentDao tad = new TeachingContentDaoImpl();
        return tad.delContent(contentId);
    }
    public void addContent(TeachingContent content) throws SQLException, ClassNotFoundException {
        TeachingContentDao TAD = new TeachingContentDaoImpl();
        TAD.addContent(content);
        return;
    }
}
