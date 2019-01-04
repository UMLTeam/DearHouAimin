package dao.Impl;

import domain.educationReformDetail2Bean;

import java.util.ArrayList;
import java.util.List;

public class educationReformDetail2Dao {
	
	public List<educationReformDetail2Bean> getAll() throws Exception{
		DatabaseDao databaseDao = new DatabaseDao();
		List<educationReformDetail2Bean> dgutEdus = new ArrayList<educationReformDetail2Bean>();
		String sql = "select * from dguterd2_decision";
		databaseDao.query(sql);
		while(databaseDao.next()) {
			educationReformDetail2Bean dgutEdu = new educationReformDetail2Bean();
			dgutEdu.setAddress(databaseDao.getString("address"));
			dgutEdu.setTitle(databaseDao.getString("title"));
			dgutEdu.setTime(databaseDao.getString("time"));
			dgutEdu.setId(databaseDao.getString("decId"));
			dgutEdus.add(dgutEdu);
		}
		return dgutEdus;
	}
	
}
