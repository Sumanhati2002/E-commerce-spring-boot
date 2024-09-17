package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Image;

public interface ImageRepo extends JpaRepository<Image, Integer>{

	Image findByImageName(String imageName);
}
