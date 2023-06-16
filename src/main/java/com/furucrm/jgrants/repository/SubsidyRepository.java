package com.furucrm.jgrants.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furucrm.jgrants.entiy.Subsidy;

@Repository
public interface SubsidyRepository extends JpaRepository<Subsidy, Long> {
}

