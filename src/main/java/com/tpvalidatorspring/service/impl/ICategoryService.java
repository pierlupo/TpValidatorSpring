package com.tpvalidatorspring.service.impl;

import com.tpvalidatorspring.entity.Category;
import com.tpvalidatorspring.repository.CategoryRepo;
import com.tpvalidatorspring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ICategoryService implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category, Integer id) {
        Optional<Category> category1 = categoryRepo.findById(id);
        if(category1.isPresent()){
            Category category2 = category1.get();
            category2.setCategoryTitle(category.getCategoryTitle());
            category2.setDescription(category.getDescription());
            category2.setBooks(category.getBooks());
            return categoryRepo.save(category2);
        }
        return null;
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepo.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepo.findAll();
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryRepo.deleteById(id);
    }
}
