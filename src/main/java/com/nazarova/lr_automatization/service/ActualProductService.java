package com.nazarova.lr_automatization.service;

import com.nazarova.lr_automatization.persist.ActualProduct;
import com.nazarova.lr_automatization.persist.ActualProductRepository;
import com.nazarova.lr_automatization.persist.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActualProductService {
    private final ActualProductRepository actualProductRepository;
    @Autowired
    public ActualProductService(ActualProductRepository repository) {
        this.actualProductRepository = repository;
    }
    public List<ActualProduct> getAll() {
        return actualProductRepository.findAll();
    }
}
