package com.example.demo.service.Imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.ProjectDto;
import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository,
			ModelMapper modelMapper) {
		this.projectRepository = projectRepository;
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProjectDto save(ProjectDto project) {
		Project projectChecked = projectRepository.getByProjectCode(project.getProjectCode());
		if (projectChecked != null) {
			throw new IllegalArgumentException("Project code already exist");
		}
		Project p = modelMapper.map(project, Project.class);
		p = projectRepository.save(p);
		project.setId(p.getId());
		return project;
	}

	@Override
	public ProjectDto getById(Long id) {

		Project p = projectRepository.getOne(id);
		ProjectDto pDto = modelMapper.map(p, ProjectDto.class);
		return pDto;
	}

	@Override
	public Page<Project> getAllPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return projectRepository.findAll(pageable);
	}

	@Override
	public ProjectDto getByProjectCode(String projectCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getByProjectCodeContains(String projectCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Project project) {
		return null;
	}
	@Override
	public Boolean delete(Long id) {
		Project projectDb=projectRepository.getOne(id);
		if(projectDb==null) {
			throw new IllegalArgumentException("Project does not exist id : "+id);
			//return false;
		}
		
		projectRepository.deleteById(id);
		return true;
	}
	@Override
	public ProjectDto update(Long id, ProjectDto project) {
		Project projectDb=projectRepository.getOne(id);
		if(projectDb==null) {
			throw new IllegalArgumentException("Project does not exist id : "+id);
		}

//		Project projectChecked = projectRepository.getByProjectCode(project.getProjectCode());
//		if (projectChecked != null && projectChecked.getId() != projectDb.getId()) {
//			throw new IllegalArgumentException("Project code already exist");
//		}
		
		Project projectChecked = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
		if(projectChecked != null) {
			throw new IllegalArgumentException("Project code already exist");
		}
		
		projectDb.setProjectCode(project.getProjectCode());
		projectDb.setProjectName(project.getProjectName());
		projectDb = projectRepository.save(projectDb);
		project= modelMapper.map(projectDb, ProjectDto.class);
		return project;
	}

}
