package com.semicore.jpademo.controllers;

import com.semicore.jpademo.models.Product;
import com.semicore.jpademo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products") // Base path for all endpoints in this controller
public class ProductController {

    // This class is annotated with @RestController, which indicates that it is a Spring MVC controller
    // that handles HTTP requests and returns responses in a RESTful manner. It is responsible for defining endpoints for managing products, such as retrieving product information, adding new products, modifying existing products, and deleting products.
    // It is a basic implementation of a RESTful API for product management in an e-commerce application with CRUD operations.

    @Autowired // This annotation is used to inject the ProductService dependency into the ProductController.
    // It allows Spring to manage the lifecycle of the ProductService
    // and provide an instance of it when needed.
    ProductService productService;

    //@RequestMapping(path = "/products", method = RequestMethod.GET, produces = "application/json")
    //@RequestMapping(path = "/all", method = RequestMethod.GET, produces = "application/json")
    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    //@RequestMapping(path = "/products/{productid}", method = RequestMethod.GET, produces = "application/json")
    // @RequestMapping(path = "/{productid}", method = RequestMethod.GET, produces = "application/json")
    @GetMapping("/productid/{productid}")
    public Product findProductById(@PathVariable(name = "productid") String id) {
        // Implementation to get a product by ID
        return productService.findProductById(id);
    }


    @GetMapping("/name/{productname}")
    public List<Product>  findProductByName(@PathVariable(name = "productname") String name) {
        // Implementation to get a product by name
        return productService.findProductByName(name);
    }

    @GetMapping("/category/{productcategory}")
    public List<Product> findProductsByCategory(@PathVariable(name = "productcategory") String category) {
        // Implementation to get products by category
        return productService.findProductsByCategory(category);
    }

    //@RequestMapping(path = "/products/add", method = RequestMethod.POST, consumes = "application/json")
    //@RequestMapping(path = "/add", method = RequestMethod.POST, consumes = "application/json")
    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        // Implementation to add a new product
        String resultFromService = productService.addProduct(product);
        return  resultFromService;
    }

    //@RequestMapping(path = "/products/modify", method = RequestMethod.PUT, consumes = "application/json")
    //@RequestMapping(path = "/modify", method = RequestMethod.PUT, consumes = "application/json")
    @PutMapping("/modify")
    public String modifyProduct(@RequestBody Product product) {
        // Implementation to modify an existing product
        return productService.modifyProduct(product);
    }

    //@RequestMapping(path = "/products/delete/{id}", method = RequestMethod.DELETE)
    //@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/delete/{productid}")
    public String deleteProduct(@PathVariable String productid) {
        // Implementation to delete a product by ID
        return productService.deleteProduct(productid);
    }

    @GetMapping("/search/{name}/{category}")
    public List<Product> findProductsByNameAndCategory(@PathVariable String name, @PathVariable String category) {
        // Implementation to get products by name and category
        return productService.findProductsByNameAndCategory(name, category);
    }

    @GetMapping("/search/nameandprice/{name}/{price}")
    public List<Product> getProductWithNameAndPriceGreaterThan(@PathVariable String name, @PathVariable double price) {
        // Implementation to get products with name and price greater than specified value
        return productService.getProductWithNameAndPriceGreaterThan(name, price);
    }

    @GetMapping("/search/nameandpricerange/{name}/{lower}/{upper}")
    public List<Product> getProductWithNameAndPriceRange(@PathVariable String name, @PathVariable double lower, @PathVariable double upper) {
        // Implementation to get products with name and price in the specified range
        return productService.getProductWithNameAndPriceRange(name, lower, upper);
    }

}
