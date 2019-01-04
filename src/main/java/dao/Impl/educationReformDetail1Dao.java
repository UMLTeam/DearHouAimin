package dao.Impl;

import domain.dguterd1;
import utils.JDBCUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class educationReformDetail1Dao {
    //得到数据库连接
    private static Connection connection = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;
    //private static DataBaseConnectionImpl dataBaseConnection = new DataBaseConnectionImpl();

    static {
//        connection = dataBaseConnection.getConnection();
    }

    //查找改革措施
    public static dguterd1 findOneEducationReformDetail1(int num) {
    	connection = JDBCUtil.getConnection();
        //connection = dataBaseConnection.getConnection();
        String sql = "select * from dguterd1_uml where erd1_id = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, num);
            rs = pst.executeQuery();
            dguterd1 erd1 = new dguterd1();
            if (rs.next()) {
                erd1.setDguterd1_id(rs.getInt("erd1_id"));
                erd1.setDguterd1_title(rs.getString("erd1_title"));
                erd1.setDguterd1_type(rs.getString("erd1_type"));
                erd1.setDguterd1_date(rs.getDate("erd1_date"));
                erd1.setDguterd1_origin(rs.getString("erd1_origin"));
                erd1.setDguterd1_content(rs.getString("erd1_content"));
                erd1.setDguterd1_state(rs.getInt("erd1_state"));
            }
            return erd1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return null;
    }

    //删除改革措施
    public static boolean deleteOneEducationReformDetail1(int num) {
    	connection = JDBCUtil.getConnection();
        //connection = dataBaseConnection.getConnection();
        String sql = "delete from dguterd1_uml where erd1_id = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, num);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return false;
    }

    //插入改革措施
    public static boolean insertEducationReformDetail1(dguterd1 erd1) {
    	connection = JDBCUtil.getConnection();
        //connection = dataBaseConnection.getConnection();
        String sql = "insert into dguterd1_uml(erd1_title,erd1_type,erd1_date,erd1_origin,erd1_content,erd1_state) values('" + erd1.getDguterd1_title() + "','" + erd1.getDguterd1_type() + "','" + erd1.getDguterd1_date() + "','" + erd1.getDguterd1_origin() + "','" + erd1.getDguterd1_content() + "','" + erd1.getDguterd1_state() + "')";
        try {
            pst = connection.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return false;
    }

    //修改改革措施
    public static boolean modifyEducationReformDetail1(dguterd1 erd1, int num) {
    	connection = JDBCUtil.getConnection();
        //connection = dataBaseConnection.getConnection();
        String sql = "update dguterd1_uml set erd1_title = ? , erd1_type = ? , erd1_date = ? , erd1_origin = ? , erd1_content = ? ,erd1_state = ? where erd1_id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, erd1.getDguterd1_title());
            pst.setString(2, erd1.getDguterd1_type());
            pst.setDate(3, erd1.getDguterd1_date());
            pst.setString(4, erd1.getDguterd1_origin());
            pst.setString(5, erd1.getDguterd1_content());
            pst.setInt(6, 0);
            pst.setInt(7, num);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return false;
    }

    public static List<dguterd1> getAllSameTypeEducationReformDetail1(String type) {
    	connection = JDBCUtil.getConnection();
        //connection = dataBaseConnection.getConnection();
        List<dguterd1> erd1List = new ArrayList<>();
        String sql = "select * from dguterd1_uml where erd1_type = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, type);
            rs = pst.executeQuery();
            while (rs.next()) {
                dguterd1 erd1 = new dguterd1();
                erd1.setDguterd1_id(rs.getInt("erd1_id"));
                erd1.setDguterd1_title(rs.getString("erd1_title"));
                erd1.setDguterd1_type(rs.getString("erd1_type"));
                erd1.setDguterd1_date(rs.getDate("erd1_date"));
                erd1.setDguterd1_origin(rs.getString("erd1_origin"));
                erd1.setDguterd1_state(rs.getInt("erd1_state"));
                erd1List.add(erd1);
            }
            return erd1List;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }

    public static List<dguterd1> findMeasuresName(String Name) {
    	connection = JDBCUtil.getConnection();
        //connection = dataBaseConnection.getConnection();
        List<dguterd1> erd1List = new ArrayList<>();
        String sql = "select * from dguterd1_uml where erd1_title = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, Name);
            rs = pst.executeQuery();
            while (rs.next()) {
                dguterd1 erd1 = new dguterd1();
                erd1.setDguterd1_id(rs.getInt("erd1_id"));
                erd1.setDguterd1_title(rs.getString("erd1_title"));
                erd1.setDguterd1_type(rs.getString("erd1_type"));
                erd1.setDguterd1_date(rs.getDate("erd1_date"));
                erd1.setDguterd1_origin(rs.getString("erd1_origin"));
                erd1.setDguterd1_state(rs.getInt("erd1_state"));
                erd1List.add(erd1);
            }
            return erd1List;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }

    public static List<dguterd1> getAllEducationReformDetail1() {
    	connection = JDBCUtil.getConnection();
        //connection = dataBaseConnection.getConnection();
        List<dguterd1> erd1List = new ArrayList<>();
        String sql = "select * from dguterd1_uml";
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                dguterd1 erd1 = new dguterd1();
                erd1.setDguterd1_id(rs.getInt("erd1_id"));
                erd1.setDguterd1_title(rs.getString("erd1_title"));
                erd1.setDguterd1_type(rs.getString("erd1_type"));
                erd1.setDguterd1_date(rs.getDate("erd1_date"));
                erd1.setDguterd1_origin(rs.getString("erd1_origin"));
                erd1.setDguterd1_content(rs.getString("erd1_content"));
                erd1.setDguterd1_state(rs.getInt("erd1_state"));
                erd1List.add(erd1);
            }
            return erd1List;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }

    public static int getCountEducationReformDetail1() {
    	connection = JDBCUtil.getConnection();
        //connection = dataBaseConnection.getConnection();
        String sql = "select * from dguterd1_uml";
        int i = 0;
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                i++;
            }
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return i;
    }

    public static boolean changeState(int num, int id) {
    	connection = JDBCUtil.getConnection();
        //connection = dataBaseConnection.getConnection();
        String sql = "update dguterd1_uml set erd1_state = ? where erd1_id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, num);
            pst.setInt(2, id);
            if (pst.executeUpdate() == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return false;
    }


    public static ArrayList<dguterd1> getAlltitleOfErd1() {
    	connection = JDBCUtil.getConnection();
        //connection = dataBaseConnection.getConnection();
        ArrayList<dguterd1> erd1List = new ArrayList<>();
        String sql = "select * from dguterd1_uml GROUP BY erd1_date desc,erd1_id desc";
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                dguterd1 erd1 = new dguterd1();
                erd1.setDguterd1_id(rs.getInt("erd1_id"));
                erd1.setDguterd1_title(rs.getString("erd1_title"));
                erd1.setDguterd1_type(rs.getString("erd1_type"));
                erd1.setDguterd1_date(rs.getDate("erd1_date"));
                erd1.setDguterd1_origin(rs.getString("erd1_origin"));
                erd1.setDguterd1_state(rs.getInt("erd1_state"));
                erd1List.add(erd1);
            }
            return erd1List;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return null;
    }

}
