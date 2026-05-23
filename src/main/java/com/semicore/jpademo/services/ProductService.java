package com.semicore.jpademo.services;

import com.semicore.jpademo.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    String addProduct(Product product);
    String modifyProduct(Product product);
    String deleteProduct(String productid);
    Product findProductById(String id);
}
