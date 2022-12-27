package com.example.service;

import com.example.model.Product;

import java.util.HashMap;

public class ProductService implements IProductService {
    public static HashMap<Integer,Product> listProduct;
    public static boolean init;
    @Override
    public HashMap<Integer, Product> findAllProduct() {
        return listProduct;
    }

    @Override
    public Product findProductById(int id) {
        return listProduct.get(id);
    }

    @Override
    public void createProduct(int i, Product product) {
        listProduct.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(int id) {
        listProduct.remove(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        listProduct.put(id, product);
    }

    @Override
    public boolean getInit() {
        return init;
    }

    @Override
    public void setInit(boolean init) {
        ProductService.init = init;
    }
}
