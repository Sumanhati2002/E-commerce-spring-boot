package com.spring.service;

import com.spring.entity.Image;

public interface ImageService {

	Image createImage(Image image);
	void deleteImage(Integer id);

}
