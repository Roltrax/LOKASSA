package com.project.DBManage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.DBManage.models.TallaModel;

@Repository
public interface ITallaRepository extends JpaRepository<TallaModel, Long> {
}
