package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.product;
import model.bo.BO;

/**
 * Servlet implementation class MybookController
 */
@WebServlet("/MybookController")
public class MybookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id").equals("1"))
		{
			BO bo = new BO();
			ArrayList<product> list= null;
			try {
			
				 HttpSession session = request.getSession(false);
				 
			int k = (int)session.getAttribute("iduser") ;
//			int k1= Integer.parseInt(k);
				list=bo.layrabook(k);
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
