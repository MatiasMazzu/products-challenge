package ar.com.challenge.products.controller.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ar.com.challenge.products.controller.ProductsController;
import ar.com.challenge.products.entity.Product;
import ar.com.challenge.products.service.impl.ProductsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsControllerImpl implements ProductsController {

	private final ProductsServiceImpl productsService;
	
	Logger logger = LoggerFactory.getLogger(ProductsControllerImpl.class);

	public ProductsControllerImpl(ProductsServiceImpl productsService) {
		this.productsService = productsService;
	}

	@Override
	@GetMapping("/products")
	public ResponseEntity<Object> getAllProducts(@RequestParam(required = false) String name) {
		logger.info("Getting the list of products");
		try {
			List<Product> products = new ArrayList<>();

			if(name == null)
				products.addAll(productsService.getAllProducts());
			else
				products.addAll(productsService.getProductsByName(name));

			if (products.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	@GetMapping("/products/order/price")
	public ResponseEntity<Object> getProductsOrderByPrice() {
		logger.info("Getting the list of products ordered by price");
		try {
			List<Product> products = new ArrayList<>(productsService.getAllProducts());

			if (products.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			else {
				return new ResponseEntity<>(products.stream()
						.sorted((Comparator.comparing(Product::getPrice)))
						.collect(Collectors.toList()),
						HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable("id") Long id) {
		logger.info("Getting product by id");
		Optional<Product> productOptional = productsService.getProductById(id);

		return productOptional.<ResponseEntity<Object>>map
				(product -> new ResponseEntity<>(product, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@Override
	@PostMapping("/products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		logger.info("Creating a new product");
		try {
			productsService.saveProduct(product);
			return new ResponseEntity<>("{\"status\":201, \"message\":\"Product created successfully\"}", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@PutMapping("/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		logger.info("Updating a product");
		Optional<Product> productOptional = productsService.getProductById(id);

		if (productOptional.isPresent()) {
			Product updatedProduct = productOptional.get();
			updatedProduct.setName(product.getName());
			updatedProduct.setDescription(product.getDescription());
			updatedProduct.setStock(product.getStock());
			updatedProduct.setPrice(product.getPrice());
			productsService.saveProduct(updatedProduct);
			return new ResponseEntity<>("{\"status\":201, \"message\":\"Product updated successfully\"}", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long id) {
		try {
			productsService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
