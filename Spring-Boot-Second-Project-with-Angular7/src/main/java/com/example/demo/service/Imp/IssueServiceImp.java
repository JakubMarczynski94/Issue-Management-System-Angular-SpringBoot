package com.example.demo.service.Imp;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.IssueDto;
import com.example.demo.entity.Issue;
import com.example.demo.repository.IssueRepository;
import com.example.demo.service.IssueService;
import com.example.demo.util.TPage;
@Service
public class IssueServiceImp implements IssueService {

	private final IssueRepository issueRepository;
	private final ModelMapper modelMapper;
	
	
	@Autowired
	public IssueServiceImp (IssueRepository issueRepository,ModelMapper modelMapper){
		this.issueRepository=issueRepository;
		this.modelMapper=modelMapper;
	}
	
	 
	@Override
	public IssueDto save(IssueDto issue) {
		if(issue.getDate()==null) {
			throw new IllegalArgumentException("Issue Code cannot be null");
		}
		Issue issueDb=modelMapper.map(issue, Issue.class);
		issueDb = issueRepository.save(issueDb);
		issue= modelMapper.map(issueDb, IssueDto.class);
		return issue;
	}

	@Override
	public IssueDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		Page<Issue> pageIssue=issueRepository.findAll(pageable);
		TPage<IssueDto> tpage=new TPage<IssueDto>();
		IssueDto[] dtos= modelMapper.map(pageIssue.getContent(), IssueDto[].class);
		tpage.setStat( pageIssue,Arrays.asList(dtos));
		return tpage;
	}

	@Override
	public Boolean delete(IssueDto issue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssueDto update(Long id, IssueDto project) {
		// TODO Auto-generated method stub
		return null;
	}

}
