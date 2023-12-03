package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.catagory;
import model.bean.product;
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
	


}
