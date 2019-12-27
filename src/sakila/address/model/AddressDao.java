package sakila.address.model;

import java.sql.*;
import java.util.*;
import sakila.db.DBHelper;

public class AddressDao {
	public int selectAddressCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) cnt FROM address";
		
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
	
	public List<Address> selectAddressList(){
		List<Address> list = new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT a.address_id, a.postal_code, c.country, ct.city, a.address, a.address2, a.district, a.last_update " + 
				"FROM address a inner join city ct inner join country c " + 
				"ON a.city_id = ct.city_id AND ct.country_id = c.country_id " + 
				"ORDER BY c.country DESC " + 
				"LIMIT 100;";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				Address address = new Address();
				address.setAddressId(rs.getInt("a.address_id"));
				address.setPostalCode(rs.getString("a.postal_code"));
				address.setCity(new City());
				address.getCity().setCity(rs.getString("ct.city"));
				address.getCity().setCountry(new Country());
				address.getCity().getCountry().setCountry(rs.getString("c.country"));
				address.setAddress(rs.getString("a.address"));
				address.setAddress2(rs.getString("a.address2"));
				address.setDistrict(rs.getString("a.district"));
				address.setLastUpdate(rs.getString("a.last_update"));
				list.add(address);
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
	
	public int insertAddress(Address address, Connection conn) throws Exception {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int addressId = 0;
		//System.out.println("address : " + address + "\naddress2 : " + address2 + "\ndistrict : " + district + "\ncityId : " + cityId + "\npostalCode : " + postalCode + "\nphone : " + phone);

		String sql = "INSERT INTO address(city_id, postal_code, phone, address, address2, district, last_update) " + 
					 "values(?,?,?,?,?,?,now());";
		
		//방금 insert된 행의 프라이머리 키값 받아오기
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, address.getCity().getCityId());
		stmt.setString(2, address.getPostalCode());
		stmt.setString(3, address.getPhone());
		stmt.setString(4, address.getAddress());
		stmt.setString(5, address.getAddress2());
		stmt.setString(6, address.getDistrict());
		stmt.executeUpdate();
		//프라이머리키 값 받기
		rs = stmt.getGeneratedKeys();
		
		if(rs.next()) {
			addressId = rs.getInt(1);
		}
		
		return addressId;
	}
	
}
