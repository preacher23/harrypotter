package com.book.harrypotterbook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Product {
    @Id
    //@Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stock_keeping_unit",nullable = false)
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageurl;
    @CreationTimestamp
    private LocalDateTime datecreated;
    @UpdateTimestamp
    private LocalDateTime lastupdated;
}
