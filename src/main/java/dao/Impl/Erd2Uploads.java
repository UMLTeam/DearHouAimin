package dao.Impl;

public class Erd2Uploads {
	public void insertToDB(String address,String title, String time) throws Exception{
		DatabaseDao databaseDao = new DatabaseDao();
		//对源文件路径中的“\”全部转换成“/”
        address = address.replaceAll("\\\\", "/");
        address = ".."+address;

		String sql = "insert into dguterd2_decision (address,title,time)"
				+ "values('"+address+"','"+title+"','"+time+"')";
		System.out.println("插入的sql语句为："+sql);
		databaseDao.insert(sql);
	}
}
