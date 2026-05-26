package com.semicore.jpademo.services.impl;

import com.semicore.jpademo.models.Product;
import com.semicore.jpademo.repositories.ProductRepository;
import com.semicore.jpademo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public String addProduct(Product product) {
        Product product1 = productRepository.save(product);
        return product1.getId() != null ? "Product added successfully" : "Failed to add product";
    }

    @Override
    public String modifyProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            productRepository.save(existingProduct);
            return "Product modified successfully";
        }
        return "Product not found";
    }

    @Override
    public String deleteProduct(String productid) {
        if (productRepository.existsById(Long.parseLong(productid))) {
            productRepository.deleteById(Long.parseLong(productid));
            return "Product deleted successfully";
        }
        return "Product not found";
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findProductsByNameAndCategory(String name, String category) {
        return productRepository.findByNameAndCategory(name, category);
    }

    @Override
    public List<Product> getProductWithNameAndPriceGreaterThan(String name, double price) {
        //return productRepository.getProductWithNameAndPriceGreaterThan(name, price);
        return productRepository.getProductWithNameAndPriceGreaterThanNative(name, price);
    }
}
