package sakila.address.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import sakila.address.model.*;

@WebServlet("/address/insertAddress")
public class InsertAddress extends HttpServlet {
	private AddressDao addressDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		addressDao = new AddressDao();
		Address address = new Address();
		
		address.setAddress(request.getParameter("address"));
		address.setAddress2(request.getParameter("address2"));
		address.setDistrict(request.getParameter("district"));
		address.getCity().setCity(request.getParameter("cityId"));
		address.setPostalCode(request.getParameter("postalCode"));
		address.setPhone(request.getParameter("phone"));
		
		//System.out.println("address : " + address + "\naddress2 : " + address2 + "\ndistrict : " + district + "\ncityId : " + cityId + "\npostalCode : " + postalCode + "\nphone : " + phone);
		
		try {
			addressDao.insertAddress(address, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(address);
		response.getWriter().write(jsonStr);
		
	}

}
