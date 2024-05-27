package com.spring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Image;
@Repository
public interface ImageRepo extends CrudRepository<Image, Integer>{

//	Image getImageUrl(Integer id);

}
