package com.example.demo.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.ProjectDto;
import com.example.demo.service.ProjectService;

@RestController
@RequestMapping("/project-rest")
public class ProjectController {

	private final ProjectService projectService;
	
	
	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ProjectDto> getById(@PathVariable(name="id",required=true) Long id) {
		
		ProjectDto projectDto=projectService.getById(id);
		System.out.println(projectDto.getId()+" "+projectDto.getProjectCode()+" "+projectDto.getProjectName());
		
		return ResponseEntity.ok(projectDto);
	}
	
	@PostMapping
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){
		return ResponseEntity.ok(projectService.save(project));
	}
	
	@PutMapping("/{id}")
	//@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<ProjectDto> updateProject(@PathVariable(name="id",required=true) Long id,@Valid @RequestBody ProjectDto project){
		return ResponseEntity.ok(projectService.update(id, project));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProject(@PathVariable(name="id", required=true) Long id) {
		
		return ResponseEntity.ok(projectService.delete(id));
	}
	
}
