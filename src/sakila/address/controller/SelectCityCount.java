package sakila.address.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import sakila.address.model.*;

@WebServlet("/address/selectCityCount")
public class SelectCityCount extends HttpServlet {
	private CityDao cityDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;UTF-8");
		
		cityDao = new CityDao();
		
		int count = cityDao.selectCityCount();
		Gson gson = new Gson();
		String jsonStr = gson.toJson(count);
		response.getWriter().write(jsonStr);
	}

}
