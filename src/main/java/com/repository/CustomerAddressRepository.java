package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.CustomerAddressEntity;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddressEntity, Integer> {
	// In the repository interface
	List<CustomerAddressEntity> findAllByCustomerId(Integer customerId);

}
