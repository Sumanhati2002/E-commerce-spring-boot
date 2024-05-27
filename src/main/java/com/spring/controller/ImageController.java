package com.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.Image;
import com.spring.service.ImageService;

@Controller
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@PostMapping("/processimage")
	public String admin(@ModelAttribute Image image) {
		System.out.println(image);
		if (imageService == null) {
            throw new IllegalStateException("ImageService is not initialized");
        }
		else if (image.getAdminEmail().equals("admin@gmail.com") && image.getAdminPassword().equals("admin") ) {
			imageService.createImage(image);
		}
		
		return "admin";
	}
	 @DeleteMapping("image/{id}")
	    public ResponseEntity<String> deleteImage(@PathVariable("id") Integer id){
		 imageService.deleteImage(id);
	        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	    }
	 
		/*
		 * @GetMapping("image/{id}") public ResponseEntity<Image>
		 * getImageUrl(@PathVariable("id") Integer id){ Image img =
		 * imageService.getUrl(id); return new ResponseEntity<>(img, HttpStatus.OK); }
		 */
}
