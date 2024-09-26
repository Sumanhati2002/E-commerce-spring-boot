package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	
	private String imageName;
	private String imageUrl;
	private String price;
	
	@ManyToOne
	@JsonIgnore
	private Customer customer;
	
	@Override
    public String toString() {
        return "CartItem{id=" + cartId + /* other fields */ + '}';
    }
}
