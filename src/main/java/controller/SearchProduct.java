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

@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BO bo = new BO();
		if(request.getParameter("btnsearch").equals("Search"))
		{
			System.out.println("vao search");
			String name =request.getParameter("inputsearch");
			System.out.println(name);
			ArrayList<product> x=null;
			ArrayList<catagory> y=null;
		
			try {
				x = bo.layraProductByTitle(name);
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

}
