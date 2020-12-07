package com.nazarova.lr_automatization.service;

import com.nazarova.lr_automatization.persist.Product;
import com.nazarova.lr_automatization.persist.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    private final ProductRepository productRepository;


    public List<Product> getAll() {
        return productRepository.getAllBy();
    }

    public List<Product> getOverdue() {
        return productRepository.findOverdueProducts();
    }

}







