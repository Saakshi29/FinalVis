package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO class has CRUD + query methods
public class ProductDAO {
	public int save(Product toBeSaved) {
		// insert
		int generatedId = 0;
		try (Connection c = JdbcUtil.getconnection()) {
			// Statement s = c.createStatement();
			/*
			 * String query = "Insert into product values(" + toBeSaved.getId() + ",'" +
			 * toBeSaved.getName() + "'," + toBeSaved.getPrice() + "," + toBeSaved.getQoh()
			 * + ")";
			 */
			String query = "insert into product(product_name,product_price,product_qoh) values(?,?,?)";
			// PreparedStatement s = c.prepareStatement(query);
			PreparedStatement s = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			// s.setInt(1, toBeSaved.getId());
			s.setString(1, toBeSaved.getName());
			s.setFloat(2, toBeSaved.getPrice());
			s.setInt(3, toBeSaved.getQoh());
			// s.executeUpdate(query);
			s.executeUpdate();
			ResultSet keys = s.getGeneratedKeys();
			keys.next();
			generatedId = keys.getInt(1);
			System.out.println("inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return generatedId;
	}

	public List<Product> findAll() throws SQLException {

		List<Product> res = new ArrayList<Product>();

		try (Connection c = JdbcUtil.getconnection()) {

			ResultSet rs;
			Statement s = c.createStatement();
			String query = "Select * from product";
			rs = s.executeQuery(query);
			while (rs.next()) {
				Product aProduct = mapRow(rs);
				res.add(aProduct);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public Product findById(int id) {
		Product p = null;
		try (Connection c = JdbcUtil.getconnection()) {
			PreparedStatement s = c.prepareStatement("select * from product where product_id=?");
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				p = mapRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// readbased on id
		return p;
	}

	private Product mapRow(ResultSet rs) throws SQLException {
		Product p;
		p = new Product();
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setPrice(rs.getFloat(3));
		p.setQoh(rs.getInt(4));
		return p;
	}

	public void remove(int id) {// delete
		// Product p = null;
		try (Connection c = JdbcUtil.getconnection()) {
			PreparedStatement s = c.prepareStatement("delete from product where product_id=?");
			s.setInt(1, id);
			s.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Product updated) { // update

		try (Connection c = JdbcUtil.getconnection()) {
			PreparedStatement s = c.prepareStatement("update product set product_name=?, product_where product_id=?");
		//	s.setInt(1, id);
			s.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
