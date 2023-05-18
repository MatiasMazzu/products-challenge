package ar.com.challenge.products;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import ar.com.challenge.products.controller.impl.ProductsControllerImpl;
import ar.com.challenge.products.entity.Product;

@SpringBootTest
public class ProductsApplicationTests {
    
    @Autowired
    ProductsControllerImpl controller;
    
    @Test
    void testController() {
    	//Get all products without initiating the DB
    	assertEquals(HttpStatus.NO_CONTENT, controller.getAllProducts("").getStatusCode());
        
        //Create new product test
        Product product = new Product(1L,"Bebida alcoholica de origen natural",
                777,850.00, "Fernet Branca 1lt");
        controller.createProduct(product);

        //Get product ID which does NOT exist
        assertEquals(HttpStatus.NOT_FOUND, controller.getProductById((long) 777).getStatusCode());

        //Get product ID which exist
        assertEquals(HttpStatus.OK, controller.getProductById(1L).getStatusCode());
        
        //Create new product
        assertEquals(HttpStatus.OK, controller.createProduct(product).getStatusCode());
        
        //Update product
        assertEquals(HttpStatus.OK, controller.updateProduct(1L, product).getStatusCode());
        
    }
}