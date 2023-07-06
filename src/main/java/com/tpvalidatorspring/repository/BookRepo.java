package com.tpvalidatorspring.repository;

import com.tpvalidatorspring.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {
}
