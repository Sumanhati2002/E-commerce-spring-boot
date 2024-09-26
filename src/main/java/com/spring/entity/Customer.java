package com.spring.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@NotBlank
	@Size(min = 3, max = 50)
	private String userName;
	@Email
	private String userEmail;
	@NotBlank
    @Size(min = 4)
	private String userPassword;
	
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	private List<CartItem> cartitems= new ArrayList<>();
	
	@Override
	public String toString() {
	    return "Customer{" +
	           "customerId=" + customerId +
	           ", userName='" + userName + '\'' +
	           ", userEmail='" + userEmail + '\'' +
	           ", role='" + role + '\'' +
	           '}';
	}
}
