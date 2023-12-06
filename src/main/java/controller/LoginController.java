package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.catagory;
import model.bean.product;
import model.bo.BO;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnlogin").equals("btnlogin"))
		{
			String username= request.getParameter("username");
			String password= request.getParameter("password");
			BO qlsvbo= new BO();
			int check;
			try {
				check = qlsvbo.checklogin(username, password);
				if(check>0)
				{
					String fullname= qlsvbo.layfullnamebyemail(username);
					 HttpSession session = request.getSession();
					 session.setAttribute("username", fullname);
					if(check ==1 )
					{
						BO bo = new BO();
						ArrayList<product> x=null;
						ArrayList<catagory> y=null;
						
						try {
							x = bo.layraProduct();
							y=bo.layradanhmuc();
							request.setAttribute("product", x);
							request.setAttribute("catagory", y);
							
							String destination = "/index.jsp";	
							RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
							rd.forward(request, response);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					else {
						response.sendRedirect("./indexAdmin.jsp?opt=2");
					}
				}
				else {
					response.sendRedirect("./login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
