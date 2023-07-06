package com.tpvalidatorspring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "The categoryName should not be null or empty")
    @Size(max = 10, message = "The lastname should have a max of 50 characters")
    private String categoryTitle;

    @Size(max = 200, message = "The description should have a max of 200 characters")
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Book> books = new LinkedHashSet<>();
}
