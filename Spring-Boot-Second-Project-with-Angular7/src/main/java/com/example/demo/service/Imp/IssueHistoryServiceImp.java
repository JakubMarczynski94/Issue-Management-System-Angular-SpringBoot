package com.example.demo.service.Imp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Issue;
import com.example.demo.entity.IssueHistory;
import com.example.demo.repository.IssueHistoryRepository;
import com.example.demo.service.IssueHistoryService;
@Service
public class IssueHistoryServiceImp implements IssueHistoryService{
	
	private final IssueHistoryRepository issueHistoryRepository;
	
	public IssueHistoryServiceImp(IssueHistoryRepository issueHistoryRepository) {
		this.issueHistoryRepository=issueHistoryRepository;
	}
	
	@Override
	public IssueHistory save(IssueHistory issueHistory) {
		if(issueHistory.getDate()==null) {
			throw new IllegalArgumentException("Issue cannot be null");
		}
		return issueHistoryRepository.save(issueHistory);
	}

	@Override
	public IssueHistory getById(Long id) {
		// TODO Auto-generated method stub
		return issueHistoryRepository.getOne(id);
	}

	@Override
	public Page<IssueHistory> getAllPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return issueHistoryRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(IssueHistory issueHistory) {
		issueHistoryRepository.delete(issueHistory);
		return true;
	}

	@Override
	public IssueHistory update(Long id, IssueHistory issueHistory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IssueHistory> getByIssueId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHistory(Long id, Issue issue) {
		// TODO Auto-generated method stub
		
	}

}
