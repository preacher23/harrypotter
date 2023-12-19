package com.book.harrypotterbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Librarydto {
    private String id;
    private String book_name;
    private int aisle;
    private String author;
    private String isbn;
}
