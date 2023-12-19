package com.book.harrypotterbook;

import com.book.harrypotterbook.Repo.Productrepo;
import com.book.harrypotterbook.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductrepoTest {

    @Autowired
    Productrepo productrepo;
    @Test
    void savemethod(){
     //create product
        Product product=new Product();
        product.setPrice(BigDecimal.ONE);
        product.setName("gokul");
        product.setActive(true);
        product.setImageurl("produvt.png");
        product.setDescription("good");
        product.setSku("yes good");
     //save product
        Product save = productrepo.save(product);
        //display info
        System.out.println(save.toString());
    }
    @Test
    void update(){
        //find or retrive on entity by id
        long id=1L;
        Product product = productrepo.findById(1L).get();
        //update entity information
        product.setName("upadte product");
        product.setDescription("update description");
        //save updated entity
        productrepo.save(product);

        System.out.println(product);
    }
    @Test
    void findbyid(){
     Long id =5L;
        Product product = productrepo.findById(id).get();
    }
    @Test
    void saveall(){
        //create product
        Product product2=new Product();
        product2.setPrice(BigDecimal.ONE);
        product2.setName("gokul2");
        product2.setActive(true);
        product2.setImageurl("produv2t.png");
        product2.setDescription("good2");
        product2.setSku("yes good2");

        Product product3=new Product();
        product3.setPrice(BigDecimal.ONE);
        product3.setName("gokul2");
        product3.setActive(true);
        product3.setImageurl("produv2t.png");
        product3.setDescription("good2");
        product3.setSku("yes good2");

        productrepo.saveAll(List.of(product2,product3));
    }

    @Test
    void findall(){
        List<Product> all = productrepo.findAll();
        System.out.println(all);
        all.forEach(product -> System.out.println(product.getName()));
    }
    @Test
    void deletebyid(){
        Long id =11L;
        productrepo.deleteById(id);
    }

    @Test
    void count(){
        long count = productrepo.count();
        System.out.println(count);
    }
    @Test
    void existsbyid(){
        Long id=3L;
        boolean b = productrepo.existsById(id);
        System.out.println(b);

    }

    @Test
    void givenproductnamewhenfindbynamethenreturnproductobject(){
        //given precondition or setup

        //when  action or the behaviour that are going to test

        //verify the output
    }
}