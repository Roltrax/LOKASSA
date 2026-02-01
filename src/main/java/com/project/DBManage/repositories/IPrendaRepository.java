package com.project.DBManage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.DBManage.models.PrendaModel;

@Repository
public interface IPrendaRepository extends JpaRepository<PrendaModel, Long> {
}
