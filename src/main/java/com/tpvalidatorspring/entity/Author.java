package com.tpvalidatorspring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "The lastname should not be null or empty")
    @Size(max = 50, message = "The lastname should have a max of 50 characters")
    private String lastName;

    @NotEmpty(message = "The firstname should not be null or empty")
    @Size(max = 50, message = "The firstname should have a max of 50 characters")
    private String firstName;

    @Pattern(regexp = "^[a-z0-9]@editor\\.com$")
    @NotEmpty(message = "The email should not be null or empty and finish by @editor.com")
    private String email;

    @OneToMany(mappedBy = "author")
    private Set<Book> books = new LinkedHashSet<>();


}
