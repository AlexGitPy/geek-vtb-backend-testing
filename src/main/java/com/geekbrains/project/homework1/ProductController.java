package com.geekbrains.project.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:8189/app/products
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    @GetMapping("/filtered")
    public List<Product> getProductsMoreThan(Integer min_price) {
        return productRepository.requestProductsMoreThan(min_price);
    }

    @GetMapping("/expensive")
    public List<Product> getAllExpensiveProducts() {
        return productRepository.requestAllExpensiveProducts();
    }

    @GetMapping("/delete/{id}")
    public void deleteByIdFromProducts(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("{id}/change_title")
    public void changeTitleById(@PathVariable Long id, @RequestParam String title) {
        Product p = productRepository.findById(id).get();
        p.setTitle(title);
        productRepository.save(p);
    }
}
