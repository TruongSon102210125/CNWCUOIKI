package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.product;
import model.bo.BO;

/**
 * Servlet implementation class AddBookLove
 */
@WebServlet("/AddBookLove")
public class AddBookLove extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id_product")!=null)
		{
			BO bo = new BO();
			ArrayList<product> list= null;
			 HttpSession session = request.getSession(false);
			 int iduser = (int)session.getAttribute("iduser") ;
			 String id_product=request.getParameter("id_product");
			 int id_product1=Integer.parseInt(id_product);
			 try {
				
				bo.addBooklove(iduser, id_product1);
				 list=bo.layrabook(iduser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 request.setAttribute("product", list);
				String destination = "/mybook.jsp";	
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			 
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
