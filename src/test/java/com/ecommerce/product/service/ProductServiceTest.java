package com.ecommerce.product.service;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    // Test for successfully creating a product
    @Test
    public void shouldCreateProductSuccessfully() {
        // Arrange
        Product product = new Product("Laptop", "High-end gaming laptop", 1500.0, 10);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Act
        Product createdProduct = productService.createProduct(product);

        // Assert
        assertEquals("Laptop", createdProduct.getName());
        assertEquals(1500.0, createdProduct.getPrice());
        verify(productRepository, times(1)).save(product);
    }

    // Test for retrieving a product by ID
    @Test
    public void shouldRetrieveProductById() {
        // Arrange
        Product product = new Product("Laptop", "High-end gaming laptop", 1500.0, 10);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        // Act
        Product foundProduct = productService.getProductById(1L);

        // Assert
        assertEquals("Laptop", foundProduct.getName());
        verify(productRepository, times(1)).findById(1L);
    }

    // Test for product not found
    @Test
    public void shouldThrowExceptionWhenProductNotFound() {
        // Arrange
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> productService.getProductById(1L));
        verify(productRepository, times(1)).findById(1L);
    }

    // Test for checking product stock
    @Test
    public void shouldCheckProductStock() {
        // Arrange
        Product product = new Product("Laptop", "High-end gaming laptop", 1500.0, 10);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        // Act
        boolean isInStock = productService.isProductInStock(1L);

        // Assert
        assertTrue(isInStock);
        verify(productRepository, times(1)).findById(1L);
    }
}
