package com.book.harrypotterbook.service;

import com.book.harrypotterbook.Repo.LibraryRepo;
import com.book.harrypotterbook.Repo.Productrepo;
import com.book.harrypotterbook.entity.Library;
import com.book.harrypotterbook.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Libraryservice {
    @Autowired
    LibraryRepo libraryRepo;
    @Autowired
    Productrepo productrepo;
    public String buildid(String id,String isbn){
//        if (isbn.startsWith("z")){
//            return "old"+id+isbn;
//        }
        return id+isbn;
    }

    public boolean checkbookalreadyexists(String id) {
       Optional<Library> library = libraryRepo.findById(id);
       if (library.isPresent()){
           return true;
       }else {
           return false;
       }
    }

    public List<Product> searchproducts(String query){
        List<Product> searchproducts = productrepo.searchproductSql(query);
        return searchproducts;
    }


}
