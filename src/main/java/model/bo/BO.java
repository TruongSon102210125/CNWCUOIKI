package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.catagory;
import model.bean.product;
import model.bean.user;
import model.dao.DAO;

public class BO {
	DAO dao = new DAO();
	public ArrayList<catagory> layradanhmuc() throws SQLException
	{
		return dao.getLayradanhmuc();
	}
	public int checklogin(String username,String password ) throws SQLException
	{
		return dao.checklogin(username,password);
	}
	public ArrayList<product> layraProduct() throws SQLException
	{
		return dao.layraProduct();
	}
	public ArrayList<product> layraProductByCatagory_id(int id ) throws SQLException
	{
		return dao.layraProductByCatagory_id(id);
	}
	public int checktrung(String username)
	{
		return 1;
	}
	public void insertUser(int id, String fullname, String password, String email,String phone_number ,int i) throws SQLException
	{
		dao.insertUser(id,fullname,password,email,phone_number,i);
	}
	public String layfullnamebyemail(String email) throws SQLException
	{
		 return dao.layfullnamebyemail(email);

	}
	public int  layraIdUserByEmail(String email) throws SQLException
	{
		 return dao.layraIdUserByEmail(email);
	}
	public ArrayList<product> layraProductByTitle(String title) throws SQLException
	{
		return dao.layraProductByTitle(title);
	}
	public ArrayList<product> getdetailProduct(int id_product) throws SQLException
	{
		return dao.getdetailProduct(id_product);
	}
	public ArrayList<product> getmybook()throws SQLException
	{
		return dao.getmybook();
	}
	public void deleteMybook (int id_product)throws SQLException
	{
		dao.deleteMybook(id_product);
	}
	public ArrayList<product> layrabook(int id_user) throws SQLException
	{
		return dao.layrabook(id_user);
	}
	public void addBooklove(int iduser,int idproduct) throws SQLException
	{
		
		 dao.addBooklove(iduser, idproduct);
	}
	


}
