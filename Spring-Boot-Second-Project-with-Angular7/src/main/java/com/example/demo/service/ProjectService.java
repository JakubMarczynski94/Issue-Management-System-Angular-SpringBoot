package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Issue;
import com.example.demo.entity.Project;
import com.example.demo.entity.User;

public interface ProjectService {

	
	Project save(Project project);
	
	Project getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);
    
    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Boolean delete(Project project);

    Project update(Long id, Project project);
}
