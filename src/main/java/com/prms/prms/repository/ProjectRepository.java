package com.prms.prms.repository;

import com.prms.prms.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    boolean existsByProjectName(String projectName);
}
