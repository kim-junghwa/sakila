package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import sakila.db.DBHelper;

public class CityDao {
	public List<City> selectCityList(int currentPage, int rowPerPage) {
		List<City> list = new ArrayList<City>();
		int beginRow = (currentPage - 1) * rowPerPage;
		/*
		 * city INNER JOIN country
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT c.city_id, c.city, ct.country_id, ct.country, c.last_update " + 
				"FROM city c INNER JOIN country ct " + 
				"ON c.country_id = ct.country_id " + 
				"ORDER BY ct.country_id DESC " + 
				"LIMIT ?,?";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				City city = new City();
				city.setCityId(rs.getInt("c.city_id"));
				city.setCity(rs.getString("c.city"));
				city.setCountry(new Country());
				city.getCountry().setCountryId(rs.getInt("ct.country_id"));
				city.getCountry().setCountry(rs.getString("ct.country"));
				city.setLastUpdate(rs.getString("c.last_update"));
				list.add(city);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	public int selectCityCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) cnt FROM city";
		
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
	
	public void insertCity(City city) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO city(city, country_id, last_update) values(?,?,now())";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, city.getCity());
			stmt.setInt(2, city.getCountry().getCountryId());
			rs = stmt.executeQuery();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(rs, stmt, conn);
		}
	}
	
	public List<City> selectCityListByCountry(int countryId) {
		List<City> list = new ArrayList<City>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT city_id, city FROM city WHERE country_id = ?";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, countryId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				City city = new City();
				city.setCityId(rs.getInt("city_id"));
				city.setCity(rs.getString("city"));
				list.add(city);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
}
