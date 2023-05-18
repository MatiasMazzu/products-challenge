package ar.com.challenge.products.controller;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ar.com.challenge.products.entity.Product;

public interface ProductsController {
	ResponseEntity<Object> getAllProducts(String name);
	ResponseEntity<Object> getProductById(Long id);
	ResponseEntity<Object> createProduct(Product product);
	ResponseEntity<Object> updateProduct(Long id, Product product);
	ResponseEntity<Object> getProductsOrderByPrice();

}
