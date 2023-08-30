package com.superprice.service;

import com.superprice.model.Product;
import com.superprice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.superprice.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

	public Product updateProduct(Long id, Product productDetails) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		return productRepository.save(product);
	}
}
