package com.book.harrypotterbook.Repo;

import com.book.harrypotterbook.entity.Library;
import com.book.harrypotterbook.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends JpaRepository<Library,String> {
    public List<Library> findByAisle(int aisle);
    //custom query
    @Query("select e from Library e where e.author = ?1  and e.isbn = ?2")
    Library findByJPQL(String author,String isbn);

   //customquerywithnamed
    @Query("select e from Library e where e.author =:author  and e.isbn =:isbn")
    Library findByJPQLnamed(@Param("author") String author,@Param("isbn") String isbn);
   //nativequery
    @Query(value="select * from Library e where e.author = ?1  and e.isbn = ?2",nativeQuery = true)
    Library findByNativeQuery(String author,String isbn);

}
