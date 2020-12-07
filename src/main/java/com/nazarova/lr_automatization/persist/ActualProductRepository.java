package com.nazarova.lr_automatization.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface ActualProductRepository extends JpaRepository<ActualProduct, String> {
    @SuppressWarnings("UnusedReturnValue")
    @Procedure(procedureName = "create_view")
    Boolean create_view();

}
