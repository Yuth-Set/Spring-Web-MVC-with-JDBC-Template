package spring.webapp.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.webapp.jdbc.entities.Customer;
import spring.webapp.jdbc.service.CustomerService;

@Controller
public class WebController {

	@Autowired
	@Qualifier("jdbctemplate")
	private CustomerService customerService;
	
	@RequestMapping(value = {"listcustomer","/"}, method = RequestMethod.GET)
	public String listCustomer(ModelMap model) {
		model.addAttribute("listCustomer", customerService.listCustomer());
		return "home/index";
	}
	
	@RequestMapping("/create")
	public String addCustome() {
		System.out.println("/create");
		return "posts/create";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String store(Customer customer){
		customerService.isInsertCustomer(customer);
		return "redirect:/";
	}
	
	@RequestMapping(value="/find/{id}")
	public String findCustomer(@PathVariable("id")int id) {
		System.out.println(customerService.findCustomerById(id));
		return "home/index";
	}
	
	@RequestMapping("/update/{id}")
	public String updateCustomer(Model model, @PathVariable("id")int id) {
		model.addAttribute("customer", customerService.findCustomerById(id));
		return "posts/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String storeUpdate(Customer customer) {
		customerService.isUpdaateCuatomer(customer);
		System.out.println(customerService.isUpdaateCuatomer(customer));
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteCustomer(@PathVariable("id")int id) {
		
		customerService.isDeleteCustomer(id);
		System.out.println(customerService.isDeleteCustomer(id));
		return "redirect:/";
	}
	
	@RequestMapping(value="/count")
	public String countCustomer() {
		System.out.println(customerService.countRecordCustomer());
		return "home/index";
	}
	
	@RequestMapping("/search")
	public String searchCustomer(Model model, @RequestParam("key") String key) {
		model.addAttribute("listCustomer", customerService.search(key));
		return "home/index";
	}
}
