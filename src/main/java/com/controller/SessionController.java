package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CustomerAddressEntity;
import com.entity.CustomerEntity;

import com.entity.RestaurantEntity;
import com.repository.CustomerAddressRepository;
import com.repository.CustomerRepository;
import com.repository.RestaurantRepository;

@RestController
public class SessionController {
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	RestaurantRepository restaurantRepo;
	
	@Autowired
	CustomerAddressRepository customerAddressRepo;
	
	@PostMapping("/customersignup")
	public CustomerEntity customerSignup(@RequestBody CustomerEntity customerEntity)
	{
		customerRepo.save(customerEntity);
		return customerEntity;
	}
	
	@PostMapping("/addcustomeraddress")
	public CustomerAddressEntity addCustomerAddress(@RequestBody CustomerAddressEntity customerAddressEntity)
	{
		customerAddressRepo.save(customerAddressEntity);
		return customerAddressEntity;
	}
	
	@PostMapping("/addrestaurant")
	public RestaurantEntity addRestaurant(@RequestBody RestaurantEntity restaurantEntity)
	{
		restaurantRepo.save(restaurantEntity);
		return restaurantEntity;
	}
	
	@GetMapping("/listcustomers")
	public List<CustomerEntity> getAllCustomers(){
		List<CustomerEntity> customer_list = customerRepo.findAll();
		return customer_list;
	}
	
	@GetMapping("/listrestaurants")
	public List<RestaurantEntity> getAllRestaurants(){
		List<RestaurantEntity> restaurant_list = restaurantRepo.findAll();
		return restaurant_list;
	}
	
	@GetMapping("/listrestaurants/{pincode}")
	public List<RestaurantEntity> getRestaurantByPincode(@PathVariable("pincode") Integer pincode){
		List<RestaurantEntity> restaurant_pincode = restaurantRepo.findAllByPincode(pincode);
		if (restaurant_pincode.isEmpty()) {
			return null;
		} else {
			return restaurant_pincode;
		}
	}
	
	
	@GetMapping("/listcustomeraddress/{customerId}")
	public List<CustomerAddressEntity> getCustomerAddress(@PathVariable("customerId") Integer customerId){
		List<CustomerAddressEntity> customerAddresses = customerAddressRepo.findAllByCustomerId(customerId);
	    if (customerAddresses.isEmpty()) {
	        return null; // Return an empty list if no addresses are found
	    } else {
	        return customerAddresses; // Return the list of addresses
	    }
	}
	
}
