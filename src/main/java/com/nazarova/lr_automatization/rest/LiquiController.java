package com.nazarova.lr_automatization.rest;

import com.nazarova.lr_automatization.persist.ActualProduct;
import com.nazarova.lr_automatization.persist.Product;
import com.nazarova.lr_automatization.service.ActualProductService;
import com.nazarova.lr_automatization.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LiquiController {
    private final ProductService productService;
    private final ActualProductService actualProductService;

    @Autowired
    public LiquiController(ProductService productService, ActualProductService actualProductService) {
        this.productService = productService;
        this.actualProductService = actualProductService;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> all() {
        return productService.getAll();
    }

    @GetMapping(value = "/overdue", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> overdue() {
        return productService.getOverdue();
    }

    @GetMapping(value = "/actual", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ActualProduct> actual() {
        return actualProductService.getAll();
    }
}
