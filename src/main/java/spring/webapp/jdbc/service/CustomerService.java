package spring.webapp.jdbc.service;

import java.util.List;

import spring.webapp.jdbc.entities.Customer;

public interface CustomerService {

	public List<Customer> listCustomer();
	public Customer findCustomerById(int id);
	public boolean isDeleteCustomer(int id);
	public boolean isInsertCustomer(Customer dto);
	public boolean isUpdaateCuatomer(Customer dto);
	public List<Customer> search(String keyword);
	public int countRecordCustomer();
}
