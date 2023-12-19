package com.book.harrypotterbook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "library1")
public class Library {
    @Id
    private String id;
    private String book_name;
    private int aisle;
    private String author;
    private String isbn;
}
