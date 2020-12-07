
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

        final List<Product> all = productService.getAll();
        assertEquals(3, all.size());
       // assertEquals(3, all.);
      /*  Optional<Product> productOptional = all.stream()
                .filter(product -> product.getId() == 1)
                .findFirst();
        assertTrue(productOptional.isPresent());

        final Product product = productOptional.get();
        assertEquals(1, product.getId());
      */

    }

    @Test
    @DatabaseSetup(value = "/com/nazarova/lr_automatization/DataTest.xml")
    public void actual() {

        final List<ActualProduct> all = actualProductService.getAll();
        assertEquals(2, all.size());

       /* Optional<ActualProduct> actualProductOptional = all.stream()
                .filter(actualProduct -> actualProduct.getName_product()
                        .equals("product1"))
                .findFirst();
        assertTrue(actualProductOptional.isPresent());

        ActualProduct actualProduct = actualProductOptional.get();
        assertEquals(110, actualProduct.getPrice_one());
        assertEquals(550, actualProduct.getRevenue());
        assertEquals(440, actualProduct.getProfit());*/
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
