package dao.Impl;

import java.util.ArrayList;
import java.util.List;
import domian.*;

public class textbookDao {
	private dataDao dao;
	
	public boolean add(textbook textbook){
		try {
			dao=new dataDao();
			String sql="insert into textbook(academicYear,academy,classmate,book,author,press,pressInformation,downloadlink)values('"
		               +textbook.getAcademicYear()+"', '"+textbook.getAcademy()+"', '"+textbook.getClassmate()+"', '"+textbook.getBook()+"' ,'"+textbook.getAuthor()
		               +"', '"+textbook.getPress()+"', '"+textbook.getPressInformation()+"', '"+textbook.getDownloadlink()+"')";
			dao.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public textbook queryById(int id){
		String sql="select * from textbook where id="+id;
		textbook temp=new textbook();
		try{
			dao=new dataDao();
			dao.query(sql);
			while (dao.next()) {
				temp.setId(dao.getInt("id"));
				temp.setAcademicYear(dao.getString("academicYear"));
				temp.setAcademy(dao.getString("academy"));
				temp.setClassmate(dao.getString("classmate"));
				temp.setBook(dao.getString("book"));
				temp.setAuthor(dao.getString("author"));
				temp.setPress(dao.getString("press"));
				temp.setPressInformation(dao.getString("pressInformation"));
				temp.setDownloadlink(dao.getString("downloadlink"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	public boolean updateBook(textbook book){
		try {
			dao=new dataDao();
			String sql="update textbook set academicYear='"+book.getAcademicYear()+"',academy='"+book.getAcademy()+
					"',classmate='"+book.getClassmate()+"',book='"+book.getBook()+"',author='"+book.getAuthor()+
					"',press='"+book.getPress()+"', pressInformation='"+book.getPressInformation()+"' where id="+book.getId()+";";
			dao.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public List<textbook> getAll() throws Exception{
		dao=new dataDao();
		List<textbook> bookList=new ArrayList<textbook>();
		String sql="select * from textbook";
		try{
			dao.query(sql);
			while (dao.next()) {
				textbook temp=new textbook();
				temp.setId(dao.getInt("id"));
				temp.setAcademicYear(dao.getString("academicYear"));
				temp.setAcademy(dao.getString("academy"));
				temp.setClassmate(dao.getString("classmate"));
				temp.setBook(dao.getString("book"));
				temp.setAuthor(dao.getString("author"));
				temp.setPress(dao.getString("press"));
				temp.setPressInformation(dao.getString("pressInformation"));
				temp.setDownloadlink(dao.getString("downloadlink"));
				bookList.add(temp);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	public int del(int id) throws Exception{
		dao=new dataDao();
		String sql="delete from textbook where id="+id;
		return dao.update(sql);
	}
}
