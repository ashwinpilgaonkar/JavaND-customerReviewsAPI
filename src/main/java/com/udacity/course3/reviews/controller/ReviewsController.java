package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.service.ProductServiceImpl;
import com.udacity.course3.reviews.service.ReviewService;
import com.udacity.course3.reviews.service.ReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    // xTODO: Wire JPA repositories here

    ReviewServiceImpl reviewService;
    ProductServiceImpl productService;

    public ReviewsController(ReviewServiceImpl reviewService, ProductServiceImpl productService) {
        this.reviewService = reviewService;
        this.productService = productService;
    }

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<Review> createReviewForProduct(@PathVariable("productId") int productId, @RequestBody Review review) {



        Optional<Product> optionalProduct = productService.findProductById(productId);

        if(optionalProduct.isPresent()) {
            return new ResponseEntity<Review>(reviewService.addReviewForProduct(productId, review), HttpStatus.OK);
        } else {
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> listReviewsForProduct(@PathVariable("productId") int productId) {
        return new ResponseEntity<List<Review>>(reviewService.getReviewsByProductId(productId), HttpStatus.OK);
    }
}