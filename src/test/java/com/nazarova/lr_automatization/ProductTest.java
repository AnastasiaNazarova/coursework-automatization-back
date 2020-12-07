
package com.nazarova.lr_automatization;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.nazarova.lr_automatization.persist.ActualProduct;
import com.nazarova.lr_automatization.persist.Product;
import com.nazarova.lr_automatization.service.ActualProductService;
import com.nazarova.lr_automatization.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.net.MalformedURLException;
import java.util.List;
;

import static org.junit.jupiter.api.Assertions.assertEquals;



@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({  TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        ProductsTestExecutionListener.class,
        DbUnitTestExecutionListener.class })

@Transactional
public class ProductTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ActualProductService actualProductService;


    @Test
    @DatabaseSetup(value = "/com/nazarova/lr_automatization/DataTest.xml")
    public void all()  {

        List<Product> all = productService.getAll();
        assertEquals(3, all.size());


        Product product = all.get(0);
        assertEquals(0, product.getId());
        assertEquals("product1", product.getName_product());
        assertEquals(10, product.getShelf_life());

    }

    @Test
    @DatabaseSetup(value = "/com/nazarova/lr_automatization/DataTest.xml")
    public void actual() {

        final List<ActualProduct> all = actualProductService.getAll();
        assertEquals(2, all.size());

        ActualProduct actualProduct = all.get(0);
        assertEquals("product1", actualProduct.getName_product());
        assertEquals(50, actualProduct.getRevenue());

    }

    @Test
    @DatabaseSetup(value = "/com/nazarova/lr_automatization/DataTest.xml")
    public void overdue() {
        List<Product> overdue = productService.getOverdue();
        assertEquals(1, overdue.size());

        Product overdueProduct = overdue.get(0);
        assertEquals(1, overdueProduct.getId());
        assertEquals("product2", overdueProduct.getName_product());
        assertEquals(5, overdueProduct.getShelf_life());
    }
}
