package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.catagory;
import model.bean.product;

public class DAO {
	public static Connection connecttt() throws SQLException
	{
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/websitegiaotrinhdientu?user=root";
		    Connection conn = DriverManager.getConnection(URL);
		    return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
		  
		    
	}
	public ArrayList<catagory> getLayradanhmuc() throws SQLException
	{
		ArrayList<catagory> result= new ArrayList<catagory>();
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		ResultSet rs= st.executeQuery("select*from catagory");
		while (rs.next())
		{
			int  id=rs.getInt("id");
			String name=rs.getString("name");
			
			catagory x= new catagory();
			x.setId(id);
			x.setName(name);
			result.add(x);
		
		}
		return result;
	}
	public int checklogin(String username, String password) throws SQLException {
		
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		ResultSet rs= st.executeQuery("select*from user where email='"+username+"' and password='"+password+"'");
		int cnt =0;
		int role=0;
		while(rs.next())
		{
			cnt++;
			 role= rs.getInt("role_id");
			
			
		}
		if(cnt==0)
		{
			return 0 ; // mat khau sai
		}
		else {
			if(role==1)
			{
				return 1; // tra ve user
			}
			else {
				return 2; //tra ve admin
			}
		}
		
	}
	public ArrayList<product> layraProduct() throws SQLException {
		ArrayList<product> result= new ArrayList<product>();
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		ResultSet rs= st.executeQuery("select*from product");
		while (rs.next())
		{
//			 int ID2=rs.getInt(0);
			 int category_id=rs.getInt("category_id");
//			 String title=rs.getString(2);
//			 String file=rs.getString(3);
//			 String description=rs.getString(4);
//			 Date create_at=rs.getDate(5);
//			 int deleted=rs.getInt(6);
//			 int user_id=rs.getInt(7);
			 String img=rs.getString("img");
			 product x= new product();
			 x.setCategory_id(category_id);
//			 x.setCreate_at(create_at);
//			 x.setDescription(description);
//			 x.setUser_id(user_id);
//			 x.setTitle(title);
//			 x.setId(ID2);
			 x.setImg(img);
//			 x.setDeleted(deleted);
			 result.add(x);
		
		}
		return result;
	}
	public ArrayList<product> layraProductByCatagory_id(int id) throws SQLException {
		
		ArrayList<product> result= new ArrayList<product>();
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		ResultSet rs= st.executeQuery("select*from product where category_id='"+id+"'");
		while (rs.next())
		{
			 int ID2=rs.getInt(0);
			 int category_id=rs.getInt(1);
			 String title=rs.getString(2);
			 String file=rs.getString(3);
			 String description=rs.getString(4);
			 Date create_at=rs.getDate(5);
			 int deleted=rs.getInt(6);
			 int user_id=rs.getInt(7);
			 String img=rs.getString(8);
			 product x= new product();
			 x.setCategory_id(category_id);
			 x.setCreate_at(create_at);
			 x.setDescription(description);
			 x.setUser_id(user_id);
			 x.setTitle(title);
			 x.setId(ID2);
			 x.setImg(img);
			 x.setDeleted(deleted);
			 result.add(x);
		
		}
		return result;
	}
	
	


}
