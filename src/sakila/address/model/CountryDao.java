package sakila.address.model;

import java.util.*;
import sakila.db.DBHelper;
import java.sql.*;

public class CountryDao {
	public List<Country> selectCountryList(int currentPage, int rowPerPage) {
		List<Country> list = new ArrayList<Country>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int beginRow = (currentPage - 1) * rowPerPage;
		String sql = "SELECT country_id, country, last_update FROM country ORDER BY country_id DESC LIMIT ?,?";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Country country = new Country();
				country.setCountryId(rs.getInt("country_id"));
				country.setCountry(rs.getString("country"));
				country.setLastUpdate(rs.getString("last_update"));
				list.add(country);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				DBHelper.close(rs, stmt, conn);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public void insertCountry(Country country) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO country(country, last_update) values(?,now())";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, country.getCountry());
			stmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				DBHelper.close(null, stmt, conn);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public int selectCountryCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) cnt FROM country";
		
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
	
	public List<Country> selectCountryListAll() {
		List<Country> list = new ArrayList<Country>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT country_id, country FROM country ORDER BY country_id";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Country country = new Country();
				country.setCountryId(rs.getInt("country_id"));
				country.setCountry(rs.getString("country"));
				list.add(country);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				DBHelper.close(rs, stmt, conn);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
