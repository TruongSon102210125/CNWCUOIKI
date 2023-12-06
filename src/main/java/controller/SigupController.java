package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.BO;

/**
 * Servlet implementation class SigupController
 */
@WebServlet("/SigupController")
public class SigupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BO bo= new BO();
		  int length = 5;

	        int min = 10000; // Số nhỏ nhất có 5 chữ số
	        int max = 99999; // Số lớn nhất có 5 chữ số

	        Random random = new Random();
	        int rd= random.nextInt(max - min + 1) + min;
	        
		
		if(request.getParameter("btnRegister").equals("SignUp"))
			
		{
			int  id =rd;
			String fullname =request .getParameter("fullname");
			String email = request.getParameter("email");
			String password= request.getParameter("password");
			String phonenumber= request.getParameter("phone");
			System.out.println(id+fullname);
			int i =1;
			try {
				bo.insertUser(id, fullname, password, email, phonenumber, i);
				response.sendRedirect("./login.jsp");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
