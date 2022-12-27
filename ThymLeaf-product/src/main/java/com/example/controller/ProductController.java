package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class ProductController {
    private IProductService productService = new ProductService();
    @GetMapping("/")
    private String showAllProduct(Model model){
        if(!ProductService.init){
            ProductService.init = true;
            ProductService.listProduct = new HashMap<>();
            productService.createProduct(1, new Product(1, "Television", 2000, "television", "Factory"));
        }
        model.addAttribute("products",productService.findAllProduct());
        return "index";
    }
    @GetMapping("/create")
    private String createProduct(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    private String createProduct(Product product){
        product.setId((int) (Math.random()*1000+1000));
        productService.createProduct(product.getId(),product);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    private String editProduct(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findProductById(id));
        return "edit";
    }
    @PostMapping("/edit")
    private String editProduct(Product product){
        productService.updateProduct(product.getId(), product);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    private String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
    @GetMapping("/search")
    private String searchProduct(@RequestParam String name, Model model){
        System.out.println(name);
        HashMap<Integer,Product> products = productService.findProductByName(name);
        model.addAttribute("products",products);
        model.addAttribute("search",name);
        return "search";
    }
}
