package com.book.harrypotterbook;

import com.book.harrypotterbook.Repo.LibraryRepo;
import com.book.harrypotterbook.entity.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class Libraryrepotest {
    @Autowired
    LibraryRepo libraryRepo;

    @Test
    void givenaislenamewhenfindbyaislethenreturnlibraryobject(){
        //given precondition or setup
        Library library=Library.builder().id("1L").aisle(23).isbn("hi000").book_name("fy").author("yes").
                build();
        libraryRepo.save(library);
        //when  action or the behaviour that are going to test
        List<Library> byAisle = libraryRepo.findByAisle(library.getAisle());
        //verify the output
        Assertions.assertNotNull(byAisle);
    }

    @Test
    void givenidwhenfindbyidthenreturnlibraryobject(){
        //given precondition or setup
        Library library=Library.builder().id("1L").aisle(23).isbn("hi000").book_name("fy").author("yes").
                build();
        libraryRepo.save(library);
        //when  action or the behaviour that are going to test
        Library library1 = libraryRepo.findById(library.getId()).get();
        //verify the output
        Assertions.assertNotNull(library1);
    }


    @Test
    void updatelibraryobject(){
        //given precondition or setup
        Library library=Library.builder().id("1L").aisle(23).isbn("hi000").book_name("fy").author("yes").
                build();
        libraryRepo.save(library);
        //when  action or the behaviour that are going to test
        Library savedlibrary1 = libraryRepo.findById(library.getId()).get();
        savedlibrary1.setAisle(24);
        Library saved = libraryRepo.save(savedlibrary1);
        //verify the output
        Assertions.assertEquals(savedlibrary1.getAisle(),saved.getAisle());
    }


    @Test
    void deletelibraryobject(){
        //given precondition or setup
        Library library=Library.builder().id("1L").aisle(23).isbn("hi000").book_name("fy").author("yes").
                build();
        Library save = libraryRepo.save(library);
        //when  action or the behaviour that are going to test
        libraryRepo.delete(save);
        Optional<Library> byId = libraryRepo.findById(save.getId());

        //verify the output
      Assertions.assertNotNull(byId);
    }

   @Test
    void customquery(){
        //given precondition or setup
        Library library=Library.builder().id("1L").aisle(23).isbn("hi000").book_name("fy").author("yes").
                build();
        Library save = libraryRepo.save(library);
        String author="yes";
        String isbn="hi000";
        //when  action or the behaviour that are going to test
        Library byJPQL = libraryRepo.findByJPQL(author, isbn);

        //verify the output
        Assertions.assertNotNull(byJPQL,"yesss");
    }


    @Test
    void customNamedquery(){
        //given precondition or setup
        Library library=Library.builder().id("1L").aisle(23).isbn("hi000").book_name("fy").author("yes").
                build();
        Library save = libraryRepo.save(library);
        String author="yes";
        String isbn="hi000";
        //when  action or the behaviour that are going to test
        Library byJPQL = libraryRepo.findByJPQL(author, isbn);

        //verify the output
        Assertions.assertNotNull(byJPQL,"yesss");
    }

    @Test
    void nativequery(){
        //given precondition or setup
        Library library=Library.builder().id("1L").aisle(23).isbn("hi000").book_name("fy").author("yes").
                build();
        Library save = libraryRepo.save(library);
        //String author="yes";
       // String isbn="hi000";
        //when  action or the behaviour that are going to test
        Library bynative = libraryRepo.findByJPQL(library.getAuthor(), library.getIsbn());

        //verify the output
        Assertions.assertNotNull(bynative,"yesss");
    }
}
