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

@WebServlet("/address/selectCountryList")
public class SelectCountryList extends HttpServlet {
	private CountryDao countryDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("success");
		response.setContentType("application/json;charset=UTF-8");
		//System.out.println(request.getParameter("currentPage"));
		countryDao = new CountryDao();

		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int rowPerPage = 10;
		
		List<Country> list = countryDao.selectCountryList(currentPage, rowPerPage);
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		//System.out.println(jsonList);
		response.getWriter().write(jsonList);
	}
}