package com.project.DBManage.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.DBManage.models.CategoryModel;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryModel, Long> {
    Optional<CategoryModel> findByNombre(String nombre);
}
