package com.book.harrypotterbook.Repo;

import com.book.harrypotterbook.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface Productrepo extends JpaRepository<Product,Long> {

    //returns the found product entry by using its name as search
    //criteria.if no product entry is found,this method returns null

    public List<Product> findByName(String name);

    //returns an oprional which contains the found product entry by using its id as search criteria
    //if no product is found this method returns an empty optional

    Optional<Product> findById(Long id);

    //returns the found list of product entries whose title or description is given as method parameter
    //if no product entries is found ,this method returns an empty list

    List<Product> findByNameOrDescription(String name,String description);

    //returns the found list of product entries whose title and description is given as method parameter
    //if no product entries is found ,this method returns an empty list

    List<Product> findByNameAndDescription(String name,String description);

   //return distinct  product entry whose name is given in method parameter
    //if no product entry is found,this method returns null
    Product findDistinctByName(String name);
    //return the product whose price is greater than given price as method parameter

    List<Product> findByPriceGreaterThan(BigDecimal price);

   //return the filtered the product records that matches the given text
    List<Product>findByNameContaining(String name);
   //return products based on sql condition
    List<Product>findByNameLike(String name);
    //return list of products based on multiple values
    List<Product>findByNameIn(List<String> names);

    List<Product>findFirst2ByOrderByNameAsc();
    //returns a product whose datecreated between start date and end date
    List<Product> findByDatecreatedBetween(LocalDateTime startdate,LocalDateTime enddate);
    @Query("SELECT p FROM Product p WHERE "+ "p.name LIKE CONCAT('%',:query,'%')"+
                   "Or p.description LIKE CONCAT('%',:query,'%')")//jpql query
    List<Product> searchproducts(String query);


    @Query(value = "SELECT * FROM Product p WHERE "+ "p.name LIKE CONCAT('%',:query,'%')"+
            "Or p.description LIKE CONCAT('%',:query,'%')",nativeQuery = true)//native query
    List<Product> searchproductSql(String query);
}
