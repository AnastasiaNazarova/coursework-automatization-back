package com.nazarova.lr_automatization;

import com.nazarova.lr_automatization.persist.ActualProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializationBean {
    private final ActualProductRepository repository;

    @Autowired
    public InitializationBean(ActualProductRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        repository.create_view();
    }
}
