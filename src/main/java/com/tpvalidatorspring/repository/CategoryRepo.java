package com.tpvalidatorspring.repository;

import com.tpvalidatorspring.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
