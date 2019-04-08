package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.ProjectDto;
import com.example.demo.service.Imp.ProjectServiceImpl;
import com.example.demo.util.ApiPaths;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/version")
@Api(value = ApiPaths.ProjectCtrl.CTRL,description ="Project APIs")
public class ProjectVersionApi {

	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	
	
	@RequestMapping(value="/{id}",params="version=1", method=RequestMethod.GET)
	@ApiOperation(notes="Get By Id operation for project V1",value="Get By Id operation for project",response=ProjectDto.class)
	public ResponseEntity<ProjectDto> getByIdV1(@PathVariable(name="id",required=true) Long id) {
		ProjectDto projectDto=projectServiceImpl.getById(id);
		return ResponseEntity.ok(projectDto);
	}
	
	@RequestMapping(value="/{id}", params="version=2", method=RequestMethod.GET)
	@ApiOperation(notes="Get By Id operation for project V2",value="Get By Id operation for project",response=ProjectDto.class)
	public ResponseEntity<ProjectDto> getByIdV2(@PathVariable(name="id",required=true) Long id) {
		ProjectDto projectDto=projectServiceImpl.getById(id);
		return ResponseEntity.ok(projectDto);
	}
}
