package com.semicore.jpademo.models;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

@Entity
@Table(name = "products")
@NamedQuery(name = "Product.getProductWithNameAndPriceGreaterThan",
        query="SELECT p FROM Product p  WHERE name = :name and price > :price") // JPQL query
@NamedNativeQuery(name = "Product.getProductWithNameAndPriceGreaterThanNative",
        query="SELECT * FROM products  WHERE prod_name = :name and prod_price > :price",
resultClass = Product.class) // Native SQL query
public class Product {
        @Id
        @Column(name = "prod_id")
        private Long id;

        @Column(name = "prod_name")
        private String name;

        @Column(name = "prod_desc")
        private String description;

        @Column(name = "prod_price")
        private double price;

        @Column(name = "prod_cat")
        private String category;

        public Product() {
        }

        public Product(Long id, String name, String category, String description, double price) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.description = description;
            this.price = price;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
}
