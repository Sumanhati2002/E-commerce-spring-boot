package com.spring.repo;

import org.springframework.data.repository.CrudRepository;

import com.spring.entity.Image;

public interface ImageRepo extends CrudRepository<Image, Integer>{

}
