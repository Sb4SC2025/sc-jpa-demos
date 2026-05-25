package com.semicore.jpademo.repositories;

import com.semicore.jpademo.models.Product;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByName(String name);
    List<Product> findByCategory(String category);
    List<Product> findByNameAndCategory(String name, String category);

    @Query("SELECT p FROM Product p  WHERE name = :name and price > :price") // JPQL query
    List<Product> getProductWithNameAndPriceGreaterThan(@Param("name")String name, @Param("price") double price);
}
