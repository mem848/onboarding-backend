package com.example.onboarding.domain.repository;

import com.example.onboarding.domain.entity.MaterialTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialRepository extends CrudRepository<MaterialTable, Integer> {

}
