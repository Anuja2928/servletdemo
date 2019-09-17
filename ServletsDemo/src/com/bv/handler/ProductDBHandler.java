package com.bv.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bv.connection.DBConnect;
import com.bv.model.Products;

public class ProductDBHandler {
	
	
	public static int addProduct(Products products)
	{ int status=0;
		String sql = "insert into products(productname,manufacturername,price) values (?,?,?)";
	
		Connection connection=DBConnect.getConnection();
		try
		{  
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setString(1, products.getProductname());
			ps.setString(2, products.getManufacturername());
			ps.setDouble(3, products.getPrice());
			status= ps.executeUpdate();
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	
	public static int updateProducts(Products products)
	{
		int status=0;
		String sql="update products set Productname=?, manufacturername=?,price =?  where id=?";
		Connection connection=DBConnect.getConnection();
		try
		{
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setString(1, products.getProductname());
			ps.setString(2, products.getManufacturername());
			ps.setDouble(3, products.getPrice());
			ps.setInt(4, products.getId());
			status= ps.executeUpdate();
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return status;
	}
	
	
	
	public static int deleteProducts(int id)
	{
		int status=0;
		String sql="delete from products where id =?";
		Connection connection=DBConnect.getConnection();
		try
		{
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setInt(1,id);
			status= ps.executeUpdate();
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return status;
		
	}
	
	public static List<Products> getAllProducts()
	{  List<Products> productList =new ArrayList<>();
		String sql="select * from products";
		
	
		Connection connection=DBConnect.getConnection();
		try
		{
			Statement stmt =connection.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next())
			{
				Products product = new Products();
				product.setId(rs.getInt("id"));
				product.setProductname(rs.getString(2));
				product.setManufacturername(rs.getString(3));
				product.setPrice(rs.getDouble(4));
				productList.add(product);
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return productList;
	}
	
	
	public static Products getProductById(int id) {

		Products product = new Products();
		String sql = "select * from products where id = ?";

		Connection connection = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				product.setId(rs.getInt("id"));
				product.setProductname(rs.getString("productname"));
				product.setManufacturername(rs.getString("manufacturername"));
				product.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
}
