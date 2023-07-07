package com.tpvalidatorspring.controller;


import com.tpvalidatorspring.entity.Category;
import com.tpvalidatorspring.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v3")
public class CategoryController {

    @Autowired
    private CategoryService ICategoryService;

    @PostMapping("/save")
    ResponseEntity<String> createCategory(@Valid @RequestBody Category category){

        ICategoryService.createCategory(category);

        return ResponseEntity.ok("Category created");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity(ICategoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(ICategoryService.getCategoryById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable(name = "id") int id){

        Category categoryResponse = ICategoryService.updateCategory(category, id);

        return new ResponseEntity(categoryResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") int id){

        ICategoryService.deleteCategoryById(id);

        return new ResponseEntity<>("Category deleted successfully.", HttpStatus.OK);
    }
}
