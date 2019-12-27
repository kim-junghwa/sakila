package sakila.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.*;
import sakila.business.model.*;
import sakila.customer.model.*;
import sakila.customer.service.*;

@WebServlet("/customer/insertCustomer")
public class InsertCustomer extends HttpServlet {
	
	private CustomerService customerService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		customerService = new CustomerService();
		
		Address address = new Address();
		address.setCity(new City());
		address.setAddress(request.getParameter("address"));
		address.setAddress2(request.getParameter("address2"));
		address.setDistrict(request.getParameter("district"));
		address.getCity().setCityId(Integer.parseInt(request.getParameter("cityId")));
		address.setPostalCode(request.getParameter("postalCode"));
		address.setPhone(request.getParameter("phone"));
		
		Customer customer = new Customer();
		customer.setStore(new Store());
		customer.getStore().setStoreId(Integer.parseInt(request.getParameter("storeId")));
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setEmail(request.getParameter("email"));
		
		//System.out.println(address.getAddress());
		//System.out.println(address.getAddress2());
		//System.out.println(address.getDistrict());
		//System.out.println(address.getCity().getCityId());
		//System.out.println(address.getPostalCode());
		//System.out.println(address.getPhone());
		//System.out.println(customer.getStore().getStoreId());
		//System.out.println(customer.getFirstName());
		//System.out.println(customer.getLastName());
		//System.out.println(customer.getEmail());
		
		customerService.insertCustomer(address, customer);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(null);
		response.getWriter().write(jsonStr);
		
	}
}
