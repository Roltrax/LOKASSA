package com.project.DBManage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.DBManage.models.PrendaVarianteModel;

@Repository
public interface IPrendaVarianteRepository extends JpaRepository<PrendaVarianteModel, Long> {
}
