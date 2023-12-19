package com.book.harrypotterbook.controller;

import com.book.harrypotterbook.Repo.LibraryRepo;
import com.book.harrypotterbook.dto.Librarydto;
import com.book.harrypotterbook.entity.Addresponse;
import com.book.harrypotterbook.entity.Library;
import com.book.harrypotterbook.entity.Product;
import com.book.harrypotterbook.service.Libraryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Librarycontroller {
    @Autowired
    LibraryRepo libraryRepo;
    @Autowired
    Libraryservice libraryservice;


    @PostMapping("/add")
    public ResponseEntity<Object> addbook(@RequestBody Librarydto librarydto) {
        //library.setId(library.getIsbn()+library.getAisle());
        String id = libraryservice.buildid(librarydto.getId(), librarydto.getIsbn());//mock
        Addresponse addresponse = new Addresponse();
        if (libraryservice.checkbookalreadyexists(id)) {//mock
            addresponse.setMsg("already");
            addresponse.setId(id);
            return new ResponseEntity<>(addresponse, HttpStatus.OK);
        } else {
            //convert userdto  to entity
            Library library= new Library(
                    librarydto.getId(),
                    librarydto.getBook_name(),
                    librarydto.getAisle(),
                    librarydto.getAuthor(),
                    librarydto.getIsbn()
            );
          Library library1 = libraryRepo.save(library);//mock
          Librarydto l=new Librarydto(
                  library1.getIsbn(),
                  library1.getBook_name(),
                  library1.getAisle(),
                  library1.getAuthor(),
                  library1.getId()
          );
            addresponse.setId(id);
            addresponse.setMsg("yes success");
            return new ResponseEntity<>( HttpStatus.OK);

        }
    }

    @GetMapping("/get/{id}")
    public Library getbook(@PathVariable(value = "id") String id){
        return libraryRepo.findById(id).get();
    }

//    @GetMapping("/get/author")
//    public Library getbookbyauthor(@RequestParam(value = "author")String author){
//        return libraryRepo.findById(id).get();
//    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Library> putbook(@PathVariable(value = "id") String id, @RequestBody Library library){
        Library library1 = libraryRepo.findById(id).get();
        library1.setAuthor(library.getAuthor());
        library1.setAisle(library.getAisle());
        library1.setBook_name(library.getBook_name());
        libraryRepo.save(library1);
        return new ResponseEntity<Library>(library1,HttpStatus.CREATED);
    }

    @GetMapping("/{id}/{id2}")
    public String pathvariable(@PathVariable(value = "id")String name,@PathVariable(value = "id2") String name2){
        return "the string"+name+name2;
    }
    @GetMapping("/reqpar")
    public String requestparam(@RequestParam String name,@RequestParam Integer id){
        return "reuest param"+name+id;
    }
     @GetMapping("/lib/{id}/{aisle}/{author}")
    public ResponseEntity<Library>pathvariabledemo(@PathVariable String id,@PathVariable("aisle") int aisle2,@PathVariable String author){
         System.out.println(id);
         Library library=new Library();
         library.setId(id);
         library.setAuthor(author);
         library.setAisle(aisle2);
         return ResponseEntity.ok(library);
    }
    //localhost:8080/lib?id=1&author=gokul
    @GetMapping("/lib")
    public ResponseEntity<Library> requestparamdemo(
            @RequestParam(name="id") String id,
            @RequestParam(name = "author") String author){
        System.out.println(id);
        System.out.println(author);
        Library library=new Library();
        library.setId(id);
        library.setAuthor(author);
        return new ResponseEntity<>(library, HttpStatus.CREATED);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchproduct(@RequestParam(name = "query") String query){
        //return ResponseEntity.ok(libraryservice.searchproducts(query));
        return new ResponseEntity<>(libraryservice.searchproducts(query),HttpStatus.OK);
    }
}