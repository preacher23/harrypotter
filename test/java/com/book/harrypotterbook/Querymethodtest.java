package com.book.harrypotterbook;

import com.book.harrypotterbook.Repo.Productrepo;
import com.book.harrypotterbook.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class Querymethodtest {
    @Autowired
    Productrepo productrepo;

    @Test
    void findbyname(){
        List<Product> gokul2 = productrepo.findByName("gokul2");
        System.out.println(gokul2.toString());
        System.out.println(gokul2.stream().findFirst());
    }

    @Test
    void findbyidmethod(){
        Product product=productrepo.findById(1L).get();
        System.out.println(product);
    }

    @Test
    void findbynameordescription(){
        List<Product> byNameOrDescription = productrepo.findByNameOrDescription("gokul2", "good2");
        System.out.println(byNameOrDescription);
    }

    @Test
    void findbynameanddescription(){
        List<Product> byNameAndDescription = productrepo.findByNameAndDescription("gokul2", "good2");
        System.out.println(byNameAndDescription);
        byNameAndDescription.stream().forEach(product -> {System.out.println(product.getId());
            System.out.println(product.getName());});
    }

   @Test
    void testdistinct(){
       Product gokul2 = productrepo.findDistinctByName("gokul2");
       System.out.println(gokul2);
       System.out.println(gokul2.getId());
   }

   @Test
    void findbypricegreatertan(){
        List<Product> products=productrepo.findByPriceGreaterThan(new BigDecimal(100));

       products.stream().forEach(product -> {System.out.println(product.getId());
           System.out.println(product.getName());});
   }

   @Test
    void findbynamecontaining(){
       List<Product> gokul2 = productrepo.findByNameContaining("gokul2");
       System.out.println(gokul2);
       gokul2.stream().forEach(product -> {System.out.println(product.getId());
           System.out.println(product.getName());});
   }

    @Test
    void findbynamelike(){
        List<Product> gokul2 = productrepo.findByNameLike("gokul2");
        System.out.println(gokul2);
        gokul2.stream().forEach(product -> {System.out.println(product.getId());
            System.out.println(product.getName());});
    }


    @Test
    void findbynamein(){
        List<Product> gokul2 = productrepo.findByNameIn(List.of("upadte product","gokul2"));
        System.out.println(gokul2);
        gokul2.stream().forEach(product -> {System.out.println(product.getId());
            System.out.println(product.getName());});
    }

    @Test
    void findFirstByOrderByNameAsc(){
        List<Product> firstByOrderByNameAsc = productrepo.findFirst2ByOrderByNameAsc();
        System.out.println(firstByOrderByNameAsc);
    }

    @Test
    void findByDateCreatedBetween(){
        //startdate
        LocalDateTime startdate=LocalDateTime.of(2023,12,18,00,02,24);
        //enddate
        LocalDateTime enddate=LocalDateTime.of(2023,12,18,23,23,05);
        List<Product> products=productrepo.findByDatecreatedBetween(startdate,enddate);
        System.out.println(products);

    }
}
