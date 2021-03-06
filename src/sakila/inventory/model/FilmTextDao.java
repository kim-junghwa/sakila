package sakila.inventory.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.db.DBHelper;

public class FilmTextDao {
	public int selectFilmTextCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) cnt FROM film_text";
		
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
}
