package sakila.address.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;

import com.google.gson.Gson;

import sakila.address.model.*;

@WebServlet("/address/insertCity")
public class InsertCity extends HttpServlet {
	private CityDao cityDao;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		//System.out.println(request.getParameter("city"));
		//System.out.println(request.getParameter("countryId"));
		
		cityDao = new CityDao();
		City city = new City();
		city.setCity(request.getParameter("city"));
		city.setCountry(new Country());
		city.getCountry().setCountryId(Integer.parseInt(request.getParameter("countryId")));
		cityDao.insertCity(city);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(city);
		response.getWriter().write(jsonStr);
	}

}
