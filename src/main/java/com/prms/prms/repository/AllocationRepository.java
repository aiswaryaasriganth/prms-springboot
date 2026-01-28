package com.prms.prms.repository;

import com.prms.prms.entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

	boolean existsByEmployeeId(int i);

}
