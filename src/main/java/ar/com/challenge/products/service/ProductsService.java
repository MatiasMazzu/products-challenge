package ar.com.challenge.products.service;

import java.util.List;
import java.util.Optional;

import ar.com.challenge.products.entity.Product;

public interface ProductsService {
	List<Product> getAllProducts();
	void saveProduct(Product product);
	Optional<Product> getProductById(Long id);
	List<Product> getProductsByName(String name);
	void deleteById(Long id);

}
