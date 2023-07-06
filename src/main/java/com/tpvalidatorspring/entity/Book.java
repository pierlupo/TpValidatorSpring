package com.tpvalidatorspring.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Min(value=0, message = "The year should be a positive integer" )
    @Max(value=2023, message = "The year should not be above 2023" )
    @Column(name="publishing_Year")
    private Integer publishingYear;

    @NotEmpty(message = "Category should not be null or empty")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "book_id", nullable = false)
    private Category category ;

    @NotEmpty(message = "Author should not be null or empty")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "id_book", nullable = false)
    private Author author;

}
