package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "customers")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer customerId;
	String firstName;
	String lastName;
	String email;
	String password;
	String profilePicPath;
	String otp;
	String gender;
	Integer bornYear;
	String contactNum;
	
	@OneToMany(mappedBy = "customer")
	List<CustomerAddressEntity> address;
}
