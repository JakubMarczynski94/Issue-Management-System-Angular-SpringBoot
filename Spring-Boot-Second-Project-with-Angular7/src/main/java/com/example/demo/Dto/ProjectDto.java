package com.example.demo.Dto;

import javax.validation.constraints.NotNull;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.Data;


@Data
@ApiModel(value="Project Data Transfer Object")
public class ProjectDto {
	

	@ApiModelProperty(value=" ProjectDto ID")
	private Long id;
	
	@NotNull
	@ApiModelProperty(required=true,value=" Name of ProjectDto ")
	private String projectName;
	@NotNull
	@ApiModelProperty(required=true,value=" Code of ProjectDto ")
	private	String projectCode;
	
	@NotNull
	@ApiModelProperty(required=true,value=" Project Manager Id ")
	private	Long managerId;
	
	@ApiModelProperty(required=true,value=" Project Manager Name  ")
	private	UserDto manager;

	public ProjectDto(Long id, @NotNull String projectName, @NotNull String projectCode, @NotNull Long managerId) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.managerId = managerId;
	}


	public UserDto getManager() {
		return manager;
	}

	public void setManager(UserDto manager) {
		this.manager = manager;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public ProjectDto() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	
	
}
