package com.book.harrypotterbook;

import com.book.harrypotterbook.Repo.LibraryRepo;
import com.book.harrypotterbook.controller.Librarycontroller;
import com.book.harrypotterbook.entity.Library;
import com.book.harrypotterbook.service.Libraryservice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@SpringBootTest
class HarrypotterbookApplicationTests {
@Mock
	Libraryservice libraryservice;
@Autowired
	Librarycontroller librarycontroller;
@Mock
	LibraryRepo libraryRepo;
	@Test
	void contextLoads() {
	}
//   @Test
//	void test(){
//		int multiply(int a,int b){
//			return a+b;
//	   }
//	   //multiply(2,3)-->6
//   }

	@Test
	void testbuildid(){
		String zman = libraryservice.buildid("34", "zman");
		Assertions.assertEquals(zman,"old34zman");

	}

	@Test
	void addbook(){
		Library lib=buildlibrary();
		Mockito.when(libraryservice.buildid(lib.getIsbn(),lib.getId())).thenReturn("1fy");
		Mockito.when(libraryservice.checkbookalreadyexists("1")).thenReturn(true);
		//ResponseEntity addbook = librarycontroller.addbook(buildlibrary());
		//Assertions.assertNotNull(addbook);

	}
	Library buildlibrary(){
		Library library=new Library();
		library.setId("1");
		library.setAuthor("gokul");
		library.setAisle(23);
		library.setBook_name("hello");
		library.setIsbn("fy");
		return library;
	}
}
