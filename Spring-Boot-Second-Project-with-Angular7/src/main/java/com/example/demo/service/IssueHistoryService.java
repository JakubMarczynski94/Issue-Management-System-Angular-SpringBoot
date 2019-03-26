package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Issue;
import com.example.demo.entity.IssueHistory;

public interface IssueHistoryService {

	
	IssueHistory save(IssueHistory issueHistory);
	
	IssueHistory getById(Long id);

    Page<IssueHistory> getAllPageable(Pageable pageable);

    Boolean delete(IssueHistory issueHistory);

    IssueHistory update(Long id, IssueHistory issueHistory);

    List<IssueHistory> getByIssueId(Long id);

    void addHistory(Long id, Issue issue);
}
