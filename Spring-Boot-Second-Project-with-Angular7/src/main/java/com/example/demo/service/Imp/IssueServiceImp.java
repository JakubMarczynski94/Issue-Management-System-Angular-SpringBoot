package com.example.demo.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Issue;
import com.example.demo.repository.IssueRepository;
import com.example.demo.service.IssueService;

public class IssueServiceImp implements IssueService {

	private final IssueRepository issueRepository;

	@Autowired
	public IssueServiceImp (IssueRepository issueRepository){
		this.issueRepository=issueRepository;
	}
	
	
	@Override
	public Issue save(Issue issue) {
		// TODO Auto-generated method stub
		return issueRepository.save(issue);
	}

	@Override
	public Issue getById(Long id) {
		// TODO Auto-generated method stub
		return issueRepository.getOne(id);
	}

	@Override
	public Page<Issue> getAllPageable(Pageable pageable) {

		return issueRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(Issue issue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Issue update(Long id, Issue project) {
		// TODO Auto-generated method stub
		return null;
	}

}
