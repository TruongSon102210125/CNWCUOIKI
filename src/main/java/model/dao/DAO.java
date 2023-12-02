package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.QLSVBean;
import model.bean.catagory;

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
	public ArrayList<catagory> layradanhmuc()
	{
		ArrayList<catagory> result= new ArrayList<catagory>();
		Connection conn= DAO.connecttt();
		Statement st= conn.createStatement();
		ResultSet rs= st.executeQuery("select*from catagory");
		while (rs.next())
		{
			String id=rs.getString("id");
			String name=rs.getString("name");
			String age=rs.getString("age");
			String university=rs.getString("university");
			
			QLSVBean x= new QLSVBean();
			x.setAge(age);
			x.setName(name);
			x.setId(id);
			x.setUniversity(university);
			result.add(x);
		
		}
		return result;
	}

}
