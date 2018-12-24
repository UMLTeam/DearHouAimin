package service.Impl;

import dao.impl.DBConnectionImpl;
import domian.ErrorMess;
import service.IAddTeachingVideoService;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddTeachingVideoServiceImpl implements IAddTeachingVideoService {

    public static void add(String name) throws ErrorMess{
        try {
            Connection con = DBConnectionImpl.getConnection();
            String sql = "insert into course (name) values (?)";
            PreparedStatement ps = null;

            assert con != null;
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
            ps.close();
            con.close();

//        } catch (MySQLIntegrityConstraintViolationException e) {
//            throw new ErrorMess("已存在该课程");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorMess("其他问题,请...");
        }
    }
}
