package com.geekbrains.project.homework1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where  p.price >= 100")
    List<Product> requestAllExpensiveProducts();

    List<Product> requestProductsMoreThan(Integer min_price);
}
