package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.IssueHistory;

public interface IssueHistoryRepository  extends JpaRepository<IssueHistory, Long>  {
	
	List<IssueHistory> getByIssueIdOrderById(Long id);
	
}
