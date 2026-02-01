package com.project.DBManage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.DBManage.repositories.ICategoryRepository;
import com.project.DBManage.models.CategoryModel;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    // GET: todas las categorías
    public ArrayList<CategoryModel> getCategorias() {
        return (ArrayList<CategoryModel>) categoryRepository.findAll();
    }

    // GET: categoría por id
    public Optional<CategoryModel> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // POST: crear categoría
    public CategoryModel createCategory(CategoryModel category) {
        return categoryRepository.save(category);
    }

    // PUT: actualizar categoría
    public CategoryModel updateById(CategoryModel request, Long id) {
        CategoryModel category = categoryRepository.findById(id).get();
        category.setNombre(request.getNombre());
        category.setDescripcion(request.getDescripcion());
        return categoryRepository.save(category);
    }

    // DELETE: eliminar categoría
    public String deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
            return "Categoría eliminada";
        } catch (Exception e) {
            return "Categoría no eliminada";
        }
    }
}
