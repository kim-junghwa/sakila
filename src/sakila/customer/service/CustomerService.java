package sakila.customer.service;

import java.sql.*;
import sakila.address.model.*;
import sakila.customer.model.*;
import sakila.db.DBHelper;

public class CustomerService {
	private AddressDao addressDao;
	private CustomerDao customerDao;
	
	public void insertCustomer(Address address, Customer customer) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			addressDao = new AddressDao();
			int addressId = addressDao.insertAddress(address, conn);
			//System.out.println("insert customer address id" + addressId);
			customer.setAddress(new Address());
			customer.getAddress().setAddressId(addressId);
			
			customerDao = new CustomerDao();
			customerDao.insertCustomer(customer, conn);
			conn.commit();
		}
		catch(Exception e) {
			try {conn.rollback();} 
			catch (SQLException e1) {}
			finally {
				DBHelper.close(null, null, conn);
			}
			e.printStackTrace();
		}
		
		
	}
}
