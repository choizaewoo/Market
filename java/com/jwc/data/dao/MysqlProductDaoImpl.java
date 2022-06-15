package com.jwc.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jwc.domain.model.Product;

public class MysqlProductDaoImpl implements ProductDao {

	public MysqlProductDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실");
		}
	}

	@Override
	public List<Product> getAll() {
		List<Product> results = new ArrayList<>();

		String sql = "SELECT * FROM product";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "root",
				"kopo42"); Statement stmt = conn.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					String id = rs.getString(COLUMN_ID);
					String name = rs.getString("p_name");
					int unitPrice = rs.getInt("p_unitPrice");
					String description = rs.getString("p_description");
					String category = rs.getString("p_category");
					String manufacturer = rs.getString("p_menufacturer");
					Long unitsInStock = rs.getLong("p_unitInStock");
					String condition = rs.getString("p_condition");

					Product product = new Product(id, name, unitPrice);
					product.setDescription(description);
					product.setCategory(category);
					product.setManufacturer(manufacturer);
					product.setUnitsInStock(unitsInStock);
					product.setCondition(condition);

					results.add(product);

				}
			}

		} catch (SQLException e) {
			// 에러가 났을 때 원인을 찾을 수 있다. e.getMessege()
			throw new IllegalStateException("DB 연결 실패" + e.getMessage());
		}

		return results;
	}

	@Override
	public void insert(Product product) {
		// PreparedStatement 동적 쿼리 생성 :insert, update, delete 여러번 할 때 고속이다!
		String sql = "INSERT INTO product VALUES( ?,?,?,?,?,?,?,?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "root",
				"kopo42"); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getUnitPrice());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getCategory());
			stmt.setString(6, product.getManufacturer());
			stmt.setLong(7, product.getUnitsInStock());
			stmt.setString(8, product.getCondition());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("insert 실패" + e.getMessage());
		}

	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		String sql = "UPDATE ? SET p_name=?,p_unitPrice= ?,p_description = ?,p_category = ?,p_menufacturer = ?,p_unitInStock = ?,p_condition = ?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "root",
				"kopo42"); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, TABLE_NAME);
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getUnitPrice());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getCategory());
			stmt.setString(6, product.getManufacturer());
			stmt.setLong(7, product.getUnitsInStock());
			stmt.setString(8, product.getCondition());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("insert 실패" + e.getMessage());
		}

	}

	@Override
	public void delete(Product product) {
		String sql = "DELETE FROM ? WHERE p_id=?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "root",
				"kopo42"); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, TABLE_NAME);
			stmt.setString(2, product.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("insert 실패" + e.getMessage());
		}

	}
}
