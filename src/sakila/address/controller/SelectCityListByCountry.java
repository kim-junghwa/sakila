package sakila.address.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.*;
import sakila.address.model.*;

@WebServlet("/address/selectCityListByCountry")
public class SelectCityListByCountry extends HttpServlet {
	private CityDao cityDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		cityDao = new CityDao();
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		//System.out.println("Servlet countryId : " + countryId);
		List<City> list = cityDao.selectCityListByCountry(countryId);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		response.getWriter().write(jsonStr);
	}

}
