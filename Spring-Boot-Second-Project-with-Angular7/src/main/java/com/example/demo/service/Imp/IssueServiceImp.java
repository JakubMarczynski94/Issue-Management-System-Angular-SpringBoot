package com.example.demo.service.Imp;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.IssueDetailDto;
import com.example.demo.Dto.IssueDto;
import com.example.demo.Dto.IssueHistoryDto;
import com.example.demo.entity.Issue;
import com.example.demo.entity.Project;
import com.example.demo.repository.IssueRepository;
import com.example.demo.service.IssueHistoryService;
import com.example.demo.service.IssueService;
import com.example.demo.util.TPage;
@Service
public class IssueServiceImp implements IssueService {

	private final IssueRepository issueRepository;
	private final ModelMapper modelMapper;
	private final IssueHistoryService issueHistoryService;
	
	
	@Autowired
	public IssueServiceImp (IssueRepository issueRepository,ModelMapper modelMapper,IssueHistoryService issueHistoryService){
		this.issueRepository=issueRepository;
		this.modelMapper=modelMapper;
		this.issueHistoryService=issueHistoryService;
	}
	
	 
	@Override
	public IssueDto save(IssueDto issue) {
//		Date date = new Date();
//		issue.setDate(date);
		if(issue.getDate()==null) {
			throw new IllegalArgumentException("Issue Date cannot be null");
		}
		Issue issueDb=modelMapper.map(issue, Issue.class);
		issueDb = issueRepository.save(issueDb);
		issue.setId(issueDb.getId());
		return issue;
	}

	@Override
	public IssueDto getById(Long id) {
		Issue issue=issueRepository.getOne(id);
		if(issue==null) {
			throw new IllegalArgumentException("Issue does not exist");
		}
		IssueDto issueDto=modelMapper.map(issue,IssueDto.class);
		return issueDto;
	}
//    @Transactional
//    public IssueDetailDto update(Long id, IssueUpdateDto issue) {
//        Issue issueDb = issueRepository.getOne(id);
//        User user = userRepository.getOne(issue.getAssignee_id());
//        issueHistoryService.addHistory(id,issueDb);
//
//        issueDb.setAssignee(user);
//        issueDb.setDate(issue.getDate());
//        issueDb.setDescription(issue.getDescription());
//        issueDb.setDetails(issue.getDetails());
//        issueDb.setIssueStatus(issue.getIssueStatus());
//        issueDb.setProject(projectRepository.getOne(issue.getProject_id()));
//        issueRepository.save(issueDb);
//        return getByIdWithDetails(id);
//    }
//    public IssueDetailDto getByIdWithDetails(Long id) {
//        Issue issue = issueRepository.getOne(id);
//        IssueDetailDto detailDto = modelMapper.map(issue, IssueDetailDto.class);
//        List<IssueHistoryDto> issueHistoryDtos = issueHistoryService.getByIssueId(issue.getId());
//        detailDto.setIssueHistories(issueHistoryDtos);
//        return detailDto;
//    }

	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		Page<Issue> pageIssue=issueRepository.findAll(pageable);
		TPage<IssueDto> tpage=new TPage<IssueDto>();
		IssueDto[] dtos= modelMapper.map(pageIssue.getContent(), IssueDto[].class);
		tpage.setStat( pageIssue,Arrays.asList(dtos));
		return tpage;
	}

	
    public List<IssueDto> getAll() {
        List<Issue> data = issueRepository.findAll();
        return Arrays.asList(modelMapper.map(data, IssueDto[].class));
    }
    
	@Override
	public Boolean delete(IssueDto issue) { 
		return null;
	}

	@Override
	public IssueDto update(Long id, IssueDto project) {
		Issue issuedb=issueRepository.getOne(id);
		if(issuedb==null) {
			throw new IllegalArgumentException("Project does not exist id : "+id);
		}
		return null;
	}
    public IssueDetailDto getByIdWithDetails(Long id) {
        Issue issue = issueRepository.getOne(id);
        IssueDetailDto detailDto = modelMapper.map(issue, IssueDetailDto.class);
        List<IssueHistoryDto> issueHistoryDtos = issueHistoryService.getByIssueId(issue.getId());
        detailDto.setIssueHistories(issueHistoryDtos);
        return detailDto;
	}

	@Override
	public Boolean delete(Long id) {
		Issue issue=issueRepository.getOne(id);
		if(issue==null) {
			throw new IllegalArgumentException("Issue does not exist id : "+id);
			
		}
		issueRepository.deleteById(id);
		return true;
	}

   
}
