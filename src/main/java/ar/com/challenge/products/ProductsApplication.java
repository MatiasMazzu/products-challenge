package ar.com.challenge.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ProductsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

}
