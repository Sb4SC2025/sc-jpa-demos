package com.semicore.jpademo.services;

import com.semicore.jpademo.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    String addProduct(Product product);
    String modifyProduct(Product product);
    String deleteProduct(String productid);
    Product findProductById(String id);
    List<Product>  findProductByName(String name);
    List<Product> findProductsByCategory(String category);
    List<Product> findProductsByNameAndCategory(String name, String category);
    List<Product> getProductWithNameAndPriceGreaterThan(String name, double price);
    List<Product> getProductWithNameAndPriceRange(String name, double lowePrice, double upperPrice);
}
