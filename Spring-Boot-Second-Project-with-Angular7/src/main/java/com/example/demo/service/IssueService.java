package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.Dto.IssueDto;
import com.example.demo.entity.Issue;
import com.example.demo.util.TPage;

public interface IssueService {

	
	IssueDto save(IssueDto issue);
	
	IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);

    IssueDto update(Long id, IssueDto project);
}
