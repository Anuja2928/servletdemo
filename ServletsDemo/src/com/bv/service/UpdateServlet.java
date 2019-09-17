package com.bv.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bv.handler.ProductDBHandler;
import com.bv.model.Products;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        
        String productname=request.getParameter("productname");
        String manufacturername= request.getParameter("manufacturername"); 
        Double price = Double.parseDouble(request.getParameter("price")) ;

    	Products products = new Products();
		products.setProductname(productname);
		products.setManufacturername(manufacturername);
		products.setPrice(price);
      
		 products =ProductDBHandler.getProductById(id);
		int status=ProductDBHandler.updateProducts(products);
        
		if(status> 0 )
		{
			response.sendRedirect("UpdateServlet2");
		}
		else
		{
			out.print(" in valid");
		}
        
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        
        
        
	}

}
