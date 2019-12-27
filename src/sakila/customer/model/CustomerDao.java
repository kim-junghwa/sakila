package sakila.customer.model;

import java.sql.*;
import sakila.db.DBHelper;

public class CustomerDao {
	public int selectCustomerCount() {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) cnt FROM customer";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(rs, stmt, conn);
		}
		
		return count;
	}
	
	public void insertCustomer(Customer customer, Connection conn) throws Exception {
		PreparedStatement stmt = null;
		
		String sql = "insert into customer(store_id, first_name, last_name, email, address_id, active, create_date, last_update) " + 
					 "values(?,?,?,?,?,1,now(),now());";
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, customer.getStore().getStoreId());
		stmt.setString(2, customer.getFirstName());
		stmt.setString(3, customer.getLastName());
		stmt.setString(4, customer.getEmail());
		stmt.setInt(5, customer.getAddress().getAddressId());
		stmt.executeUpdate();
	}
}
