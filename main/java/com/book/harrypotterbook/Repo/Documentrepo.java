package com.book.harrypotterbook.Repo;

import com.book.harrypotterbook.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Documentrepo extends JpaRepository<Document,Long> {
}
