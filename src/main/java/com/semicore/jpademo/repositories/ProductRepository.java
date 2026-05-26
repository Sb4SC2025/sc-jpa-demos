package com.semicore.jpademo.repositories;

import com.semicore.jpademo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByName(String name);
    List<Product> findByCategory(String category);
    List<Product> findByNameAndCategory(String name, String category);

    //@Query(name = "getbyNameAndPrice", value="SELECT p FROM Product p  WHERE name = :name and price > :price") // JPQL query
   // List<Product> getProductWithNameAndPriceGreaterThan(@Param("name")String name, @Param("prodprice") double price);
    List<Product> getProductWithNameAndPriceGreaterThan(@Param("price") double price, @Param("name") String name);

    List<Product> getProductWithNameAndPriceRange(@Param("name")String name, @Param("lower") double lowerPrice, @Param("upper") double upperPrice);

   List<Product> getProductWithNameAndPriceGreaterThanNative(@Param("name")String name, @Param("price") double price);
}
