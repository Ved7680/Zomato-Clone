package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "customer_address")
public class CustomerAddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer addressId;
	String title;
	String addressLine;
	Integer pincode;
	Float latitude;
	Float longitude;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	CustomerEntity customer;
}
