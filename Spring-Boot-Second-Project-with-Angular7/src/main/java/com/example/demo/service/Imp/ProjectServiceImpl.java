package com.example.demo.service.Imp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository,UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository= userRepository;
    }
	
	
	@Override
	public Project save(Project project) {
		if(project.getProjectCode()==null) {
			throw new IllegalArgumentException("Project Code cannot be null");
		}
		return projectRepository.save(project);
	}

	@Override
	public Project getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Project> getAllPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getByProjectCode(String projectCode) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project update(Long id, Project project) {
		// TODO Auto-generated method stub
		return null;
	}

}
