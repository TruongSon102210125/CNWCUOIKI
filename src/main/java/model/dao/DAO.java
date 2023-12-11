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
import model.bean.user;

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
			 String img=rs.getString("img");
			 String title= rs.getString("title");
			 int id= rs.getInt("id");
			 product x= new product();
			 x.setCategory_id(category_id);
			 x.setId(id);
			 x.setTitle(title);
			 x.setImg(img);
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
//			 Date create_at=rs.getDate(5);
			 int deleted=rs.getInt(6);
			 int user_id=rs.getInt(7);
			 String img=rs.getString(8);
			 product x= new product();
			 x.setCategory_id(category_id);
//			 x.setCreate_at(create_at);
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
	public void insertUser(int id, String fullname, String password, String email,String phone_number ,int i) throws SQLException {
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		String qr= "insert into `user`(`id`,`fullname`,`email`,`phone_number`,`password`,`role_id`) values('"+id+"','"+fullname+"','"+email+"','"+phone_number+"','"+password+"','"+i+"')";
		System.out.println(qr);
		
		st.executeUpdate(qr);
		
	}
	public String layfullnamebyemail(String email) throws SQLException
	{
		System.out.println(email);
	
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		ResultSet rs= st.executeQuery("select fullname from user where email='"+email+"'");
		String email1=null;
		while (rs.next())
		{
			 email1= rs.getString("fullname");
			 System.out.println(email1);
		
		}
		return email1;
	}
	public ArrayList<product> layraProductByTitle(String title1) throws SQLException {
		ArrayList<product> result= new ArrayList<product>();
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		String qr;
		if(title1!=null)
		{
			qr="SELECT * FROM `product` WHERE title LIKE '%"+title1+"%'";
		}
		else {
			qr="SELECT * FROM `product`";
		}
		
		ResultSet rs= st.executeQuery(qr);
		while (rs.next())
		{
			 int category_id=rs.getInt("category_id");
			 String img=rs.getString("img");
			 String title= rs.getString("title");
			 product x= new product();
			 x.setCategory_id(category_id);
			 x.setTitle(title);
			 x.setImg(img);
			 result.add(x);
		
		}
		return result;
		
	}
	public ArrayList<product> getdetailProduct(int id_product) throws SQLException {
		ArrayList<product> result= new ArrayList<product>();
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		ResultSet rs= st.executeQuery("select*from product where id='"+id_product+"'");
		while (rs.next())
		{
			
			 product x= new product();
			 String desciption= rs.getString("description");
			 String file =	 rs.getString("file");
			 String title= rs.getString("title");
			 int id = rs.getInt("id");
			 
			 x.setTitle(title);
			 x.setDescription(desciption);
			x.setFile(file);
			x.setId(id);
		
			 result.add(x);
		
		}
		return result;
	}
	public ArrayList<product> getmybook() throws SQLException {
		ArrayList<product> result= new ArrayList<product>();
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		ResultSet rs= st.executeQuery("SELECT p2.id,p2.description,p2.file,p2.title,p2.img FROM product_select  p1 JOIN product  p2 ON p1.id_product = p2.id");
		while (rs.next())
		{
			
			 product x= new product();
			 String desciption= rs.getString("description");
			 String file =	 rs.getString("file");
			 String title= rs.getString("title");
			 String img = rs.getString("img");
			 int id = rs.getInt("id");
			 x.setTitle(title);
			 x.setDescription(desciption);
			x.setFile(file);
			x.setImg(img);
			x.setId(id);
			 result.add(x);
		
		}
		return result;
	}
	public void deleteMybook(int id_product) throws SQLException {
		
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		String qr= "delete from product_select where id_product='"+id_product+"'";
		st.executeUpdate(qr);
		
	}
	public int layraIdUserByEmail(String email) throws SQLException {
		
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		ResultSet rs= st.executeQuery("select id from user where email='"+email+"'");
		int email1=-1;
		while (rs.next())
		{
			email1= rs.getInt("id");
			 System.out.println("Day la id user"+email1);
		
		}
		return email1;
	}
	public ArrayList<product> layrabook(int id_user) throws SQLException {
		ArrayList<product> result= new ArrayList<product>();
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
//		String qr2= "SELECT p2.id,p2.description,p2.file,p2.title,p2.img FROM product_select  p1 JOIN product  p2 ON p1.id_product = p2.id";
		String qr="SELECT DISTINCT p.id,p.description,p.file,p.title,p.img FROM product p JOIN product_select ps ON p.id = ps.id_product JOIN user u ON u.id=ps.id_user and ps.id_user='"+id_user+"' ";
		ResultSet rs= st.executeQuery(qr);
		System.out.println(qr);
		while (rs.next())
		{
			System.out.println("Vao lap");
			 product x= new product();
			 String desciption= rs.getString("description");
			 String file =	 rs.getString("file");
			 String title= rs.getString("title");
			 String img = rs.getString("img");
			 int id = rs.getInt("id");
			 x.setTitle(title);
			 x.setDescription(desciption);
			x.setFile(file);
			x.setImg(img);
			x.setId(id);
			 result.add(x);
		
		}
		return result;
	}
	public void addBooklove(int iduser,int idproduct) throws SQLException
	{	Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		String qr= "INSERT INTO `product_select` (`id_product`, `id_user`) VALUES ('"+idproduct+"', '"+iduser+"')";
		System.out.println(qr);
		st.executeUpdate(qr);
	}


}
