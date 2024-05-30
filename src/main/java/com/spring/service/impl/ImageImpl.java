package com.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Image;
import com.spring.repo.ImageRepo;
import com.spring.service.ImageService;

@Service
public class ImageImpl implements ImageService{

	@Autowired
	private ImageRepo imageRepo;
	
	@Override
	public Image createImage(Image image) {
		return imageRepo.save(image);
	}

	@Override
	public void deleteImage(Integer id) {
		imageRepo.deleteById(id);
	}

	@Override
	public Image findImageByName(String imageName) {
		return imageRepo.findByImageName(imageName);
	}

}
