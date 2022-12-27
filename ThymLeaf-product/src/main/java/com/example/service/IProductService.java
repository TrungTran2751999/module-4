package com.example.service;

import com.example.model.Product;

import java.util.HashMap;

public interface IProductService {
    HashMap<Integer, Product> findAllProduct();
    Product findProductById(int id);
    void createProduct(int i, Product product);
    void deleteProduct(int id);
    void updateProduct(int id, Product product);
    boolean getInit();
    void setInit(boolean init);
    HashMap<Integer, Product> findProductByName(String name);
}
