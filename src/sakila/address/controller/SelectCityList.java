package sakila.address.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.*;
import java.util.*;

@WebServlet("/address/selectCityList")
public class SelectCityList extends HttpServlet {
	private CityDao cityDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		cityDao = new CityDao();
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int rowPerPage = 10;
		
		List<City> list = cityDao.selectCityList(currentPage, rowPerPage);
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		response.getWriter().write(jsonList);
	}

}
