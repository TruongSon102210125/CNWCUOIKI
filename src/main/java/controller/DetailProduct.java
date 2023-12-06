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

import model.bean.product;
import model.bo.BO;

/**
 * Servlet implementation class DetailProduct
 */
@WebServlet("/DetailProduct")
public class DetailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
		BO bo = new BO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id_product")!=null)
		{
			System.out.println("vao trang detai;");
			ArrayList<product> list= null;
			int id_product= Integer.parseInt(request.getParameter("id_product"));
			try {
				list= bo.getdetailProduct(id_product);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("product", list);
			String destination = "/detailProduct.jsp";	
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
