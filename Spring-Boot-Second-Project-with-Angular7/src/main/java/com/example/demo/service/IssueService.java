package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Issue;

public interface IssueService {

	
	Issue save(Issue issue);
	
	Issue getById(Long id);

    Page<Issue> getAllPageable(Pageable pageable);

    Boolean delete(Issue issue);

    Issue update(Long id, Issue project);
}
