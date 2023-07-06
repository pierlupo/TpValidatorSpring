package com.tpvalidatorspring.repository;

import com.tpvalidatorspring.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Integer> {
}
