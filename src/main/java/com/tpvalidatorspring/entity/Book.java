package com.tpvalidatorspring.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Title should not be null or empty")
    @Size(max = 20, message = "Title should have a max of 20 characters")
    private String title;

    @Min(value=0, message = "L'année doit être un entier positif" )
    @Max(value=2023, message = "L'année ne peut pas être supérieure à 2023" )
    private Integer publishingYear;

    @NotEmpty(message = "Category should not be null or empty")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "book_id", nullable = false)
    private Category category ;

    @NotEmpty(message = "Author should not be null or empty")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "book_id", nullable = false)
    private Author author;

}
