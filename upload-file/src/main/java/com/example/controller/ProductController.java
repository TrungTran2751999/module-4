package com.example.controller;

import com.example.model.Product;
import com.example.model.ProductForm;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {
    private final IProductService productService = new ProductService();

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    private String index(Model model){
        List<Product> listProduct = productService.findAll();
        model.addAttribute("products",listProduct);
        return "index";
    }
    @GetMapping("/create")
    private String createProduct(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "create";
    }
    @PostMapping("/save")
    private String createProduct(@ModelAttribute("productForm") ProductForm productForm, Model model){
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(),
                                      productForm.getDescription(), fileName);
        productService.save(product);
//        ModelAndView modelAndView = new ModelAndView("/create");
//        modelAndView.addObject("productForm",productForm);
//        modelAndView.addObject("message", "Create Product Falled");
        return "redirect:/";
    }
}
