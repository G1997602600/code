package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.dto.Cart;

public class CartDAO {

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "ROOT";

	public String AddToCart(Cart m) {
		Connection con = null;
		PreparedStatement ps = null;
		String query = "INSERT cart VALUES (?,?,?,?,?)";

		try {
			Class.forName(path);
			try {
				con = DriverManager.getConnection(url, username, password);
				ps = con.prepareStatement(query);
				ps.setInt(1, m.getId());
				ps.setString(2, m.getEmail());
				ps.setString(3, m.getUsername());
				ps.setString(4, m.getPassword());
				ps.setString(5, m.getAdress());
				int a = ps.executeUpdate();
				if (a != 0)
					return "Cart Added Sucessfully";
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Something went Wrong";
	}

	public String UpdateCart(Cart m) {
		Connection con = null;
		PreparedStatement ps = null;
		String query = "update cart set adress=?, email=?,username=? ,password=? where id=?";

		try {
			Class.forName(path);
			try {
				con = DriverManager.getConnection(url, username, password);
				ps = con.prepareStatement(query);

				ps.setInt(5, m.getId());
				ps.setString(2, m.getEmail());
				ps.setString(3, m.getUsername());
				ps.setString(4, m.getPassword());
				ps.setString(1, m.getAdress());
				int a = ps.executeUpdate();
				if (a != 0) {
					return "Cart updated Sucessfully";
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Something Went Wrong ";
	}

	public String DeleteCart(int id) {
		PreparedStatement ps = null;
		Connection con = null;
		String query = "DELETE FROM cart WHERE id=? ";
		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int a = ps.executeUpdate();

			if (a == 1) {
				return "Cart delted  sucessfully";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "SomeThing Went Wrong";
	}

	public Cart GetCart(int id) {
		ResultSet a = null;
		Connection con = null;
		PreparedStatement ps = null;
		String query = "SELECT * FROM cart WHERE id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			a = ps.executeQuery();
			if (a != null) {
				Cart p = new Cart();
				while (a.next()) {
					Cart m = new Cart();
					ps.setInt(1, m.getId());
					ps.setString(2, m.getEmail());
					ps.setString(3, m.getUsername());
					ps.setString(4, m.getPassword());
					ps.setString(5, m.getAdress());
				}
				return p;

			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		 
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
