package com.vitasoft.controllers.admin;

import com.vitasoft.model.Product;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@PostMapping("/save-product")
	public ModelAndView uploadProduct(HttpServletRequest servletRequest, @ModelAttribute Product product, Model model) {
		
		List<MultipartFile> files = product.getImages();
		List<String> fileNames = new ArrayList<String>();
		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {
				
				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				
//				File imageFile = new File(resourceLoader.getResource("")., fileName);
				try {
					multipartFile.transferTo(new File("/Users/roman/Desktop/springcourse/src/main/webapp/WEB-INF/images/" + fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return new ModelAndView("viewProductDetail")
			.addObject("product", product);
	}
	
	@GetMapping(value = "/product-input-form")
	public ModelAndView inputProduct(Model model) {
		return new ModelAndView("productForm")
			.addObject("product", new Product());
	}
}
