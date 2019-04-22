package com.vitasoft.model;

import java.io.Serializable;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 74458L;
	
	private String name;
	private String description;
	private List<MultipartFile> images;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<MultipartFile> getImages() {
		return images;
	}
	
	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
}
