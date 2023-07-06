package com.tpvalidatorspring.service;



import com.tpvalidatorspring.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    Category createCategory(Category category);

    Category updateCategory(Category category, Integer id);

    Optional<Category> getCategoryById(Integer id);

    List<Category> getAllCategories();

    void deleteCategoryById(Integer id);
}
