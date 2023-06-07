package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> findProductById(int productId);

    Product createProduct(Product product);
}
