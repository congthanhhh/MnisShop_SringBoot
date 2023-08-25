package com.thanh.mnisShop.rest;

import com.thanh.mnisShop.model.Category;
import com.thanh.mnisShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/categories")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getOne(@PathVariable("id") String id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        Category category1 = categoryService.create(category);
        if (category1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(category1, HttpStatus.CREATED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") String id, @RequestBody Category category) {
        Category category1 = categoryService.update(id, category);
        if (category1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(category1);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
