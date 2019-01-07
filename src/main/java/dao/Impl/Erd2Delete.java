package dao.Impl;

public class Erd2Delete {
	public void deleteFromDB(String decId) throws Exception{
		DatabaseDao databaseDao = new DatabaseDao();
		String sql = "delete from dguterd2_decision where decId="+decId;
		databaseDao.insert(sql);
	}
}
