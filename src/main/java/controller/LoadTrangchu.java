package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.catagory;
import model.bean.product;
import model.bo.BO;

/**
 * Servlet implementation class LoadTrangchu
 */
@WebServlet("/LoadTrangchu")
public class LoadTrangchu extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("opt").equals("1"))
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
		}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
