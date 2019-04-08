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
import com.example.demo.util.ApiPaths;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL,description ="Project APIs")
public class ProjectController {

	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ApiOperation(notes="Get By Id operation for project",value="Get By Id operation for project",response=ProjectDto.class)
	public ResponseEntity<ProjectDto> getById(@PathVariable(name="id",required=true) Long id) {
		ProjectDto projectDto=projectService.getById(id);
		return ResponseEntity.ok(projectDto);
	}
	
	@PostMapping
	@ApiOperation(value="Create operation for project",response=ProjectDto.class)
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){
		return ResponseEntity.ok(projectService.save(project));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Update for project",response=ProjectDto.class)
	//@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<ProjectDto> updateProject(@PathVariable(name="id",required=true) Long id,@Valid @RequestBody ProjectDto project){
		return ResponseEntity.ok(projectService.update(id, project));
	}
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete operation for project",response=Boolean.class)
	public ResponseEntity<Boolean> deleteProject(@PathVariable(name="id", required=true) Long id) {
		
		return ResponseEntity.ok(projectService.delete(id));
	}
	
}
