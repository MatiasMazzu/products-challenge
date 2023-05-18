package ar.com.challenge.products.service.impl;

import java.util.List;
import java.util.Optional;

import ar.com.challenge.products.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.challenge.products.entity.Product;
import ar.com.challenge.products.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{

	private final ProductRepository repository;
	Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);

	public ProductsServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		repository.save(product);
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Product> getProductsByName(String name) {
		return  repository.findByName(name);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


}