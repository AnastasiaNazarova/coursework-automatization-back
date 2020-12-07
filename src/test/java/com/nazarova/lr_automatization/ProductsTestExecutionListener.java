package com.nazarova.lr_automatization;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ProductsTestExecutionListener implements TestExecutionListener {

    @Override
public void afterTestClass(TestContext testContext) {
    final ApplicationContext applicationContext = testContext.getApplicationContext();
    final EntityManagerFactory entityManagerFactory = applicationContext
            .getBean(EntityManagerFactory.class);
    final EntityManager entityManager = entityManagerFactory.createEntityManager();
    final EntityTransaction transaction   = entityManager.getTransaction();
    transaction.begin();
    entityManager.createNativeQuery("DROP SCHEMA IF EXISTS test_scheme CASCADE;").executeUpdate();
    transaction.commit();
}
}
