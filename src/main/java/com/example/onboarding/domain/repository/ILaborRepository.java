package com.example.onboarding.domain.repository;

import com.example.onboarding.domain.entity.LaborTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaborRepository extends CrudRepository<LaborTable, Integer> {
}
