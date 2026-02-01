package com.project.DBManage.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.project.DBManage.services.CategoryService;
import com.project.DBManage.models.CategoryModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // GET: todas las categorías
    @GetMapping
    public ArrayList<CategoryModel> getAllCategories() {
        return categoryService.getCategorias();
    }

    // GET: categoría por id
    @GetMapping("/{id}")
    public Optional<CategoryModel> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // POST: crear categoría
    @PostMapping
    public CategoryModel createCategory(@RequestBody CategoryModel category) {
        return categoryService.createCategory(category);
    }

    // PUT: actualizar categoría
    @PutMapping("/{id}")
    public CategoryModel updateCategory(@RequestBody CategoryModel request, @PathVariable Long id) {
        return categoryService.updateById(request, id);
    }

    // DELETE: eliminar categoría
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }
}
