package com.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.entity.Customer;
import com.org.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// need to inject the Customer DAO

	//@Autowired
	//private ICustotmerDAO customerDAO;
	 @Autowired 
	 private CustomerService service;

	@GetMapping("/list")
	public String list(Model model) {
		// get the customers from DAO
		List<Customer> customers = service.list();
		model.addAttribute("customers", customers);
		return "customer/list";
	}

	@RequestMapping("/openAddForm")
	public String open(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/add";
	}

	@PostMapping("/saveOrUpdate")
	public String add(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "customer/add";
		}
		 boolean isCustSaved=service.add(customer);
		model.addAttribute("isCustSaved", isCustSaved);

		return "redirect:/customer/list";
	}

	@GetMapping("/openUpdateForm")
	public String openUpdateForm(@RequestParam("customerId") int id, Model model) {
		Customer customer = service.findNow(id);
		model.addAttribute("customer", customer);
		return "customer/add";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {
		service.deleteNow(id);
		return "redirect:/customer/list";
	}

	@GetMapping("/search")
	public String search(@RequestParam("searchParams") String searchParams, Model model) {
		List<Customer> customers = service.search(searchParams);
		model.addAttribute("customers", customers);
		return "customer/list";
	}

}
