package com.spring.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.entity.CartItem;

public interface CartRepo extends JpaRepository<CartItem, Integer>{

	@Query("from CartItem as c where c.customer.customerId = :customerId")
	public List<CartItem> findCartItemByCustomer(@Param("customerId") Integer customerId);
}
